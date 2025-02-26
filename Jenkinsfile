pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/silpps/Aikido'
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
    }
}
