#Feature: Login a User 
#
#Background: 
#	Given user is on login page 
#	
#Scenario Outline: User enters valid credentials and is redirected 
#	When user enters "<username>" into username field 
#	And user enters "<password>" into password field 
#	And user presses the login button 
#	Then user should be redirected to their home page 
#	
#	Examples: 
#		|username|password|
#		|ringbearer|shire123|
#		|matt1992|bestPassEva|
#		
#Scenario Outline: user enters invalid credentials and alert appears 
#	When user enters "<username>" into username field 
#	And user enters "<password>" into password field 
#	And user presses the login button 
#	Then user should see an alert appear 
#	
#	Examples:
#	|username|password|
#	|badusername|badpassword|
#	|reallybadusername|reallybadpassword|
#	
#
#	