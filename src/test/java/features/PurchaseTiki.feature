@purchase
Feature: Purchase
	As a customer
	I want to find product information and Purchase
	
	Scenario: Purchase of tiki
		When I input to search textbox with "apple"
		And I click to search button
		And I click to Tiki Now
		And I select the product
		Then Verify product information has been selected
		