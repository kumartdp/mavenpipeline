
def pomversion() 
{
	
stage('extract the pom version') 
		{
	
node('jenkins-master')
	{
			
	git  url:' https://github.com/paulczar/spring-helloworld.git'
	echo "okkk"
	env.groupId=readMavenPom().getGroupId()
	env.artifactId=readMavenPom().getArtifactId()
	
	sh '''
	echo $groupId

	str=$groupId
	find="."
	replace="/"
	str2=$artifactId
	result=${str//$find/$replace}/${str2}
	echo $result
	export resultantpath=${result} '''
	echo $resultantpath
	
		
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

