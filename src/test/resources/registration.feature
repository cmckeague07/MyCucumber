Feature: User Registration

  Scenario Outline: Valid user registration
    Given I am on the registration page
    When I enter the following details:
      | name    | email             | password   |
      | <name>  | <email>           | <password> |
    Then I should see a success message "Registration successful"

    Examples:
      | name    | email              | password  |
      | John    | john@example.com    | pass123   |
      | Alice   | alice@example.com   | password1 |



#Step-by-Step Breakdown:
#DataTable userDetails:
#
#This is an object that Cucumber automatically creates for you. It represents the table that you defined in the When step of the feature file.
#The DataTable contains the data you pass from the feature file in tabular form.
#userDetails.asMaps(String.class, String.class):
#
#asMaps(String.class, String.class) is a method provided by Cucumber to convert the DataTable into a list of maps.
#Each row of the Examples table (a single test case) will be converted into a Map, where:
#The key is the column name (name, email, password).
#The value is the corresponding value for that row (John Doe, john@example.com, pass123, etc.).
