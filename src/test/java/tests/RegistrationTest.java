package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        //If button Sign Out present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
// Positive registration test
    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("==================");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        System.out.println(System.currentTimeMillis());
        System.out.println(z);

        User user = new User()
                .setEmail("pavlova" + z + "@gmail.com")
                .setPassword("Pablo_1001#");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertEquals(app.getHelperUser().getMassage(),"No Contacts here!");


    }
// Negative registration test
    @Test
    public void registrationLose(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        System.out.println(i);
        System.out.println("===================");
        int z = (int)((System.currentTimeMillis()/1000)%3600);
        System.out.println(System.currentTimeMillis());
        System.out.println(z);

        User user = new User()
                .setEmail("ззщшщг" + z + "@gmail.com")
                .setPassword("20042005");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void registrationLose2(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        System.out.println(i);
        System.out.println("===================");
        int z = (int)((System.currentTimeMillis()/1000)%3600);
        System.out.println(System.currentTimeMillis());
        System.out.println(z);

        User user = new User()
                .setEmail("יעיעיע" + z + "@gmail.com")
                .setPassword("890665R");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
}
}
