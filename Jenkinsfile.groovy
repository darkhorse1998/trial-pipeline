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
					dockerImage = docker.build(registry+":$BUILD_NUMBER","./inside")
					}
				}
			}
			stage('Ping') {
				steps {
					sh 'docker run hkalita1998/kong-deck:$BUILD_NUMBER --kong-addr http://10.102.203.19:8001 ping'
				}
			}
		}
}	