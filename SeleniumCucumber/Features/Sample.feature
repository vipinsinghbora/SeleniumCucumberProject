Feature: Application Login
	Scenario: Logo presence on home Page
		Given I launch chrome browser
		When  I open hrm homepage
		Then  I verify the logo present on homepage
		And   Close browser