pipeline {
	agent any
	
		tools {
		maven 'maven_tool1'
		jdk 'JDK_17'
			}

	environment {
		DOCKERHUB_CREDENTIALS = credentials('DOCKERHUB_CREDENTIALS_ID_TEST')
	}

	stages {
        stage('Pull GitHub') {
            steps {
                checkout scmGit(branches: [[name: "*/main"]], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RouachedHoussemEddine/spring_pipe']])
				sh 'mvn clean install'
			
			}
        }
	
	    
		stage('Build Docker image') {
            steps {
                script {
                    sh "docker build  -t spring_pipe ."
                }
            }

        }
		
		
		stage('Push Docker image'){
						script {
                            withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS_ID_TEST', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                                    def dockerHubUsername = "azzinoth5"
                                    def repo = "spring_pipe"
                                    def dockerHubRepo = "${dockerHubUsername}/${repo}" 
                                    def dockerHubTag = "v1.0" //desired tag/version
                                    sh "docker tag spring_pipe ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker push ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker logout"   
                            }
						}		
		
		}
		
		
		

//
//		stage('Test'){
//			steps{
//				bat "mvn test"
//			}
//		}
//
//		stage('Deploy') {
//			steps {
//			    bat "mvn jar:jar deploy:deploy"
//			}
//		}
	}
}