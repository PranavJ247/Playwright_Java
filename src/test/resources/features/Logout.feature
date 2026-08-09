Feature: OrangeHRM Logout
  @regression
  Scenario: Successful Logout

    Given user launches the application
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks on Login button
    Then user should see the Dashboard
    When user logs out
    Then user should see the Login page