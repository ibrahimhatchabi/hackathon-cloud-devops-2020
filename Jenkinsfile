pipeline {

    agent any
    
    stages {
        
        stage('Package') {
            when {
                anyOf {
                    branch 'dev'
                }
            }
            steps {
                sh 'cd todolist/ && ./mvnw clean package'
            }
        }

        stage('Deploying'){

            when { branch 'dev' }
            steps {
                sh 'echo TODO: Deploy to dev server'
            }
        }
    }
    
    post {
        failure {
            sh 'echo Build Failed, TODO send email !!!!!!!!!!!!'
        }
    }
}
