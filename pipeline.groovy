


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

	


def build() {
	
	def registry = "saikumarzemoso/mavenimage"
    def   registryCredential = 'dockerid'
	
	
				 
	
				 
	
	 node('jenkins-master') {
		 
		
		 
		         stage("checkout") {
           
                
                git  url:' https://github.com/paulczar/spring-helloworld.git'
		sh "ls -l"
				 
				 
	def VERSION = readMavenPom().getVersion()
	def groupId=readMavenPom().getGroupId()
	def artifactid=readMavenPom().getArtifactId()
	echo "##############groupid##########"
	 echo groupId
	echo "##############artifactid##########"
	echo artifactid
	echo "$groupId" | tr . /
	
				 
	test=$("$groupId" | tr . /)
	echo "$test"
	
				 
            
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

