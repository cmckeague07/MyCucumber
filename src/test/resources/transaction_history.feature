Feature: Transaction History

  Scenario: View and filter transaction history
    Given I am logged into ParaBank
    When I navigate to the Transaction History page
    And I filter transactions by date "01-01-2025" to "01-10-2025"
    Then I should see a list of filtered transactions
