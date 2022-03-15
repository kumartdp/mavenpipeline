
def pomversion() 
{
	
stage('extract the pom version') 
		{
	
node('jenkins-master')
	{
			
	git  url:' https://github.com/paulczar/spring-helloworld.git'
	pom="pom.xml"
	groupId=echo -e 'setns x=http://maven.apache.org/POM/4.0.0\ncat /x:project/x:groupId/text()' | xmllint --shell pom.xml | grep -v 
	echo "ok1"
	echo $groupId
		
		
		
		
		
		
		
		
		
		
	echo "okkk"
	env.groupId=readMavenPom().getGroupId()
	env.artifactId=readMavenPom().getArtifactId()
	env.res=''
		  def commit = sh (returnStdout: true, script: ''' 
	str=$groupId
	find="."
	replace="/"
	str2=$artifactId
	result=${str//$find/$replace}/${str2}
	echo $result 
	''')
		echo "${commit} "
	
	// echo $result
	// echo $groupId
	
		// export res=${result}
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

