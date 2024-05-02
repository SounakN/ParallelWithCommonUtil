Feature: Section header details verification

  Scenario Outline: Verify that header values are right for Sections positive
    Given User hits the URl of mindAi
    Then Logs in using the credentials
    And verifies that he has landed on Home Page
    Then User clicks on the Section "<Section>" and Verifies the presence of Header "<HeaderCheckString>"
    Then User closes the modal
    Then User logs out of the application
    Examples:
      | HeaderCheckString                                        | Section        |
      | HAVING A STRESSFUL DAY?,STRUGGLING TO FOCUS?,FOCUS GAMES | EVERYDAY TOOLS |
     | PRODUCTIVITY PROGRAMMES FOR YOU,FUN TOOLS FOR YOU        | PRODUCTIVITY   |
     # | WHAT DO YOU WANT TO WORK ON?,FEATURED PROGRAMMES         | WELLNESS       |







