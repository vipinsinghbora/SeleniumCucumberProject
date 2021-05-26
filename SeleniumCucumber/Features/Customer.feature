Feature: Customer

 Background: Below are common steps for every scenario
    Given User launch chrome browser 
	When  User open url "https://admin-demo.nopcommerce.com/login" 
	And   User enter email as "admin@yourstore.com" and password as "admin" 
	And   Click on login 
	Then  User can view Dashboard 

	@Smoke
	Scenario: Add a new Customer
	When  User click on Customer Menu 
	And   click on customer menu Item 
	And   click on Add new button 
	Then  User can view add new customer page 
	When  User enter customer info 
	And   click on save button 
	Then  User can view confirmation message "The new customer has been added successfully." 
	And   Close browser	

	@Smoke
	Scenario: Customer Search by emailID
	When  User click on Customer Menu
	And   click on customer menu Item
	Then  User can view customer page  
	When  User enter email address
	When  Click on Search button
	Then  Customer record should be visible
	And   Close browser
	