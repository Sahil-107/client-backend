pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                sshagent(['ec2-ssh-credentials']) {
                    sh '''
                          # Copy WAR file to the second EC2 instance
                          scp target/*.war ec2-user@54.81.67.19:/opt/tomcat/webapps/

                          # Restart Tomcat on that instance
                          ssh ubuntu@54.81.67.19 "sudo systemctl restart tomcat"
                       '''
                }
            }
        }
    }
}