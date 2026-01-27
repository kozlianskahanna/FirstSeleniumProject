package de.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public String newEmail() {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        return "demiyncevaanna" + i + "@gmail.com";
    }

    public boolean isEmailInHeaderPresent() {
        return isElementPresent(By.cssSelector(".header [href='/customer/info']"));
    }

    public boolean verifyByName(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector(".product-name"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }
}