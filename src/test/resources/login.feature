Feature: User Login

  Scenario: Valid login with valid credentials
    Given I am on the login page
    When I enter "validUser" and "validPassword"
    Then I should be redirected to the homepage

  Scenario: Invalid login with invalid credentials
    Given I am on the login page
    When I enter "invalidUser" and "invalidPassword"
    Then I should see an error message "Invalid username or password"


  Scenario: User logs in with multiple credentials
    Given the following users and passwords
      | username     | password   |
      | validUser1   | password1  |
      | validUser2   | password2  |
      | invalidUser  | wrongPass  |
    When I attempt to log in with the provided credentials
    Then the login attempt should be successful or fail based on the credentials
