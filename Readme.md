MavenAssignmentFinal
=======================
This is an assignment submitted as the exit criteria for Automation Training for fresher batch 2021. This project utilies Page Object Model (POM) which is a Java Framework that provides ability to describe your web application as a hierarchy of models. This project aims to automate 20+ test cases for this [url](https://www.redbus.in/). Some cases are bound to fail for the purpose of this assignment. 

Use the following steps to execute this project.
1. Extract the zip and then place it in your workspace.
2. Open a terminal window/command prompt from that location.
3. `mvn clean` : to build the project
4. `mvn install` to run the test cases.

Or use runner.bat file


## Folder structure                     
    ├── src/main/java                     
       ├── helper
       	├── Calendar.java
       ├── pages                
       	├── AgentRegistrationPage.java
       	├── CareerPage.java
       	├── ContactUsPage.java
       	├── FAQPage.java
       	├── GlobalSites.java
       	├── HomePage.java
       	├── LoginPage.java
       	├── ManageBookingMenu.java
       	├── OperatorPage.java
       	├── PrivacyPage.java
       	├── RPoolPage.java
    ├── src/test/java      
		├── listener
       	├── Excel.java 
       	├── MethodInterceptor.java                   
      	├── tests	
    	 	├── AgentRegistrationTest.java
    		├── AppLinkMobileTest.java
    		├── BaseTest.java
    		├── CareerPageTest.java
    		├── ContactUsTest.java
    		├── FAQTest.java
    		├── GlobalSitesTest.java
    		├── HomePageSearchTest.java
    		├── LoginTest.java
    		├── ManageBookingTest.java
    		├── OperatorSearch.java
    		├── PrivacyLinkTest.java
    		├── RPoolAppDownloadTest.java
    		├── SocialMediaTest.java   			    			   
      	├── util                        
       	├── ExcelDataFetch.java
       	├── ScreenShots.java
       	├── WebDriverContorl.java
    ├── Drivers            
    ├── FailedScreenshots                       
    ├── log                   
    ├── Reports                   
    ├── Resources
          ├── config.properties
          ├── log4j.properties     
    ├── src              
    ├── target          
    ├── pom.xml                   
    ├── test-output     
    ├── data.xlsx
    ├── docker-compose.yml
    ├── Jenkins Integration Process.docx
    ├── pom.xml
    ├── testng.xml
    ├── runner.bat
    └── README.md
    
## Requirements
* Java 8

## Dependencies
* selenium-java 3.141.59
* testng 6.14.3
* extentreport 2.41.2
* commons-io 2.8.0
* log4j 1.2.17
* poi 4.1.2
* poi-ooxml 4.1.2

Note : The dependencies are already present in pom.xml file.

## Resources
The Resources folder contains the config.properties file which has all the test configurations (eg, url, browser, headless mode, screenshot directory, browser driver locations  etc).You can try out different values from this properties file.
You may use browser as 'chrome' or 'firefox'.  
It also contains the log4j.properties file.

##Reports
test_reports.html file is generated once you run all the test cases. You can check you test reports from this file.

## Log
This folder contains all the log files of the test cases. Check the application.html file to view the logs.

##Failed Screenshots
This folder contains screenshots of all the failed test cases with their method names followed by 'TestFailed.jpg' as their file name.

#Pages module
Contains all the necessary WebElements for the tests and all the helper functions for execution of a test case.

##Helper module
Contains a helper function for handling of calendars in the test cases.

##Listener module
Excel.java file fetches information from the excel sheet regarding the execution modes of the test cases. (Yes if you want to run the test case and No of not). MethodInterceptor.java contains the code required for execuiton of only the test cases marked as "yes" by the end user.

##Util module
1. ScreenShots.java : This file returns the location where the screenshot of any failed test case is stored.
1. ExcelDataFetch.java : This file fetches data for all test cases from the Excel sheet based on sheet name, column name and row number.
1. WebDriverContorl.java : Helper function for initializing web driver according to config.properties file.

##tests module
Contains all the test scenarios.

##data.xlsx
* This is the excel sheet which contains all the test data. User can change the ExecutionRequired column of the first worksheet to decide which test cases to run. 
* 'Yes' means the test will execute and 'No' means a test won't execute.

##Jenkins  module
* The test has been integrated with github and jenkins.
* To integrate with jenkins use : https://github.com/rohanchoudharyy/AutomationQA2021.git
* A screenshot of the jenkins integration is present in the project directory.
* A word file explaining all the steps for jenkins integration is present in the project directory.

##Docker  module
Steps to set up docker:
1. Install docker in your system
2. Pull the following docker images :
3. `docker pull selenium/hub`
4. `docker pull selenium/node-chrome`
5. `docker pull selenium/node-firefox`
6. use the docker-compose.yml file for the next step
7. `docker-compose -f /path/to/docker-compose.yml up -d`
8. This makes the grid up and running. you can verify it by visiting : `http://localhost:4444/grid/console`
9. To run the test cases on docker, set browser = chrome/firefox , headless = no and docker = true in the config.properties file.
10. To run the test cases parallally in two browsers in docker : Use the contents of testNg_parallel_browser.xml file and comment lines 106 - 109 and uncomment lines 111 - 116 in the BaseTest.java files present in the tests module of src/test/java. A sample screenshot of running test cases parallally in two browsers is present in the project folder.

##Problems
1. Sometimes the test cases would fail as it won't be locate the WebElements. Please re-run the test in such cases.
The project comes with a test_reports.html file, you may check the test reports before running any tests, to see how it should behave normally.
2. I was able to run test cases parallaly in docker but when trying to run the test cases parallally in docker, there were a lot errors while running the test cases and it stops abruptly. 
3. Test cases are failing randomly in headless mode. Thread.sleep could avoid these mistakes but I have tried not to use them unnecessarily. 
4. There is no headless mode available for Edge

