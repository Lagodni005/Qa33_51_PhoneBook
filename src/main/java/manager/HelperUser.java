package manager;

import model.Contact;
import model.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        // wd.findElement(By.cssSelector("a[href='/login']"));
//        WebElement loginTab = wd.findElement(By.xpath("//a[text()='LOGIN']"));
//        loginTab.click();
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.name("email"), email);


//        WebElement passwordInput = wd.findElement(By.xpath("//input[@placeholder='Password']"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
        type(By.xpath("//input[@placeholder='Password']"), password);
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }

    public void submitRegistration(){
        click(By.xpath("//Button[text()='Registration']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }


    public String getMassage(){
        return wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")).getText();
    }

    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        if (alert != null && alert.getText().contains(message)) {
            // System.out.println(alert.getText());
            //click OK -->alert.accept();
            // click cancel -->alert.dismiss();
            //type into alert -->alert.sendKeys("text");
            //pause(2000);
            alert.accept();
            return true;
        }
        return false;
    }

    public void OpenAddContact(){
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillContactForm(String name, String lastName, String phone, String email, String address,
                                String description){
        type(By.xpath("//input[@placeholder='Name']"), name);
        type(By.xpath("//input[@placeholder='Last Name']"), lastName);
        type(By.xpath("//input[@placeholder='Phone']"), phone);
        type(By.xpath("//input[@placeholder='email']"), email);
        type(By.xpath("//input[@placeholder='Address']"), address);
        type(By.xpath("//input[@placeholder='description']"), description);
    }

    public void fillContactForm(Contact contact){
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }

    public void clickSaveButton(){
        click(By.xpath("//b[text()='Save']"));
    }

    public void clickOnBContact(){
        click(By.xpath("//h2[text()='Pavel']"));
    }

    public boolean findButtonEdit(){
        return isElementPresent(By.xpath("//button[text()='Edit']"));
    }
}
