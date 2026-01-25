package de.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        // Open registration page
        driver.findElement(By.cssSelector("[href='/register']")).click();
        //Your Personal Details:
        // First name
        driver.findElement(By.id("FirstName")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Anna");
        // Last name
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Demiynceva");
        //Email:
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("kozlianska@gmail.com");
        //Your Password
        //Password:
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Anna14031981$");
        //Confirm password:
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Anna14031981$");
        //Click on Registration button
        driver.findElement(By.id("register-button")).click();
        //Assert Sign Out button presents
        Assert.assertTrue(isElementPresent(By.xpath("❓❓❓❓❓❓❓❓❓❓")));

    }
}
