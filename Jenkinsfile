pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t parking-app .'
            }
        }

        stage('Run Container') {
            steps {
                bat '''
                docker stop parking-container || echo no container
                docker rm parking-container || echo no container
                docker run -d -p 7075:8080 --name parking-container parking-app
                '''
            }
        }
    }
}