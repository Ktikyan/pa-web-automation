pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven(maven : '') {
                    bat 'mvn clean compile'
                }
            }
        }
        stage('Test') {
            steps {
                withMaven(maven : '') {
                    bat 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                withMaven(maven : '') {
                    bat 'mvn deploy'
                }
            }
        }
    }
}