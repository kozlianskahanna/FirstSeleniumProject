package de.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper {
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public String getItemName(String itemNumber) {
        return findElement(By.cssSelector(".item-box:nth-child(" + itemNumber + ") h2>a")).getText();
    }

    public void clickOnItemInList(String itemNumber) {
        click(By.cssSelector(".item-box:nth-child(" + itemNumber + ") .buttons"));
    }

    public void clickOnShoppingCartLink() {
        click(By.id("topcartlink"));
    }

    public void removeItemFromCart() {

    }
}