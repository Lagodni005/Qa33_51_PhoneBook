package tests;

import model.User;
import model.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactTest extends TestBase {
    @BeforeMethod
    public void preCondition(){
        //If button Sign Out present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    // Positive Contact Test

    @Test
    public void PositiveContactTest(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("====================");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        System.out.println(System.currentTimeMillis());
        System.out.println(z);

        Contact contact = new Contact()
                .setName("Pavel")
                .setLastName("Lagodni")
                .setPhone("0507722271")
                .setEmail("lagodnip" + z + "@gmail.com")
                .setAddress("Ein Gedi 28")
                .setDescription("null");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("lagodnip@gmail.com", "123Qwert@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().OpenAddContact();
        app.getHelperUser().fillContactForm(contact);
        app.getHelperUser().clickSaveButton();
        app.getHelperUser().clickOnBContact();
        Assert.assertEquals(app.getHelperUser().findButtonEdit(),true);
    }
    @Test
    public void PositiveContactTest2(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("====================");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        System.out.println(System.currentTimeMillis());
        System.out.println(z);

        Contact contact = new Contact()
                .setName("Pavel")
                .setLastName("Lagodni")
                .setPhone("0507722271")
                .setEmail("lagodnip" + z + "@gmail.com");


        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("lagodnip@gmail.com", "123Qwert@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().OpenAddContact();
        app.getHelperUser().fillContactForm(contact);
        app.getHelperUser().clickSaveButton();
    }
}
