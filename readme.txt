
How to run this project: 
things to verify maven is installed and environment variables contains its path
chrome driver has correct path 


1- Now we have this project in Maven, you can see pom.xml file for all its dependencies 
2- You can execute this using command 


mvn test 


3- this test command will run your test cases 

4- Now if you need to get a report, it already have a maven-surefire-report-plugin installed so you need to run command 

mvn surefire-report:report

This will create a report in the target/site directory of your project.


