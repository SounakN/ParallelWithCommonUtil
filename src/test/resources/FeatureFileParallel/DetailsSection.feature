Feature: User details verification from Teams Settings


  Scenario Outline: Testing user details section positive
    Given User hits the URl of mindAi
    Then Logs in using the credentials
    And verifies that he has landed on Home Page
    Then User clicks on the Section Team and then goes to "<TeamsMenu>"
    And user verifies the details of the Users
      | Company Email ID | Personal Email ID | Mobile Number | First Name | Last Name | Date of Birth |
      | info@witmer.ai   | info@witmer.ai    | 6382516128    | Team       | mindn     | 2005-01-01    |
    Examples:
      | TeamsMenu |
      | SETTINGS  |








