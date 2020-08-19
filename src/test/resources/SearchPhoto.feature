Feature: A logged in user can search for photos

Background:
	Given user is on login page
	When user enters valid username into username field 
	And user enters valid password into password field 
	And user presses the login button 
	Then user should be redirected to their home page
	
Scenario: user searches by tag
	When user clicks on the search photo button
	And types in tag name
	Then only photos with that tag name will appear
	
Scenario: user searches by image name
	When user clicks on the search photo button
	And user types in image name
	Then only photos with that image name will appear