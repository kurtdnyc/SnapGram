Feature: Logged in user can upload a new photo

Background: user is on upload photo page
	Given user is on login page
	When user enters valid username into username field 
	And user enters valid password into password field 
	And user presses the login button 
	Then user should be redirected to their home page
	When user clicks on upload photo button
	Then user should be redirected to upload photo page
	
Scenario Outline: user uploads photo of reasonable size
	When "<image>" is selected from computer
	And enters "<name>" of photo into name field
	And enters "<description>" of photo into the description field
	And clicks on the upload photo button
	Then user should be redirected to their home page
	
Examples:
	|image|name|description|
	|C:\Users\Mnaum\Desktop\project2_images\frodoAndSam.jfif|Frodo and Sam|Frodo and Sam right after destroying the ring|
	|C:\Users\Mnaum\Desktop\project2_images\frodoAtRivendell.jfif|Frodo at Rivendell|Frodo accepting the quest at Rivendell|
	|C:\Users\Mnaum\Desktop\project2_images\frodoSamAndGollumn.jfif|Frodo with Sam and Gollum|Frodo, Sam, and Gollum looking at the elephants|

#Scenario Outline: user uploads photo of reasonable size with tags
#	When "<image>" is selected from computer
#	And enters "<name>" of photo into name field
#	And enters "<description>" of photo into the description field
#	And enters "<tag>" to photo
#	And clicks on the upload photo button
#	Then user should be redirected to their home page
#	
#Examples:
#	|image|name|description|tag|
#	|C:\Users\Mnaum\Desktop\project2_images\frodoAndSam.jfif|Frodo and Sam|Frodo and Sam right after destroying the ring|
#	|C:\Users\Mnaum\Desktop\project2_images\frodoAtRivendell.jfif|Frodo at Rivendell|Frodo accepting the quest at Rivendell|
#	|C:\Users\Mnaum\Desktop\project2_images\frodoSamAndGollumn.jfif|Frodo with Sam and Gollum|Frodo, Sam, and Gollum looking at the elephants|
#	
	
	