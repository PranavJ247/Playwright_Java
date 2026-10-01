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

  @regression @negative
  Scenario Outline: Login with invalid username
    Given user launches the application
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user should see invalid credentials message

    Examples:
      | username    | password |
      | InvalidUser | admin123 |

  @regression @negative
  Scenario Outline: Login with invalid password
    Given user launches the application
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user should see invalid credentials message

    Examples:
      | username | password    |
      | Admin    | Invalid1234 |

  @regression @negative
  Scenario: Login with empty username and password
    Given user launches the application
    When user clicks on Login button
    Then user should see required username validation
    And user should see required password validation

  @regression @login @negative
  Scenario: Login with empty username
    Given user launches the application
    When user enters username ""
    And user enters password "admin123"
    And user clicks on Login button
    Then user should see required username validation

  @regression @negative
  Scenario: Login with empty password
    Given user launches the application
    When user enters username "Admin"
    And user enters password ""
    And user clicks on Login button
    Then user should see required password validation
