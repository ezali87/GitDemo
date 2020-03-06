Feature: Login into Application


#For parametrization we can change Scenario into Scenario Outline

#Scenario: Positive Test Validating Login
Scenario Outline:Positive Test Validating Login
Given Initialize the ChromeBrowser
And Navigate to "http://qaclickacademy.com/" site
And Clicking on the Login button to Land on Secure SignIn page
When User enters <Username> and <Password> and logs in
Then Verify that is user is logged in "True"
And close browsers

Examples: 
|Username        | Password  |
|test99@gmail.com| 123456    |
|testing22@evolutionfinance.com| Abcd123* |
|test22@gmail.com| 12df3456    |


