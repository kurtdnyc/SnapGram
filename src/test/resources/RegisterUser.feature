Feature: Register user

Background:
	Given user is on login page
	When user clicks on sign up button
	Then user is on register user page

Scenario Outline: User enters new user
	When user enters "<username>" into the new username field
	And user enters new "<password>" into the new password field
	And user enters new first name into the new first name field
	And user enters new last name into the new last name field
	And clicks on the submit new user button
	And clicks on the sign in button
	Then user should be redirect to login page
	
Examples:
	|username|password|
	|user1|pass1|
	|user2|pass2|
	|user3|pass3|
	
Scenario: User enters existing user
	When user enters a username already registered into the new username field
	And user enters new password already registered into the new password field
	And user enters new first name into the new first name field
	And user enters new last name into the new last name field
	And clicks on the submit new user button
	And clicks on the sign in button
	Then user should recieve an alert saying that user already exists
	