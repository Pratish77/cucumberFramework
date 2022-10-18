Feature: Login

@sanity
Scenario: Successful Login with Valid Credentilas
Given User Launch Chrome browser
When User open URL "http://demo.nopcommerce.com/login"
And User enters Email as "pratish@gmail.com" and password as "Pratish@7"
And Click on login
Then Page Title should be "nopCommerce demo store"
When user click on log out link
Then Page Title should be "nopCommerce demo store"
And close browser


@regression
Scenario Outline: Login Data Driven
Given User Launch Chrome browser     
When User open URL "http://demo.nopcommerce.com/login"
And User enters Email as "<email>" and password as "<password>"
And Click on login
Then Page Title should be "nopCommerce demo store"
When user click on log out link
Then Page Title should be "nopCommerce demo store"
And close browser

Examples:
      |email | password|
      | dvpratish@gmail.com  | Pratish@7 |
      | dvpratish@gmail.com  | Pratish@7 |
  