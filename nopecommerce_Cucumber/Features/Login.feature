Feature: Login 

Scenario: Successful Login the Valid Credentials 
	Given User Launch Chrome Browser
	When User open Url "https://admin-demo.nopcommerce.com/Login"
	 And user enter email as "admin@yourstore.com" and password as "admin"
	 And Click on Login
	 Then Page title should be "Dashboard / nopCommerce administration"
	 When user click on logout 
	
	 And close browser
	 