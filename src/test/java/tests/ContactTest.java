package tests;

import manager.DataProviderContact;
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
            logger.info("Before method finished logout");
        }
    }
    // Positive Contact Test

    @Test(dataProvider = "ContactSuccess",dataProviderClass = DataProviderContact.class)
    public void PositiveContactTest(Contact contact){
        logger.info("Start test with name 'PositiveContactTest'");
        logger.info("Contact Test data ---> name: 'Pavel, lastName: Lagodni, phone: 0507722271, email: pavlova@gmail.com, address: Ein Gedi 28, & description: null'");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("lagodnip@gmail.com", "123Qwert@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().OpenAddContact();
        app.getHelperUser().fillContactForm(contact);
        app.getHelperUser().clickSaveButton();
        app.getHelperUser().clickOnBContact();
        Assert.assertEquals(app.getHelperUser().findButtonEdit(),true);
        logger.info("Assert check is alert present with button 'Edit'");

    }
    @Test(dataProvider = "ContactSuccess",dataProviderClass = DataProviderContact.class)
    public void PositiveContactTest2(Contact contact){
        logger.info("Start test with name 'PositiveContactTest2'");
        logger.info("Contact Test data ---> name: 'Pavel, lastName: Lagodni, phone: 0507722271, email: pavlova@gmail.com, address: Ein Gedi 28'");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("lagodnip@gmail.com", "123Qwert@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().OpenAddContact();
        app.getHelperUser().fillContactForm(contact);
        app.getHelperUser().clickSaveButton();
        app.getHelperUser().clickOnBContact();
        Assert.assertEquals(app.getHelperUser().findButtonEdit(),true);
        logger.info("Assert check is alert present with button  'Edit'");
    }

    //negative tests////////////////////////////////////////////
// ghjhxhfj
    @Test(dataProvider = "WrongPhoneTest",dataProviderClass = DataProviderContact.class)
    public void NegativePhoneContactTest1(Contact contact){
        logger.info("Start test with name 'NegativePhoneContactTest1");
        logger.info("Contact Test data ---> name: 'Pavel, lastName: Lagodni, phone: 0, email: pavlova@gmail.com, address: Ein Gedi 28, & description: null'");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("lagodnip@gmail.com", "123Qwert@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().OpenAddContact();
        app.getHelperUser().fillContactForm(contact);
        app.getHelperUser().pause(10000);
        app.getHelperUser().getScreen("src/test/screenshots/screen.png");
        app.getHelperUser().clickSaveButton();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
        logger.info("Assert check is alert present with error text 'Phone not valid: Phone number must contain only digits! And length min 10, max 15!'");
    }

    @Test(dataProvider = "WrongPhoneTest",dataProviderClass = DataProviderContact.class)
    public void NegativePhoneContactTest2(Contact contact){
        logger.info("Start test with name 'NegativePhoneContactTest2");
        logger.info("Contact Test data ---> name: 'Pavel, lastName: Lagodni, phone: #######, email: pavlova@gmail.com, address: Ein Gedi 28, & description: null'");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("lagodnip@gmail.com", "123Qwert@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().OpenAddContact();
        app.getHelperUser().fillContactForm(contact);
        app.getHelperUser().clickSaveButton();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
        logger.info("Assert check is alert present with error text  'Phone not valid: Phone number must contain only digits! And length min 10, max 15!'");

    }

    @Test(dataProvider = "WrongPhoneTest",dataProviderClass = DataProviderContact.class)
    public void NegativePhoneContactTest3(Contact contact){
        logger.info("Start test with name 'NegativePhoneContactTest3");
        logger.info("Contact Test data ---> name: 'Pavel, lastName: Lagodni, phone: 0000000, email: pavlova@gmail.com, address: Ein Gedi 28, & description: null'");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("lagodnip@gmail.com", "123Qwert@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().OpenAddContact();
        app.getHelperUser().fillContactForm(contact);
        app.getHelperUser().clickSaveButton();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
        logger.info("Assert check is alert present with error text 'Phone not valid:Phone number must contain only digits! And length min 10, max 15!'");

    }

    @Test(dataProvider = "WrongEmailTest",dataProviderClass = DataProviderContact.class)
    public void NegativeEmailContactTest(Contact contact){
        logger.info("Start test with name 'NegativeEmailContactTest");
        logger.info("Contact Test data ---> name: 'Pavel, lastName: Lagodni, phone: 059787877, email: lagodnip, address: Ein Gedi 28, & description: null'");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("lagodnip@gmail.com", "123Qwert@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().OpenAddContact();
        app.getHelperUser().fillContactForm(contact);
        app.getHelperUser().clickSaveButton();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: должно иметь формат адреса электронной почты"));
        logger.info("Assert check is alert present with error text 'Email not valid: должно иметь формат адреса электронной почты'");
    }

}
