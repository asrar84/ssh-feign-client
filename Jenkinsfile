pipeline {
  agent {
    docker {
      image 'maven:3.5-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('build') {
      parallel {
        stage('build') {
          steps {
            git(url: 'https://github.com/asrar84/ssl-feign-client.git', changelog: true, credentialsId: 'github', poll: true)
            sh 'sh \'mvn clean package\''
            stash(name: 'buildDtash', allowEmpty: true, includes: 'target/*.jar')
          }
        }
        stage('build1') {
          steps {
            git(url: 'https://github.com/asrar84/ssl-feign-client.git', changelog: true, credentialsId: 'github', poll: true)
            echo 'build1'
            sh 'mvn package'
            stash(name: 'build1Stash', includes: 'target/*.jar')
          }
        }
        stage('build2') {
          steps {
            git(url: 'https://github.com/asrar84/ssl-feign-client.git', changelog: true, credentialsId: 'github', poll: true)
            echo 'build2'
            sh 'mvn package'
            stash(name: 'build3Stash', includes: 'target/*.jar')
          }
        }
      }
    }
    stage('imageDeploy') {
      parallel {
        stage('imageDeploy') {
          steps {
            unstash 'buildStash'
            echo 'docker image'
          }
        }
        stage('image2Deploy') {
          steps {
            unstash 'build1Stash'
            echo 'docker image1'
          }
        }
        stage('') {
          steps {
            unstash 'build2Stash'
            echo 'docker image2'
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