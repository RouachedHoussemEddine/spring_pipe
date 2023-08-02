pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	tools {
		jdk 'java-17'
	}

	stages {
        stage('Pull GitHub') {
            steps {
                checkout scmGit(branches: [[name: "*/main"]], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RouachedHoussemEddine/spring_pipe']])
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