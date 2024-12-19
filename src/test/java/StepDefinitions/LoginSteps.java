package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    @Given("I am on the login page")
    public void onTheLoginPage(){
        System.out.println("I am on the login page");
    }


    @When("I enter {string} and {string}")
    public void iEnterAnd(String arg0, String arg1) {
        
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage() {
        
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String arg0) {

    }

    @Given("the following users and passwords")
    public void theFollowingUsersAndPasswords(DataTable dataTable) {
        // Convert the dataTable into a List of Maps (each row as a map of column -> value)
        List<Map<String, String>> userCredentials = dataTable.asMaps(String.class, String.class);

        // Iterate through the data to print out the usernames and passwords (or use in your logic)
        for (Map<String, String> row : userCredentials) {
            String username = row.get("username");
            String password = row.get("password");
            System.out.println("Username: " + username + ", Password: " + password);
        }
    }

    // When step to attempt login (for each username and password)
    @When("I attempt to log in with the provided credentials")
    public void iAttemptToLogIn() {
        // Implement the login logic here, using the provided credentials
        System.out.println("Attempting login...");
    }

    // Then step to verify success/failure
    @Then("the login attempt should be successful or fail based on the credentials")
    public void verifyLoginOutcome() {
        // Implement the verification logic based on the credentials
        System.out.println("Verifying login outcome...");
    }
}
