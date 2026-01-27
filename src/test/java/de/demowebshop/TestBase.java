
package de.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import  java.util.List;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public String newEmail() {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        String email  = "demiyncevaanna"+ i + "@gmail.com";
        return email;
    }
    public boolean isEmailInHeaderPresent() {
        return isElementPresent(By.cssSelector(".header [href='/customer/info']"));
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void fillRegisterForm(String name, String lastname, String email, String password) {
        type(By.id("FirstName"), name);
        type(By.id("LastName"), lastname);
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), password);
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean verifyByName(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector(".product-name"));
        for (WebElement element: contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }
}
