package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountSummarySteps {

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

    @Given("I am logged into ParaBank")
    public void iAmLoggedIntoParaBank() {
        driver.get("https://para.testar.org/parabank/index.htm");
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @When("I view the account summary page")
    public void iViewTheAccountSummaryPage() {
        driver.findElement(By.linkText("Accounts Overview")).click();
    }

    @Then("I should see a list of accounts with balances and details")
    public void iShouldSeeAListOfAccountsWithBalancesAndDetails() {
        List<WebElement> accounts = driver.findElements(By.xpath("//table[@id='accountTable']//tr"));
        assertTrue(accounts.size() > 1, "No account details found!"); // Ensure rows exist
    }
}
