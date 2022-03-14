
def pomversion() 
{
	
stage('extract the pom version') 
		{
	
node('jenkins-master')
	{
			
	git  url:' https://github.com/paulczar/spring-helloworld.git'
	echo "okkk"	
	sh 'groupId=readMavenPom().getGroupId()'
	sh 'artifactid=readMavenPom().getArtifactId()'
	echo "okkk2"
	sh 'find="." '
	sh 'replace="/" '
				
	sh 'result="${$groupId//$find/$replace}/$artifactid" '
	sh 'echo $result'

		}
	}
}
			

return this

