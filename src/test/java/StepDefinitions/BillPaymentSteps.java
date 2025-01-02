package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BillPaymentSteps {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserUtility.getDriver(); // Use BrowserUtils to get the WebDriver
        driver.get("https://para.testar.org/parabank/index.htm"); // Navigate to the test site
    }

    @After
    public void tearDown() {
        BrowserUtility.quitDriver(); // Use BrowserUtils to quit the WebDriver
    }

    @When("I navigate to the Bill Payment page")
    public void iNavigateToTheBillPaymentPage() {
        driver.findElement(By.linkText("Bill Pay")).click();
    }

    @And("I enter the payee details:")
    public void iEnterThePayeeDetails(DataTable dataTable) {
        List<Map<String, String>> payeeDetailsList = dataTable.asMaps(String.class, String.class);
        Map<String, String> payeeDetails = payeeDetailsList.get(0);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for each element and interact with it
        WebElement payeeNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payee.name")));
        payeeNameField.sendKeys(payeeDetails.get("name"));

        WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payee.address.street")));
        addressField.sendKeys(payeeDetails.get("address"));

        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payee.address.city")));
        cityField.sendKeys(payeeDetails.get("city"));

        WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payee.address.state")));
        stateField.sendKeys(payeeDetails.get("state"));

        WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payee.address.zipCode")));
        zipCodeField.sendKeys(payeeDetails.get("zipCode"));

        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payee.phoneNumber")));
        phoneNumberField.sendKeys(payeeDetails.get("phone"));
    }


    @And("I enter the payment details {string} to account {string}")
    public void iEnterThePaymentDetailsToAccount(String amount, String account) {
        System.out.println(driver.getPageSource());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("amount")));
        amountField.sendKeys(amount);

        WebElement fromAccountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fromAccountId")));
        fromAccountField.sendKeys(account);

        WebElement sendPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Send Payment']")));
        sendPaymentButton.click();

    }

    @Then("There should be a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String message) {
        assertTrue(driver.getPageSource().contains(message), "Bill payment confirmation not found!");
    }
}
