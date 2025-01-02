Feature: SQL Injection Testing

  Scenario: Attempt SQL injection in the login form
    Given I am on the ParaBank login page
    When I enter malicious SQL username "' OR '1'='1" and password "' OR '1'='1"
    And I click the "Log In" button
    Then I should see an error message "The username and password could not be verified."

  Scenario: Attempt SQL injection in the Payee Name field
    Given I am logged into ParaBank
    And I navigate to the Bill Payment page
    When I enter malicious SQL injection into the 'Payee Name' field:
      | maliciousInput                  |
      | "' OR '1'='1"                  |
      | "123'; DROP TABLE users; --"   |
      | "<script>alert('test')</script>" |
    And I enter payment details "500" to account "12345"
    Then I should see an error message "Invalid input provided."
