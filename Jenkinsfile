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
                sh 'mvn clean package'
            }
        }

        stage('Deploy on server'){

            when { branch 'dev' }
            steps {
                sh 'TODO Deploy to dev server'
            }
        }
    }
    
    post {
        failure {
            sh 'echo Build Failed, TODO send email !!!!!!!!!!!!'
        }
    }
}
