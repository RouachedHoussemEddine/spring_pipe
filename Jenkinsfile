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
				dir('/var/lib/jenkins/workspace/spring_pipe/Customer_Support_Notifications') {
                sh 'mvn clean install' 
            }
				dir('/var/lib/jenkins/workspace/spring_pipe/Entry_Exit_Control') {
                sh 'mvn clean install'
            }    
				dir('/var/lib/jenkins/workspace/spring_pipe/Parking_Space_Allocation') {
                sh 'mvn clean install'
            }    
				dir('/var/lib/jenkins/workspace/spring_pipe/Payment_Processing') {
                sh 'mvn clean install'
            }    
				dir('/var/lib/jenkins/workspace/spring_pipe/User_Management') {
                sh 'mvn clean install'
			}
			}
        }


		stage('Build Docker image Customer_Support_Notifications') {
            steps {
                dir('/var/lib/jenkins/workspace/spring_pipe/Customer_Support_Notifications'){
                script {
                    sh "docker build  -t customersupportnotifications ."
                }
            }
                }
                }
		stage('Push Docker image Customer_Support_Notifications'){
					steps {
						script {
                            withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS_ID_TEST', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                                    def dockerHubUsername = "azzinoth5"
                                    def repo = "customersupportnotifications"
                                    def dockerHubRepo = "${dockerHubUsername}/${repo}" 
                                    def dockerHubTag = "v1.0" //desired tag/version
                                    sh "docker tag customersupportnotifications ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker push ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker logout"   
                            }
						}		
					}
		}
	}




		stage('Build Docker image Entry_Exit_Control') {
            steps {
                dir('/var/lib/jenkins/workspace/spring_pipe/Entry_Exit_Control'){
                script {
                    sh "docker build  -t entryexitcontrol ."
                }
            }}
                }

		stage('Push Docker image Entry_Exit_Control'){
					steps {
						script {
                            withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS_ID_TEST', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                                    def dockerHubUsername = "azzinoth5"
                                    def repo = "entryexitcontrol"
                                    def dockerHubRepo = "${dockerHubUsername}/${repo}" 
                                    def dockerHubTag = "v1.0" //desired tag/version
                                    sh "docker tag entryexitcontrol ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker push ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker logout"   
                            }
						}		
					}
		}


		stage('Build Docker image Parking_Space_Allocation') {
            steps {
                sdir('/var/lib/jenkins/workspace/spring_pipe/Parking_Space_Allocation'){
                script {
                    sh "docker build  -t parkingspaceallocation ."
                }
            }
            }
            }
		stage('Push Docker image Parking_Space_Allocation'){
					steps {
						script {
                            withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS_ID_TEST', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                                    def dockerHubUsername = "azzinoth5"
                                    def repo = "parkingspaceallocation"
                                    def dockerHubRepo = "${dockerHubUsername}/${repo}" 
                                    def dockerHubTag = "v1.0" //desired tag/version
                                    sh "docker tag parkingspaceallocation ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker push ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker logout"   
                            }
						}		
					}
		}



		stage('Build Docker image Payment_Processing') {
            steps {
                dir('/var/lib/jenkins/workspace/spring_pipe/Payment_Processing'){
                script {
                    sh "docker build  -t paymentprocessing ."
                }
            }
            }
        }
		stage('Push Docker image Payment_Processing'){
					steps {
						script {
                            withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS_ID_TEST', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                                    def dockerHubUsername = "azzinoth5"
                                    def repo = "paymentprocessing"
                                    def dockerHubRepo = "${dockerHubUsername}/${repo}" 
                                    def dockerHubTag = "v1.0" //desired tag/version
                                    sh "docker tag paymentprocessing ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker push ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker logout"   
                            }
						}		
					}
		}


		stage('Build Docker image User_Management') {
            steps {
                dir('/var/lib/jenkins/workspace/spring_pipe/User_Management'){
                script {
                    sh "docker build  -t usermanagement ."
                }
                }
            }
        }
		stage('Push Docker image User_Management'){
					steps {
						script {
                            withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS_ID_TEST', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                                    def dockerHubUsername = "azzinoth5"
                                    def repo = "usermanagement"
                                    def dockerHubRepo = "${dockerHubUsername}/${repo}" 
                                    def dockerHubTag = "v1.0" //desired tag/version
                                    sh "docker tag usermanagement ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker push ${dockerHubRepo}:${dockerHubTag}"
                                    sh "docker logout"   
                            }
						}		
					}
		}
	


	


	


	






    post {
        success {
            echo 'Build succeeded!'
        }
        
        failure {
            echo 'Build failed!'
        }
    }


}