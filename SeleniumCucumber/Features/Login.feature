Feature: Login
	Scenario: Successful login with valid credential
		Given User launch chrome browser
		When  User open url "https://admin-demo.nopcommerce.com/login"
		And   User enter email as "admin@yourstore.com" and password as "admin"
		And   Click on login
		Then  Page title should be "Dashboard / nopCommerce administration"
		When  User click on logout link
		Then  Page title should be "Your store. Login"
		And   Close browser
		
		
    Scenario Outline: Login Data Driven
		Given User launch chrome browser
		When  User open url "https://admin-demo.nopcommerce.com/login"
		And   User enter email as "<email>" and password as "<password>"
		And   Click on login
		Then  Page title should be "Dashboard / nopCommerce administration"
		When  User click on logout link
		Then  Page title should be "Your store. Login"
		And   Close browser
		
		Examples:
		   |  email | password  |
		   |admin1@yourstore.com | admin123|
		   |admin@yourstore.com | admin |	