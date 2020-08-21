Feature: User deletes one of their photos

Background: User is on homepage
	Given user is on login page
	When user enters valid username into username field 
	And user enters valid password into password field 
	And user presses the login button 
	Then user should be redirected to their home page
	
Scenario:
	When user clicks on first photo
	And user clicks on the delete photo
	And clicks the yes button
	Then there will be one less photo
	
