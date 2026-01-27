package de.demowebshop.core;

import de.demowebshop.fw.*;
import de.demowebshop.fw.ContactHelper;
import de.demowebshop.fw.HomePageHelper;
import de.demowebshop.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;

    UserHelper user;
    ContactHelper contact;
    HomePageHelper homePage;
    ItemHelper item; //+


    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        homePage = new HomePageHelper(driver);
        item = new ItemHelper(driver);//+
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public UserHelper getUser() {
        return user;
    }
    public ContactHelper getContact() {
        return contact;
    }
    public HomePageHelper getHomePage() {
        return homePage;
    }
    public ItemHelper getItem() { return item;//+
    }
}







