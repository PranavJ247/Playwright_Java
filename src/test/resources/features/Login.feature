Feature: OrangeHRM Login
  @smoke
  Scenario Outline: Successful Login
    Given user launches the application
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user should see the Dashboard
    Examples:
      | username | password |
      | Admin    | admin123 |
      | Admin    | admin123 |