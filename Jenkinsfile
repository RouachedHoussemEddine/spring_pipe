pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	stages {
        stage('Pull GitHub') {
            steps {
                checkout scmGit(branches: [[name: "*/main"]], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RouachedHoussemEddine/spring_pipe']])
				sh 'mvn clean install'
			
			}
        }
		stage('Build'){
			steps {
				bat "mvn clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				bat "mvn test"
			}
		}

		stage('Deploy') {
			steps {
			    bat "mvn jar:jar deploy:deploy"
			}
		}
	}
}