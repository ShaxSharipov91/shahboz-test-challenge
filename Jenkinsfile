pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                sh "docker build -t='shax_alpine_server_image' ."
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([$class: 'UsernamePasswordMultiBinding', credentialsId:'docker_hub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']) {
                    //sh
			        sh "docker login --username=${USERNAME} --password=${PASSWORD}"
			        sh "docker push shax_alpine_server_image:latest"
			    }
            }
        }
    }
}