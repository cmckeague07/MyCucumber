package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FundTransferSteps {

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
    @Given("I am logged into Parabank")
    public void loginToParaBank() {
        driver.get("https://para.testar.org/parabank/index.htm");
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @When("I navigate to the Fund Transfer page")
    public void iNavigateToTheFundTransferPage() {
        driver.findElement(By.linkText("Transfer Funds")).click();
    }

    @And("I transfer {string} from account {string} to account {string}")
    public void iTransferFromAccountToAccount(String amount, String fromAccount, String toAccount) {
        driver.findElement(By.id("amount")).sendKeys(amount);
        driver.findElement(By.id("fromAccountId")).sendKeys(fromAccount);
        driver.findElement(By.id("toAccountId")).sendKeys(toAccount);
        driver.findElement(By.xpath("//input[@value='Transfer']")).click();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String message) {
        assertTrue(driver.getPageSource().contains(message), "Transfer confirmation not found!");
    }
}
