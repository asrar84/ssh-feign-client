pipelineJob("ssl-feign-client-pipe-iaac") {
    agent any
    stages {
        stage ('Checkout') {
          steps {
            git 'https://github.com/asrar84/ssl-feign-client.git'
          }
        }
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.5-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                git 'https://github.com/asrar84/ssl-feign-client.git'
                sh 'mvn clean package'
//                junit '**/target/surefire-reports/TEST-*.xml'
//                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
/*        stage('Deploy') {
          steps {
            input 'Do you approve the deployment?'
            sh 'scp target/*.jar jenkins@192.168.50.10:/opt/pet/'
            sh "ssh jenkins@192.168.50.10 'nohup java -jar /opt/pet/spring-petclinic-1.5.1.jar &'"
          }
        }*/
    }
}