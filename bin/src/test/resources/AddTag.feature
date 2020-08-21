Feature: A User adds a tag to an existing photo

Background:
	Given user is on login page
	When user enters valid username into username field 
	And user enters valid password into password field 
	And user presses the login button 
	Then user should be redirected to their home page
	
Scenario:
	When user clicks on first photo
	And user types new tag into tag field
	And user clicks on the add tag button
	And user clicks on the save photo button
	Then the first photo should have a tag