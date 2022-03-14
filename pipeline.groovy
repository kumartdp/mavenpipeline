
def pomversion() 
{
	
node('jenkins-master')
	{
			stage('extract the pom version') 
		{
			
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
			


return this

