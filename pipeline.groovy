
def pomversion() 
{
	
stage('extract the pom version') 
		{
	
node('jenkins-master')
	{
			
	git  url:' https://github.com/paulczar/spring-helloworld.git'
	echo "okkk"
	sh '''
	
	str="com.ge.avitas.gateway"
	find="."
	replace="/"
	str2="apigateway-svc"
	result=${str//$find/$replace}/${str2}
	echo $result
	export res=${result} '''
	
		
	 // sh 'groupId=readMavenPom().getGroupId()'
	// sh 'artifactid=readMavenPom().getArtifactId()'
	// echo "okkk2"
	// sh 'find="." '
	// sh 'replace="/" '
				
	// sh 'result="${$groupId//$find/$replace}/$artifactid" '
	// sh 'echo $result'

		}
	}
}
			

return this

