Feature: Login functionality

  Scenario: Successful login
    Given I am on the ParaBank login page
    When I enter username "john" and password "demo"
    And I click the "Log In" button
    Then I should see the homepage with the title "Welcome John Smith"

  Scenario: Invalid login
    Given I am on the ParaBank login page
    When I enter username "invalidUser" and password "wrongPass"
    And I click the "Log In" button
    Then I should see an error message "The username and password could not be verified."

  Scenario: Verify multiple user logins
    Given I have the following users:
      | username    | password    | expectedMessage          |
      | validUser   | validPass   | "Welcome John Smith"     |
      | invalidUser | invalidPass | "Invalid credentials!"   |
      | adminUser   | adminPass   | "Welcome Admin"          |
    When I attempt to login with each user's credentials
    Then I should see the corresponding message for each user


