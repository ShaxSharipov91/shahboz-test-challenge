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
			    withCredentials([usernamePassword(credentialsId: 'docker_hub', usernameVariable: 'user', passwordVariable: 'pass' )]) {
                    //sh
			        sh "docker login -u ${user} -p ${pass}"
			        sh "docker push shax_alpine_server_image:latest"
			    }
            }
        }
    }
}