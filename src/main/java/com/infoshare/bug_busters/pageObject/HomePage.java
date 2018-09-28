package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

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

///////////////////////////////////////////////////////////////////////////Karol Warakomski

    @FindBy(xpath = "//li[@id='login']//a[@href='#'][contains(text(),'Login')]")
    private WebElement linkLogin;
    @FindBy(xpath = "//div[@id='login-modal']//button[@class='btn btn-primary']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement linkRegister;
    @FindBy(xpath = "//div[@id='register-modal']//button[@class='btn btn-primary']")
    private WebElement buttonRegister;
    @FindBy(xpath = "//li[@id='tabCatalogue']")
    private WebElement linkCatalogue;
    @FindBy(xpath = "//li[contains(text(),'Catalogue')]")
    private WebElement catalogueTextOnPageCatalogue;
    @FindBy(xpath = "//a[contains(text(),'Blue')]")
    private WebElement blueFromCatalogueDropDownMenu;
    //dopisac reszte testow dla dropdown menu Catalogue
    // sprawdzic czy slidebar przenosi w dobre miejsca bez kupowania
    // napisac reszte testow z footera
    // przeniesc wszystkie testy dopdown menu do odpowiedniej klasy
    //@FindBy(css = "#numItemsInCart")
    @FindBy(xpath = "//span[@id='numItemsInCart']")
    private WebElement buttonItemsInCart;
    @FindBy(xpath = "//a[contains(text(),'Holy')]")
    private WebElement linkOfProductHoly;
    //@FindBy(xpath = "//div[@class='back']//a[@href='detail.html?id=03fef6ac-1896-4ce8-bd69-b798f85c6e0b']//img[@class='img-responsive']")
    // xpath znajdujacy zdjecie jak sie obroci
    @FindBy(xpath = "//div[@class='front']//a[@href='detail.html?id=03fef6ac-1896-4ce8-bd69-b798f85c6e0b']//img[@class='img-responsive']")
    private WebElement pictureOfProductHoly;
    @FindBy(xpath = "//a[contains(text(),'Colourful')]")
    private WebElement linkOfProductColorful;
    @FindBy(xpath = "//div[@class='front']//a[@href='detail.html?id=3395a43e-2d88-40de-b95f-e00e1502085b']//img[@class='img-responsive']")
    private WebElement pictureOfProductColorful;
    @FindBy(xpath = "//a[contains(text(),'SuperSport XL')]")
    private WebElement linkOfProductSuperSportXL;
    @FindBy(xpath = "//div[@class='front']//a[@href='detail.html?id=510a0d7e-8e83-4193-b483-e27e09ddc34d']//img[@class='img-responsive']")
    private WebElement pictureOfProductSuperSportXL;
    @FindBy(xpath = "//a[contains(text(),'Crossed')]")
    private WebElement linkOfProductCrossed;
    @FindBy(xpath = "//div[@class='front']//a[@href='detail.html?id=808a2de1-1aaa-4c25-a9b9-6612e8f29a38']//img[@class='img-responsive']")
    private WebElement pictureOfProductCrossed;
    @FindBy(xpath = "//a[contains(text(),'Figueroa')]")
    private WebElement linkOfProductFigueroa;
    @FindBy(xpath = "//div[@class='front']//a[@href='detail.html?id=819e1fbf-8b7e-4f6d-811f-693534916a8b']//img[@class='img-responsive']")
    private WebElement pictureOfProductFigueroa;
    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6']//ul//li//a[@href='#'][contains(text(),'Login')]")

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*private WebElement footerLinkLogin;*/
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

    public void registrationSteps(String userName, String firstName, String lastName, String email, String password) {
        registerButton.click();
        waits.waitForElementToBeVisible(userNameFieldInRegistration);
        userNameFieldInRegistration.sendKeys(userName);
        firstNameFieldInRegistration.sendKeys(firstName);
        lastNameFieldInRegistration.sendKeys(lastName);
        emailFieldInRegistration.sendKeys(email);
        passwordFieldInRegistration.sendKeys(password);
        registerinPopUpWindowButton.click();

    }

    public UserData sameDataForRegisterAndLogin() throws IOException {

        String userName = userDataGenerator.prepareUserData().getUserName();
        String firstName = userDataGenerator.prepareUserData().getFirstName();
        String lastName = userDataGenerator.prepareUserData().getLastName();
        String email = userDataGenerator.prepareUserData().getEmail();
        String password = userDataGenerator.prepareUserData().getPassword();

        return new UserData(userName, firstName, lastName, email, password);

    }

    public void registerUserWithDataGeneratorMethod(String userName, String firstName, String lastName, String email, String password) {
        registrationSteps(userName, firstName, lastName, email, password);
        waits.waitForElementToBeVisible(logoutButton);
    }

    public String getTextFromLogoutToConfirmLoginOrRegistration() {
        return logoutButton.getText();
    }

    public String alertRegistration() {
        return alertRegistration.getText();
    }

    public void regiterUserTwiceWithTheSameData() throws IOException {
        UserData userData = sameDataForRegisterAndLogin();
        registrationSteps(userData.getUserName(), userData.getFirstName(), userData.getLastName(), userData.getEmail(), userData.getPassword());
        waits.waitForElementToBeVisible(logoutButton);
        logoutButton.click();

        waits.waitForElementToBeVisible(loginButton);
        registrationSteps(userData.getUserName(), userData.getFirstName(), userData.getLastName(), userData.getEmail(), userData.getPassword());

    }

    public void loginUserAfterRegistration() throws IOException {
        UserData userData = sameDataForRegisterAndLogin();
        registrationSteps(userData.getUserName(), userData.getFirstName(), userData.getLastName(), userData.getEmail(), userData.getPassword());
        waits.waitForElementToBeVisible(logoutButton);
        logoutButton.click();

        waits.waitForElementToBeVisible(loginButton);
        loginButton.click();
        waits.waitForElementToBeVisible(loginUserNameFieldInLoginWindow);
        loginUserNameFieldInLoginWindow.sendKeys(userData.getUserName());
        passwordFieldInLoginWindow.sendKeys(userData.getPassword());
        loginButtonInLoginWindow.click();
        waits.waitForElementToBeVisible(logoutButton);

    }


    //////////////////////////////////////////////////////////////////////////////Karol Warakomski


    public void clickOnLinkLogin() {
        linkLogin.click();
    }

    public boolean checkEnableLoginButton() {
        waits.waitForElementToBeVisible(buttonLogin);
        return buttonLogin.isEnabled();
    }

    public void clickOnLinkRegister() {
        linkRegister.click();
    }

    public boolean checkEnableRegisterButton() {
        waits.waitForElementToBeVisible(buttonRegister);
        return buttonRegister.isEnabled();
    }

    /*  public void clickOnLinkCatalogue(){
          linkCatalogue.click();
      }*/
    public String getTextFromCataloguePage() {
        waits.waitForElementToBeVisible(catalogueTextOnPageCatalogue);
        return catalogueTextOnPageCatalogue.getText();
    }

    public void selectBlueFromDropDownMenuCatalogue() {
        waits.waitForElementToBeVisible(linkCatalogue);
        actions.moveToElement(linkCatalogue).perform();
        waits.waitForElementToBeClickable(blueFromCatalogueDropDownMenu);
        blueFromCatalogueDropDownMenu.click();
    }

    public void clickOnButtonItemsInCart() {
        buttonItemsInCart.click();
    }

    public String getTextFromButtonItemsInCart() {
        waits.waitForElementToBeRefreshed(buttonItemsInCart);
        return buttonItemsInCart.getText();
    }

    public void clickOnLinkHoly() {
        linkOfProductHoly.click();
    }

    public void clickOnPictureHoly() {
        pictureOfProductHoly.click();
    }

    public void clickOnLinkColorful() {
        linkOfProductColorful.click();
    }

    public void clickOnPictureColorful() {
        pictureOfProductColorful.click();
    }

    public void clickOnLinkSportXL() {
        linkOfProductSuperSportXL.click();
    }

    public void clickOnPictureSportXL() {
        pictureOfProductSuperSportXL.click();
    }

    public void clickOnLinkCrossed() {
        linkOfProductCrossed.click();
    }

    public void clickOnPictureCrossed() {
        pictureOfProductCrossed.click();
    }

    public void clickOnLinkFigueroa() {
        linkOfProductFigueroa.click();
    }

    public void clickOnPictureFigueroa() {
        pictureOfProductFigueroa.click();
    }
    /*public void clickOnFooterLinkLogin(){
        footerLinkLogin.click();*/
    // zrobic przycisk action -> na nastepnej stronie zaznaczony checkbox Filters - action




    public void addinAllNineProductsTocart(){

    linkCatalogue.click();





    }











}

















