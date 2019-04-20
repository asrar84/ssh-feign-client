pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        git(url: 'https://github.com/asrar84/ssl-feign-client.git', changelog: true, credentialsId: 'github', poll: true)
        sh 'sh \'mvn clean package\''
      }
    }
  }
}