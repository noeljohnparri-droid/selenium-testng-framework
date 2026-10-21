Feature: Sauce demo login



Scenario Outline: Login credentials check
Given user launches the website page
When user enters valid username "<username>"
And user enter valid password "<password>" 
And user click on login button
Then login should be "<result>"


Examples:
|username     |password    |result|
|standard_user|secret_sauce|success|
|wrong_user   |wrong_input |error|