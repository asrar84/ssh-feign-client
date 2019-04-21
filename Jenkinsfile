pipeline {
  agent any
  stages {
    stage('Build Test & DeployImage') {
      parallel {
        stage('Service1') {
          stages {
            stage('Build') {
              agent {
                docker {
                  image 'maven:3.5-alpine'
                  args '-v /root/.m2:/root/.m2'
                }
              }
              steps {
                git(url: 'https://github.com/asrar84/ssl-feign-client.git', changelog: true, credentialsId: 'github', poll: true)
                sh 'sh \'mvn clean package\''
                stash(name: 'build1Stash', allowEmpty: true, includes: 'target/*.jar')
              }
            }
            stage('Test') {
              steps {
                unstash 'build1Stash'
                echo 'mvn test'
              }
            }
            stage('Deploy') {
              steps {
                unstash 'build1Stash'
                echo 'docker image'
              }
            }
          }
        }
        stage('Service2') {
          stages {
            stage('Build') {
              agent {
                docker {
                  image 'maven:3.5-alpine'
                  args '-v /root/.m2:/root/.m2'
                }
              }
              steps {
                git(url: 'https://github.com/asrar84/ssl-feign-client.git', changelog: true, credentialsId: 'github', poll: true)
                sh 'sh \'mvn clean package\''
                stash(name: 'build2Stash', allowEmpty: true, includes: 'target/*.jar')
              }
            }
            stage('Test') {
              steps {
                unstash 'build2Stash'
                echo 'mvn test'
              }
            }
            stage('Deploy') {
              steps {
                unstash 'build2Stash'
                echo 'docker image'
              }
            }
          }
        }
      }
    }
    stage('Helm Install') {
      steps {
        echo 'Helm Install :-)'
      }
    }
  }
}