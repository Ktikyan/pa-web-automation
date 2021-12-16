pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven(maven : 'maven_3.8.1') {
                    bat 'mvn clean compile'
                }
            }
        }
        stage('Test') {
            steps {
                withMaven(maven : 'maven_3.8.1') {
                    bat 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                withMaven(maven : 'maven_3.8.1') {
                    bat 'mvn deploy'
                }
            }
        }
    }
}