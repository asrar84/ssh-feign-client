pipelineJob("ssl-feign-client-pipe") {
    stages {
        stage('Build') {
            def myTestContainer = docker.image("maven:3-alpine")
            myTestContainer.pull()
            myTestContainer.inside("-v /root/.m2:/root/.m2") {
              sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            def myTestContainer = docker.image("maven:3-alpine")
            myTestContainer.pull()
            myTestContainer.inside("-v /root/.m2:/root/.m2") {
              sh 'mvn test'
            }
        }
    }
}