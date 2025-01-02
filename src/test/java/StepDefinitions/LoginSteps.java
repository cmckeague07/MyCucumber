package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BrowserUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;

public class LoginSteps {

    WebDriver driver;
    List<Map<String, String>> users;

    @Before
    public void setUp() {
        driver = BrowserUtility.getDriver(); // Use BrowserUtils to get the WebDriver
        driver.get("https://www.saucedemo.com/"); // Navigate to the test site
    }

    @After
    public void tearDown() {
        BrowserUtility.quitDriver(); // Use BrowserUtils to quit the WebDriver
    }

    @Given("I am on the ParaBank login page")
    public void iAmOnTheParaBankLoginPage() {
        driver.get("https://para.testar.org/parabank/index.htm");

    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

    }

    @And("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        WebElement button = driver.findElement(By.xpath("//input[@value='" + buttonText + "']"));
        button.click();
    }

    @Then("I should see the homepage with the title {string}")
    public void iShouldSeeTheHomepageWithTheTitle(String title) {
        WebElement heading = driver.findElement(By.tagName("h1"));
        assertEquals(title, heading.getText());
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        WebElement errorElement = driver.findElement(By.className("error"));
        assertEquals(errorMessage, errorElement.getText());
    }


    @Given("I have the following users:")
    public void iHaveTheFollowingUsers(io.cucumber.datatable.DataTable dataTable) {
        // Convert the DataTable into a List of Maps
        List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);

        // Store the user data in a reusable way (optional, if needed later)
        this.users = users;
    }

    @When("I attempt to login with each user's credentials")
    public void iAttemptToLoginWithEachUsersCredentials() {
        for (Map<String, String> user : users) {
            String username = user.get("username");
            String password = user.get("password");
            String expectedMessage = user.get("expectedMessage");

            // Perform the login for each user
            driver.get("https://para.testar.org/parabank/index.htm");
            driver.findElement(By.name("username")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.xpath("//input[@value='Log In']")).click();

            // Capture the resulting message
            String actualMessage = driver.findElement(By.tagName("h1")).getText();

            // Validate the expected message
            assertEquals(expectedMessage, actualMessage);

            // Return to the login page for the next iteration
            driver.get("https://para.testar.org/parabank/index.htm");
        }
    }

    @Then("I should see the corresponding message for each user")
    public void iShouldSeeTheCorrespondingMessageForEachUser() {
        for (Map<String, String> user : users) {
            String username = user.get("username");
            String password = user.get("password");
            String expectedMessage = user.get("expectedMessage");

            // Perform login for each user
            driver.get("https://para.testar.org/parabank/index.htm");
            driver.findElement(By.name("username")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.xpath("//input[@value='Log In']")).click();

            // Capture the actual message
            String actualMessage = driver.findElement(By.tagName("h1")).getText();

            // Assert the expected message matches the actual message
            assertEquals(expectedMessage, actualMessage,
                    "Validation failed for user: " + username);

            // Return to the login page for the next iteration
            driver.get("https://para.testar.org/parabank/index.htm");
        }
    }


}
