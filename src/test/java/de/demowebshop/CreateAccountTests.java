package de.demowebshop;

import de.demowebshop.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = true)
    public void newUserRegisterPositiveTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm("Hanna", "Kozlianska", app.getContact().newEmail(), "Anna14031981$");
        app.getUser(). clickOnRegisterButton();
        Assert.assertTrue(app.getContact().isEmailInHeaderPresent());

    }
}










