package de.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @Test
    public void addItemToCartTest() {
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), "demiyncevaanna@gmail.com");
        type(By.id("Password"), "Anna14031981$");
        click(By.cssSelector("input[value='Log in']"));

        click(By.xpath("(//input[@value='Add to cart'])[2]"));

        click(By.cssSelector(".ico-cart"));

        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(text(),'Build your own computer')]")));
    }
}
