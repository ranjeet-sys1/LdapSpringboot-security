pipeline {
    agent any
    tools{
        jdk "jdk1.8.0_261.jdk"
    }

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven 3.8.1') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven 3.8.1') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven 3.8.1') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}