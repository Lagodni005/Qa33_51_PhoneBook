package manager;

import io.qameta.allure.Step;
import model.Contact;
import model.User;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    @Step("Open login/registration form")
    public void openLoginRegistrationForm() {
        // wd.findElement(By.cssSelector("a[href='/login']"));
//        WebElement loginTab = wd.findElement(By.xpath("//a[text()='LOGIN']"));
//        loginTab.click();
        click(By.cssSelector("a[href='/login']"));
    }

    @Step("Open login/registration form with email: {email} and password: {password}")
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
    @Step("Fill login/registration form with user {user}")
    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }
    @Step("Submit login")
    public void submitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }

    public void submitRegistration(){
        click(By.xpath("//Button[text()='Registration']"));
    }

    @Step("Check if user logged")
    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    @Step("Logout")
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

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }

    public void openFormContact(){
       click(By.xpath("//a[@href='/contact']"));
    }

    public boolean isAddContactPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);
    }

    private int countOfContacts() {
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        return list.size();
    }

    public void removeAllContacts() {
        while (countOfContacts() != 0) {
            removeContact();
        }
    }

    public void provideContacts() {
        if (countOfContacts() < 3) {
            for (int i = 0; i < 3; i++) {
                addOneContact();


            }
        }
    }

    private void addOneContact() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Harry")
                .lastName("Potter")
                .email("harry" + i + "@gmail.com")
                .phone("55566777" + i)
                .address("Hogwards")
                .description("Friend")
                .build();

        OpenAddContact();
        fillContactForm(contact);
        clickSaveButton();
        pause(500);
    }

    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of Contacts before remove is-->" + before);
        removeContact();
        int after = countOfContacts();
        logger.info("Number of Contacts after remove is-->" + after);

        return before - after;
    }

    public boolean isNoContactsHereDisplayed() {
        return isElementPresent(By.xpath("//h1[text()='No Contacts here!']"));
    }
}
