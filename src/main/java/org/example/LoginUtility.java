package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginUtility {

    private WebDriver driver;

    public LoginUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.get("https://para.testar.org/parabank/index.htm");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }
}
