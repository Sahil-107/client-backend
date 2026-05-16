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
                          scp target/*.war ec2-user@3.81.205.195:/usr/share/tomcat9/webapps/

                          # Restart Tomcat on that instance
                          ssh ec2-user@3.81.205.195 "sudo systemctl restart tomcat9"
                       '''
                }
            }
        }
    }
}