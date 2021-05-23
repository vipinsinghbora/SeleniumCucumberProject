Feature: Customer
	@Smoke
	Scenario: Add a new Customer
		Given User launch chrome browser 
	When  User open url "https://admin-demo.nopcommerce.com/login" 
	And   User enter email as "admin@yourstore.com" and password as "admin" 
	And   Click on login 
	Then  User can view Dashboard 
	When  User click on Customer Menu 
	And   click on customer menu Item 
	And   click on Add new button 
	Then  User can view add new customer page 
	When  User enter customer info 
	And   click on save button 
	Then  User can view confirmation message "The new customer has been added successfully." 
	And   Close browser	