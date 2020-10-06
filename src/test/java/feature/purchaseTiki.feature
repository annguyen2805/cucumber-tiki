@purchase
Feature: Purchase
	As a customer
	I want to find product information and Purchase
	
	Scenario: Purchase of tiki
		Given I open application
		When I input to search textbox with "apple"
		And I click to search button
		And I click to Tiki Now
		And I select the 5th product
		Then Verify product information has been selected
		