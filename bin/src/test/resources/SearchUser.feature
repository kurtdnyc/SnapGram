Feature: A logged in user can search for other users

Background:
	Given user is on login page
	When user enters valid username into username field 
	And user enters valid password into password field 
	And user presses the login button 
	Then user should be redirected to their home page
	
Scenario Outline: user searches other user and finds their homepage
	When user clicks on user lookup button
	And types in a valid "<username>"
#	Then "<username>" photos should appear
	Then the add photo button should not be present
	When user clicks on user lookup button
	And clears the input
	Then the add photo button should be present
	
Examples:
	|username|
	|mike99|
#	|samWiseTheBrave|
#	|matt1992|