
How to run this project: 
things to verify maven is installed and environment variables contains its path
chrome driver has correct path 


1- Now we have this project in Maven, you can see pom.xml file for all its dependencies 
2- You can execute this using command which runs all tests 


mvn test 


3- this test command will run your test cases 

4- Now if you need to get a report, it already have a maven-surefire-report-plugin installed so you need to run command 

mvn surefire-report:report

This will create a report in the target/site directory of your project. But as we add target directy in 
.gitignore so you might not able to see it in github



//// to generate HTML report use command 
mvn test site -P test-report

// to run endtoend class or any specific file command is 
mvn -Dtest=EndToEnd test 



I want to change this project in Page object model 

First i have to build page for all available pages, inside those page i have to store locators and functions 

We can also have a baseclass that will be helpful for basic actions like 
1- verify page title 
2- verify element visible 
3- wait for element 
4- verify element is clickable 
5- verify element is not clickable 






