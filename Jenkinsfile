
pipeline {
    
    environment {
    registry = "saikumarzemoso/mavenimage"
    registryCredential = 'dockerid'
  }
    agent any
    
    stages{
        
        
        stage("checkout") {
            
            steps {
                
                git  url:' https://github.com/paulczar/spring-helloworld.git'
            }
        }
        
        stage("build") {
            
            steps{
            
                sh " mvn clean install"
            
            }
        }
        
         stage("test") {
            
            steps{
            
                sh " mvn test"
            
            }
        }
        
        stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    }
    
    
   
}
