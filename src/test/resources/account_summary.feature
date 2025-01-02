Feature: Account Summary

  Scenario: Verify account balances and details
    Given I am logged into ParaBank
    When I view the account summary page
    Then I should see a list of accounts with balances and details
