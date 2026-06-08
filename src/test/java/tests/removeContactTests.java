package tests;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class removeContactTests extends TestBase {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().setEmail("pashalagodni@gmail.com").setPassword("123Qwert@"));
        app.getHelperUser().provideContacts();//if list of contacts <3 ---> add 3 contacts
    }

    @Test
    public void removeFirstContact(){
        Assert.assertEquals(app.getHelperUser().removeOneContact(), 1);

    }

    @Test
    public void removeAllContacts(){
        //Assert -->"No contacts here" is present
        app.getHelperUser().removeAllContacts();
        //Assert -->"No contacts here" is present
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }
}
