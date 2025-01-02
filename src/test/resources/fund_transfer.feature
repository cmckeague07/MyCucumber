Feature: Fund Transfers

  Scenario: Transfer funds between accounts
    Given I am logged into ParaBank
    When I navigate to the Fund Transfer page
    And I transfer "100" from account "12345" to account "67890"
    Then I should see a confirmation message "Transfer Complete!"
