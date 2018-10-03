package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class HomePage {

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//input[@id='register-username-modal']")
    private WebElement userNameFieldInRegistration;

    @FindBy(xpath = "//input[@id='register-first-modal']")
    private WebElement firstNameFieldInRegistration;

    @FindBy(xpath = "//input[@id='register-last-modal']")
    private WebElement lastNameFieldInRegistration;

    @FindBy(xpath = "//input[@id='register-email-modal']")
    private WebElement emailFieldInRegistration;

    @FindBy(xpath = "//input[@id='register-password-modal']")
    private WebElement passwordFieldInRegistration;

    @FindBy(xpath = "//div[@id='register-modal']//button[@class='btn btn-primary']")
    private WebElement registerinPopUpWindowButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//li[@id='login']//a[@href='#'][contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='username-modal']")
    private WebElement loginUserNameFieldInLoginWindow;

    @FindBy(xpath = "//input[@id='password-modal']")
    private WebElement passwordFieldInLoginWindow;

    @FindBy(xpath = "//div[@id='login-modal']//button[@class='btn btn-primary']")
    private WebElement loginButtonInLoginWindow;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement alertRegistration;

    @FindBy(xpath = "//div[@id='products']//div[1]//div[1]//div[2]//p[2]//a[2]")
    private WebElement addProductHollyAddToCart;

    private WebDriver driver;
    private Waits waits;
    private Actions actions;
    private UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTextFromLogoutToConfirmLoginOrRegistration() {
        return logoutButton.getText();
    }

    public String alertRegistration() {
        return alertRegistration.getText();
    }

    public void waitsWhenLogout() {
        waits.waitForElementToBeVisible(logoutButton);
        logoutButton.click();
        waits.waitForElementToBeVisible(loginButton);
    }

    public void registrationSteps(UserData userData) {

        registerButton.click();
        waits.waitForElementToBeVisible(userNameFieldInRegistration);
        userNameFieldInRegistration.sendKeys(userData.getUserName());
        firstNameFieldInRegistration.sendKeys(userData.getFirstName());
        lastNameFieldInRegistration.sendKeys(userData.getLastName());
        emailFieldInRegistration.sendKeys(userData.getEmail());
        passwordFieldInRegistration.sendKeys(userData.getPassword());
        registerinPopUpWindowButton.click();

    }

    public void registerUserWithDataGeneratorMethod() throws IOException {

        UserData userData = userDataGenerator.prepareUserData();

        registrationSteps(userData);
        waits.waitForElementToBeVisible(logoutButton);

    }

    public void regiterUserTwiceWithTheSameData() throws IOException {

        UserData userData = userDataGenerator.prepareUserData();

        registrationSteps(userData);
        waitsWhenLogout();
        registrationSteps(userData);

    }

    public void loginUserAfterRegistration() throws IOException {

        UserData userData = userDataGenerator.prepareUserData();

        registrationSteps(userData);

        waitsWhenLogout();

        loginButton.click();
        waits.waitForElementToBeVisible(loginUserNameFieldInLoginWindow);
        loginUserNameFieldInLoginWindow.sendKeys(userData.getUserName());
        passwordFieldInLoginWindow.sendKeys(userData.getPassword());
        loginButtonInLoginWindow.click();
        waits.waitForElementToBeVisible(logoutButton);

    }

    /*public void deletinProductFromCart() {
        try {
            itemsInCartButton.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement button = driver.findElement(By.xpath("//span[@id='numItemsInCart']"));
            itemsInCartButton.click();
        }
    }*/

    public void addinngAdditionalEightProducts() {
        waits.waitForElementToBeClickable(addProductHollyAddToCart);
        addProductHollyAddToCart.click();
        try {
            List<WebElement> socks = driver.findElements(By.xpath("//i[@class='fa fa-shopping-cart']"));
            socks.get(0).click();
            socks.get(1).click();
            socks.get(2).click();

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> socks = driver.findElements(By.xpath("//i[@class='fa fa-shopping-cart']"));
            socks.get(0).click();
            socks.get(1).click();
            socks.get(2).click();

        }
        /*try {
            List<WebElement> socks = driver.findElements(By.xpath("//i[@class='fa fa-shopping-cart']"));
            socks.get(1).click();

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> socks = driver.findElements(By.xpath("//i[@class='fa fa-shopping-cart']"));
            socks.get(1).click();

        }*/


    }
}
