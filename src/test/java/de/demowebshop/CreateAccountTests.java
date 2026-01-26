package de.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        click(By.cssSelector("[href='/register']"));
        type(By.id("FirstName"), "Anna");
        type(By.id("LastName"), "Demiynceva");
        type(By.id("Email"), newEmail());
        type(By.id("Password"), "Anna14031981$");
        type(By.id("ConfirmPassword"), "Anna14031981$");
        click(By.id("register-button"));

        Assert.assertTrue(
                isElementPresent(By.cssSelector(".header [href='/customer/info']"))
        );
    }
}
