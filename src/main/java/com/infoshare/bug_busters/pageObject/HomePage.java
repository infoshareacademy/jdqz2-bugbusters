package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import java.io.IOException;

public class HomePage {

    @FindBy(xpath = "//li[@id='login']/child::a")
    private WebElement linkLogin;

    @FindBy(xpath = "//div[@id='login-modal']//button[@class='btn btn-primary']")
    private WebElement buttonLogin;

    @FindBy (linkText ="Register")
    private WebElement linkRegister;

    @FindBy(xpath = "//div[@id='register-modal']//button[@class='btn btn-primary']")
    private WebElement buttonRegister;

    @FindBy(xpath = "//li[@id='tabIndex']/child::a")
    private WebElement linkHomeAtTopOfPage;

    @FindBy(xpath = "//a[contains(text(),'We love socks!')]")
    private WebElement textConfirmingBeeingOnHomePage;

    @FindBy(xpath = "//li[@id='tabCatalogue']/child::a")
    private WebElement linkCatalogueAtTopOfPage;

    @FindBy(xpath = "//a[text()='Blue']")
    private WebElement blueFromCatalogueDropDownMenu;

    @FindBy (xpath = "//a[text()='Brown']")
    private WebElement brownFromCatalogueDropDownMenu;

    @FindBy (xpath = "//a[text()='Green']")
    private WebElement greenFromCatalogueDropDownMenu;

    @FindBy (xpath = "//div[@class='col-sm-3']//a[contains(text(),'Magic')]")
    private WebElement magicFromCatalogueDropDownMenu;

    @FindBy (xpath = "//a[text()='Formal']")
    private WebElement formalFromCatalogueDropDownMenu;

    @FindBy(id = "numItemsInCart")
    private WebElement buttonItemsInCart;

    @FindBy(xpath = "//div[@id='main-slider']//div[@class='owl-pagination']/child::div[1]//span")
    private WebElement leftDotOnMainSlider;

    @FindBy(xpath = "//*[contains(@src,'img/colourful_socks_banner')]")
    private WebElement leftPictureOnMainSlider;

    @FindBy(xpath = "//div[@id='main-slider']//div[@class='owl-pagination']/child::div[2]//span")
    private WebElement middleDotOnMainSlider;

    @FindBy(xpath = "//*[contains(@src,'img/rugby_socks_banner')]")
    private WebElement middlePictureOnMainSlider;

    @FindBy(xpath = "//div[@id='main-slider']//div[@class='owl-pagination']/child::div[3]//span")
    private WebElement rightDotOnMainSlider;

    @FindBy(xpath = "//*[contains(@src,'img/holy_socks_banner')]")
    private WebElement rightPictureOnMainSlider;

    @FindBy(linkText = "Holy")
    private WebElement linkOfProductHoly;

    @FindBy(xpath = "//img[contains(@src,'/catalogue/images/holy_1')]")
    private WebElement pictureOfProductHoly;

    @FindBy(linkText = "Colourful")
    private WebElement linkOfProductColorful;

    @FindBy(xpath = "//img[contains(@src,'/catalogue/images/colourful_socks')]")
    private WebElement pictureOfProductColorful;

    @FindBy(linkText = "SuperSport XL")
    private WebElement linkOfProductSuperSportXL;

    @FindBy(xpath = "//img[contains(@src,'/catalogue/images/puma_1')]")
    private WebElement pictureOfProductSuperSportXL;

    @FindBy(linkText = "Crossed")
    private WebElement linkOfProductCrossed;

    @FindBy(xpath = "//img[contains(@src,'/catalogue/images/cross_1.jpeg')]")
    private WebElement pictureOfProductCrossed;

    @FindBy(linkText = "Figueroa")
    private WebElement linkOfProductFigueroa;

    @FindBy(xpath = "//img[contains(@src,'/catalogue/images/WAT')]")
    private WebElement pictureOfProductFigueroa;

    @FindBy(xpath = "//div[@id='footer']//a[@href='index.html']")
    private WebElement linkHomeAtFooter;

    @FindBy(linkText = "Catalogue")
    private WebElement linkCatalogueAtFooter;

    @FindBy(xpath = "//div[@id='footer']//a[contains(text(),'Login')]")
    private WebElement linkLoginAtFooter;

    @FindBy(linkText = "Cart")
    private WebElement linkCartAtFooter;

    @FindBy(linkText = "Orders")
    private WebElement linkOrdersAtFooter;

    @FindBy(xpath = "//div[@id='footer']//a[contains(text(),'Magic')]")
    private WebElement linkMagicAtFooter;

    @FindBy(linkText = "Sport")
    private WebElement linkSportAtFooter;

    @FindBy(linkText = "Action")
    private WebElement linkActionAtFooter;

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

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement labelCatalogue;

    @FindBy(xpath = "//img[@class='hidden-xs']")
    private WebElement logoElement;

    @FindBy(xpath = "//a[@class='btn btn-primary navbar-btn']")
    private WebElement itemsInCartButton;

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

    public void loginSteps(UserData userData) {
        waits.waitForElementToBeClickable(loginButton);
        loginButton.click();
        waits.waitForElementToBeVisible(loginUserNameFieldInLoginWindow);
        loginUserNameFieldInLoginWindow.sendKeys(userData.getUserName());
        passwordFieldInLoginWindow.sendKeys(userData.getPassword());
        loginButtonInLoginWindow.click();
        waits.waitForElementToBeVisible(logoutButton);
    }

    public UserData registrationSteps(UserData userData) {

        registerButton.click();
        waits.waitForElementToBeVisible(userNameFieldInRegistration);
        userNameFieldInRegistration.sendKeys(userData.getUserName());
        firstNameFieldInRegistration.sendKeys(userData.getFirstName());
        lastNameFieldInRegistration.sendKeys(userData.getLastName());
        emailFieldInRegistration.sendKeys(userData.getEmail());
        passwordFieldInRegistration.sendKeys(userData.getPassword());
        registerinPopUpWindowButton.click();
        return userData;

    }

    public void clickItemsInCartButton() {
        itemsInCartButton.click();
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        waits.waitForElementToBeVisible(shoppingCart.shoppingCartText);
    }

    public void registerUserWithDataGeneratorMethodWithDDT(UserData userData) {

        registrationSteps(userData);
        waits.waitForElementToBeVisible(logoutButton);

    }

    public void registerUserTwiceWithTheSameDataWithDDT(UserData userData) {

        registrationSteps(userData);
        waitsWhenLogout();
        registrationSteps(userData);

    }

    public void loginUserAfterRegistrationWithDDT(UserData userData) {

        registrationSteps(userData);
        waitsWhenLogout();
        loginSteps(userData);

    }
    public void loginUserAfterRegistrationWithDDT() throws IOException {

        UserData userData = userDataGenerator.prepareUserData();
        registrationSteps(userData);
        waitsWhenLogout();
        loginSteps(userData);

    }
    public void chooseCatalogue() {
        waits.waitForElementToBeVisible(labelCatalogue);
        waits.waitForElementToBeClickable(labelCatalogue);
        labelCatalogue.click();
    }

    public void clickOnLinkLogin() {linkLogin.click();}

    public boolean checkEnableLoginButton(){
        waits.waitForElementToBeVisible(buttonLogin);
        return buttonLogin.isEnabled();
    }

    public void clickOnLinkRegister() {linkRegister.click();}

    public boolean checkEnableRegisterButton(){
        waits.waitForElementToBeVisible(buttonRegister);
        return buttonRegister.isEnabled();
    }

    public void clickOnLinkHome(){
        linkHomeAtTopOfPage.click();
    }

    public String getTextFromHomePage(){
        waits.waitForElementToBeVisible(textConfirmingBeeingOnHomePage);
        return textConfirmingBeeingOnHomePage.getText();
    }

    public void clickOnLinkCatalogue(){
        linkCatalogueAtTopOfPage.click();
    }

    public void moveMouseCursorOnCatalogue(){
        waits.waitForElementToBeVisible(linkCatalogueAtTopOfPage);
        actions.moveToElement(linkCatalogueAtTopOfPage).perform();
    }

    public void selectBlueFromDropDownMenuCatalogue(){
        moveMouseCursorOnCatalogue();
        waits.waitForElementToBeClickable(blueFromCatalogueDropDownMenu);
        blueFromCatalogueDropDownMenu.click();
    }

    public void selectBrownFromDropDownMenuCatalogue(){
        moveMouseCursorOnCatalogue();
        waits.waitForElementToBeClickable(brownFromCatalogueDropDownMenu);
        brownFromCatalogueDropDownMenu.click();
    }

    public void selectGreenFromDropDownMenuCatalogue(){
        moveMouseCursorOnCatalogue();
        waits.waitForElementToBeClickable(greenFromCatalogueDropDownMenu);
        greenFromCatalogueDropDownMenu.click();
    }

    public void selectMagicFromDropDownMenuCatalogue(){
        moveMouseCursorOnCatalogue();
        waits.waitForElementToBeClickable(magicFromCatalogueDropDownMenu);
        magicFromCatalogueDropDownMenu.click();
    }

    public void selectFormalFromDropDownMenuCatalogue(){
        moveMouseCursorOnCatalogue();
        waits.waitForElementToBeClickable(formalFromCatalogueDropDownMenu);
        formalFromCatalogueDropDownMenu.click();
    }

    public void selectLeftPictureFromMainSlider(){
        waits.waitForElementToBeClickable(leftDotOnMainSlider);
        leftDotOnMainSlider.click();
        waits.waitForElementToBeVisible(leftPictureOnMainSlider);
        leftPictureOnMainSlider.click();
    }

    public void selectMiddlePictureFromMainSlider(){
        waits.waitForElementToBeClickable(middleDotOnMainSlider);
        middleDotOnMainSlider.click();
        waits.waitForElementToBeVisible(middlePictureOnMainSlider);
        middlePictureOnMainSlider.click();
    }

    public void selectRightPictureFromMainSlider(){
        waits.waitForElementToBeClickable(rightDotOnMainSlider);
        rightDotOnMainSlider.click();
        waits.waitForElementToBeVisible(rightPictureOnMainSlider);
        rightPictureOnMainSlider.click();
    }

    public void clickOnButtonItemsInCart(){
        buttonItemsInCart.click();
    }

    public String getTextFromButtonItemsInCart() {
        waits.waitForTextInElementToBePresent(By.id("numItemsInCart"));
        return buttonItemsInCart.getText();
    }

    public void clickOnLinkHoly(){
        linkOfProductHoly.click();
    }

    public void clickOnPictureHoly(){
        pictureOfProductHoly.click();
    }

    public void clickOnLinkColorful(){
        linkOfProductColorful.click();
    }

    public void clickOnPictureColorful(){
        pictureOfProductColorful.click();
    }

    public void clickOnLinkSportXL(){
        linkOfProductSuperSportXL.click();
    }

    public void clickOnPictureSportXL(){
        pictureOfProductSuperSportXL.click();
    }

    public void clickOnLinkCrossed(){
        linkOfProductCrossed.click();
    }

    public void clickOnPictureCrossed(){
        pictureOfProductCrossed.click();
    }

    public void clickOnLinkFigueroa(){
        linkOfProductFigueroa.click();
    }

    public void clickOnPictureFigueroa(){
        pictureOfProductFigueroa.click();
    }

    public void clickOnFooterLinkHome(){
        linkHomeAtFooter.click();
    }

    public void clickOnFooterLinkCatalogue(){
        linkCatalogueAtFooter.click();
    }

    public void clickOnFooterLinkLogin(){
        linkLoginAtFooter.click();
    }

    public void clickOnFooterLinkCart(){
        linkCartAtFooter.click();
    }

    public void clickOnFooterLinkOrders(){
        linkOrdersAtFooter.click();
    }

    public void clickOnFooterLinkMagic(){
        linkMagicAtFooter.click();
    }

    public void clickOnFooterLinkSport(){
        linkSportAtFooter.click();
    }

    public void clickOnFooterLinkAction(){
        linkActionAtFooter.click();
    }
}
