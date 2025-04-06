pipeline {
    agent any

    tools {
        jdk 'jdk-21'            // Make sure this matches your Jenkins JDK install name
        maven 'maven-3.8'       // Make sure this matches your Jenkins Maven install name
    }

    environment {
        JAVA_HOME = tool name: 'jdk-21', type: 'jdk'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('📥 Checkout') {
            steps {
                checkout scm
            }
        }

        stage('🔧 Build') {
            steps {
                echo 'Compiling and packaging the Spring Boot app...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('🧪 Run Tests') {
            steps {
                echo 'Executing unit tests...'
                bat 'mvn test'
            }
        }

        stage('🚀 Run App') {
            steps {
                echo 'Running the Spring Boot application on port 7776...'
                bat 'java -jar target\\customer-service.jar --server.port=7776'
                // ^ If you didn't set finalName, use: customer-service-0.0.1-SNAPSHOT.jar
            }
        }
    }

    post {
        success {
            echo '✅ Build and deployment succeeded!'
        }
        failure {
            echo '❌ Build or test failed. Check logs for errors.'
        }
        always {
            echo '🧹 Cleaning workspace...'
            deleteDir()
        }
    }
}
