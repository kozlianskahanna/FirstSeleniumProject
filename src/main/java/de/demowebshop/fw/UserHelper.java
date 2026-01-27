package de.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) { super(driver); }

    public void clickOnLoginLink() { click(By.cssSelector("[href='/login']")); }
    public void clickOnLoginButton() { click(By.cssSelector(".login-button")); }
    public void fillLoginForm(String email, String password) {
        type(By.id("Email"), email);
        type(By.id("Password"), password);
    }

    public void clickOnRegisterLink() { click(By.cssSelector("[href='/register']")); }
    public void clickOnRegisterButton() { click(By.id("register-button")); }
    public void fillRegisterForm(String name, String lastname, String email, String password) {
        type(By.id("FirstName"), name);
        type(By.id("LastName"), lastname);
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), password);
    }
}