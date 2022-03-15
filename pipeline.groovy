
def pomversion() 
{
	
stage('extract the pom version') 
		{
	
node('jenkins-master')
	{
			
	git  url:' https://github.com/paulczar/spring-helloworld.git'
	pom="pom.xml"
	groupId=$(echo "cat //*[local-name()='project']/*[local-name()='groupId']" | xmllint --shell $pom | sed '/^\/ >/d' | sed 's/<[^>]*.//g')
	artifactId=$(echo "cat //*[local-name()='project']/*[local-name()='artifactId']" | xmllint --shell $pom | sed '/^\/ >/d' | sed 's/<[^>]*.//g')
	version=$(echo "cat //*[local-name()='project']/*[local-name()='version']" | xmllint --shell $pom | sed '/^\/ >/d' | sed 's/<[^>]*.//g')
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

