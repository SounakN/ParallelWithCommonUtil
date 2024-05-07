Feature: User details verification from Teams Settings


  @MobileAndroid
  Scenario: Testing user details section positive
    Given User launches the App and enters mobile number
    Then enters the OTP
    And Verify user has landed in user Details section and then fill in Details
    |FirstName|LastName|Email|
    |XX       |YY      |xx.yy@gmail.com|

  @MobileAndroid
  Scenario: Testing user details section positive 2
    Given User launches the App and enters mobile number
    Then enters the OTP
    And Verify user has landed in user Details section and then fill in Details
      |FirstName|LastName|Email|
      |XX       |YY      |xx.yy@gmail.com|