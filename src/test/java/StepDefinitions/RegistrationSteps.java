package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationSteps {
    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
    }

    @When("I enter the following details:")
    public void iEnterRegistrationDetails(DataTable userDetails) {
        List<Map<String, String>> details = userDetails.asMaps(String.class, String.class);
        String name = details.get(0).get("name");
        String email = details.get(0).get("email");
        String password = details.get(0).get("password");
        // Code to enter these details in the registration form

    }
}


