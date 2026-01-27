package de.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginForm("demiyncevaanna@gmail.com","Anna14031981$");
        clickOnLoginButton();
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".login-button"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("Email"),email);
        type(By.id("Password"),password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    @Test
    public void addItemToCartTest() {
        String name = itemName("3");
        clickOnItemInList("3");
        clickOnShoppingCartLink();
        Assert.assertTrue(verifyByName(name));
    }

    @AfterMethod
    public void postCondition() {
        removeItemFromCart();
    }

    public void removeItemFromCart() {

    }

    public String itemName(String itemNameNumber) {
        return driver.findElement(By.cssSelector(".item-box:nth-child(" + itemNameNumber + ") h2>a")).getText();
    }

    public void clickOnShoppingCartLink() {
        click(By.id("topcartlink"));
    }

    public void clickOnItemInList(String itemNumber) {
        click(By.cssSelector(".item-box:nth-child(" + itemNumber + ") .buttons"));
    }
}

