Feature: Log out a user who is logged in

Background: 
	Given user is on login page

Scenario Outline: User enters valid credentials and is redirected 
	When user enters "<username>" into username field 
	And user enters "<password>" into password field 
	And user presses the login button 
	Then user should be redirected to their home page 
	When user clicks on the header bar
	And user clicks the sign out button
	Then the user should be redirected back to the login page
	
	Examples: 
		|username|password|
		|ringbearer|shire123|
		|matt1992|bestPassEva|