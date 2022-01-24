pipeline {
	environment {
		registry = "hkalita1998/kong-deck"
		registryCredential = 'Dockerhub'
		dockerImage = ''
	}
	agent any
		stages {
			stage('Building our image') {
				steps{
					script {
					dockerImage = docker.build registry + ":$BUILD_NUMBER"
					}
				}
			}
		}
}	