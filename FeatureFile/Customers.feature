Feature: Customers

Background: Below are the common steps for every scenario
Given User Launch Chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And Click on login
Then User can view Dashboard

@sanity
Scenario: Add a new customer

When User click on customers Menu
And click on customers Menu Item
And click on Add new button
Then User can view add new customer page
When User enter customer info
And click on Save button
Then User can view confirmation message "The new customer has been added successfully.";
And close browser

@regression
Scenario: Search Customer by EMailID
 
When User click on customers Menu
And click on customers Menu Item
And Enter customer Email
When Click on search button
Then User should found Email in the Search table
And close browser