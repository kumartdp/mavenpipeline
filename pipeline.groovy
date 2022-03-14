


def helloworld(){
  
  echo "helloworld"
  
  
}

def addition() {
  
   def x = 5; 
      def y = 10; 
      def z = 8; 
		
      //Performing addition of 2 operands 
      println(x+y); 
  
   echo "helloworld"
  
}
def pomversion() {
	stage('extract the pom version') {
		node('jenkins-master'){
			dir(.){
			git  url:' https://github.com/paulczar/spring-helloworld.git'
				
		
	env.groupId=readMavenPom().getGroupId()
	env.artifactid=readMavenPom().getArtifactId()
	env.find="."
	env.replace="/"
				
	env.result=${$groupId//$find/$replace}/$artifactid
	echo $result
	}
		}
		}
	}
			
			
				
		     
	
	

	


def build() {
	
	def registry = "saikumarzemoso/mavenimage"
    def   registryCredential = 'dockerid'
	
	
				 
	
				 
	
	 node('jenkins-master') {
		 
		
		 
		         stage("checkout") {
           
                
                git  url:' https://github.com/paulczar/spring-helloworld.git'
		sh "ls -l"
				 
				 
	
	
	
				 
            
        }
        
        stage("build") {
            
           
            
                sh " mvn clean install"
            
            
        }
        
         stage("test") {
            
           
            
                sh " mvn test"
            
            
        }
		 
 stage('Building image') {
      
          dockerImage = docker.build registry + ":"+ VERSION+".$BUILD_NUMBER"
	
        
    }
    stage('Deploy Image') {
  
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        
        
	 }
		 
	 }
  
   echo "helloworld"
  
  
  
}
def deployimage(){
  
   echo "helloworld"
  

}

return this

