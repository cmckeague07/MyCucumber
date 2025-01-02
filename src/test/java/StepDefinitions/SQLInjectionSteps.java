package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SQLInjectionSteps {

    WebDriver driver;

    @Given("I am on the ParaBank login page")
    public void iAmOnTheParaBankLoginPage() {
        driver.get("https://para.testar.org/parabank/index.htm");
    }

    @When("I enter malicious SQL username {string} and password {string}")
    public void iEnterMaliciousSQLUsernameAndPassword(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String button) {
        WebElement buttonElement = driver.findElement(By.xpath("//input[@value='" + button + "']"));
        buttonElement.click();
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
        assertTrue(errorElement.getText().contains(errorMessage), "Error message not found or incorrect!");
    }

    @Given("I am logged into ParaBank")
    public void iAmLoggedIntoParaBank() {
        driver.get("https://para.testar.org/parabank/index.htm");
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @And("I navigate to the Bill Payment page")
    public void iNavigateToTheBillPaymentPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement billPaymentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Pay")));
        billPaymentLink.click();
    }

    @When("I enter malicious SQL injection into the {string} field:")
    public void iEnterMaliciousSQLInjectionIntoTheField(String field, DataTable dataTable) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the target field (replace "field" with actual field name like 'payee.name')
        WebElement fieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(field)));

        // Get the list of malicious SQL inputs from the DataTable
        List<String> maliciousInputs = dataTable.asList();

        // Iterate over each malicious input
        for (String input : maliciousInputs) {
            fieldElement.clear(); // Clear the field before each input
            fieldElement.sendKeys(input);

            // Optionally, click the submit button to trigger the SQL injection
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Send Payment']")));
            submitButton.click();

            // Verify if the application handled the input securely
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
            assertTrue(
                    errorElement.getText().contains("Invalid input provided."),
                    "SQL injection attempt '" + input + "' did not trigger the expected error!"
            );
        }
    }


    @And("I enter payment details {string} to account {string}")
    public void iEnterPaymentDetails(String amount, String account) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("amount")));
        amountField.sendKeys(amount);

        WebElement accountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fromAccountId")));
        accountField.sendKeys(account);

        driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
    }
}
