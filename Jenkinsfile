pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/trchandana2005/contact-app'
            }
        }

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
                bat 'docker build -t payment-app .'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 7071:8080 payment-app'
            }
        }
    }
}