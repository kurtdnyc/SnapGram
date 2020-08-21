Feature: User edits one of their photos

Background: User is on homepage
	Given user is on login page
	When user enters valid username into username field 
	And user enters valid password into password field 
	And user presses the login button 
	Then user should be redirected to their home page
	
Scenario Outline:
	When user clicks on first photo
	And user enters "<newTitle>" in title field
	And user enters "<newDescription>" in description field
	And user clicks on the save photo button
	Then first photo will have "<newTitle>" as its title
	And first photo will have "<newDescription>" as its description
	
Examples:
	|newTitle|newDescription|
	|Updated Title|Updated description|
	