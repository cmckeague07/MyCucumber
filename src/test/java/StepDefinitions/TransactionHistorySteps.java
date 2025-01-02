package StepDefinitions;

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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionHistorySteps {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserUtility.getDriver(); // Use BrowserUtils to get the WebDriver
        driver.get("https://www.saucedemo.com/"); // Navigate to the test site
    }

    @After
    public void tearDown() {
        BrowserUtility.quitDriver(); // Use BrowserUtils to quit the WebDriver
    }
    @When("I navigate to the Transaction History page")
    public void iNavigateToTheTransactionHistoryPage() {
        // Wait until the link is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement transactionLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Find Transactions")));

        // Click the link
        transactionLink.click();
    }

    @And("I filter transactions by date {string} to {string}")
    public void iFilterTransactionsByDateTo(String startDate, String endDate) {
        driver.findElement(By.id("fromDate")).sendKeys(startDate);
        driver.findElement(By.id("toDate")).sendKeys(endDate);
        driver.findElement(By.id("findByDateRange")).click();
    }

    @Then("I should see a list of filtered transactions")
    public void iShouldSeeAListOfFilteredTransactions() {
        List<WebElement> transactions = driver.findElements(By.xpath("//table[@id='transactionTable']//tr"));
        assertTrue(transactions.size() > 1, "No transactions found for the given date range!");
    }
}
