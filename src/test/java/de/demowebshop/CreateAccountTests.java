package de.demowebshop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        clickOnRegisterLink();
        fillRegisterForm("Hanna", "Kozlianska", newEmail(), "Anna14031981$");
        clickOnRegisterButton();
        Assert.assertTrue(isEmailInHeaderPresent());

    }
}










