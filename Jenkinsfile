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
                bat 'docker run -d -p 6060:8080 parking-app'
            }
        }
    }
}