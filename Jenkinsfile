pipeline {
    agent any
    stages {
        stage('Access Aws K8 Cluster') {
            steps {
                sh 'gcloud auth configure-docker'
            }
        }
        stage('Build Docker Image') {
             steps {
                sh 'sudo docker build -t --tag gcr.io/inima-smart/producer-consumer:$GIT_COMMIT .'
            }
        }
        stage('Pull Docker Image to Registry') {
             steps {
                sh 'sudo docker push gcr.io/inima-smart/producer-consumer:$GIT_COMMIT'
            }
        }
        stage('Deploy on K8 Cluster') {
             steps {
                sh '/usr/local/bin/helm upgrade --install producer-consumer helm/ --set image.tag=:$GIT_COMMIT --wait'
            }
        }
    }
}