pipeline {

    agent any
    
    properties([pipelineTriggers([githubPush()])])

    tools {
        /* the tool name must be pre-configured in Jenkins under Manage Jenkins -> Global Tool Configuration */
        maven 'MAVEN_HOME'
    }
    
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
        sh 'echo congratulations!!! You did it'
    }
}
