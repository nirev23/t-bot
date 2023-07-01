pipeline {
    agent any
    environment {
        REPO = "https://github.com/nirev23/t-bot"
        BRANCH = "main"
    }
    stages {
        stage('clone') {
            steps {
                echo 'CLONE REPOSITORY'
                  git branch: "${BRANCH}", url: "${REPO}"
            }
        }    
        stage('test') {
            steps {
                echo 'TEST EXECUTION STARTED'
                sh 'make test'
            }
        }    
        stage('image') {
            steps {
                echo 'CREATE IMAGE EXECUTION STARTED'
                sh 'make image TARGETARCH=$ARCH TARGETOS=$OS'
            }
        }
        stage('push') {
            steps {
                script{
                    docker.withRegitry( '', 'dockerhub' ) }
                    sh 'make push'
            }
        }
    }
}
