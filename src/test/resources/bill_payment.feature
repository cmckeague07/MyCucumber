Feature: Bill Payment

  Scenario: Pay an external payee
    Given I am logged into ParaBank
    When I navigate to the Bill Payment page
    And I enter the payee details:
      | name       | address     | city      | state | zipCode | phone      |
      | John Doe   | 123 Main St | New York  | NY    | 10001   | 1234567890 |
    And I enter the payment details "500" to account "12345"
    Then There should be a confirmation message "Bill Payment Complete!"
