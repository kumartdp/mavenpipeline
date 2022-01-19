


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
	
	 node('jenkins-master') {
		 
		
		 
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
        
	 }
  
   echo "helloworld"
  
  
  
}
def deployimage(){
  
   echo "helloworld"
  

}

return this

