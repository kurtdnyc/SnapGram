Feature: A user can delete one of the tags on an existing photo

Background:
	Given user is on login page
	When user enters valid username into username field 
	And user enters valid password into password field 
	And user presses the login button 
	Then user should be redirected to their home page
	
Scenario:
	When user clicks on first photo
	And clicks on the x next to the first tag for that photo
	And user clicks on the save photo button
	Then there should be one more tag