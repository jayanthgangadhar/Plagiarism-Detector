pipeline {
   agent {
       docker {
           image 'maven:3-alpine'
           args '-v /root/.m2:/root/.m2'
       }
   }

   stages {
       stage('Build') {
           steps {
               echo "Building"
               sh 'mvn -f phaseC/plagiarism-detector compile'
               sh 'mvn -f phaseC/plagiarism-detector package'
           }
       }
       stage('Test'){
           steps {
               echo "Testing"
               sh 'mvn -f phaseC/plagiarism-detector test'
           }
       }
	    stage('SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') {
                        sh 'mvn -f phaseC/plagiarism-detector clean install'
                        sh 'mvn -f phaseC/plagiarism-detector sonar:sonar'
                }
            }
        }

      	stage('Quality') {


          steps {
            sh 'sleep 50'
            timeout(time: 1, unit: 'HOURS') {
               retry(5) {
                  script {
                    def qg = waitForQualityGate()
                    if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
				}
            }
          }
        }
      }
    }
	   
    }
}
