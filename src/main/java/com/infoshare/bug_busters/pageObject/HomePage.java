package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //@FindBy(css = "#numItemsInCart")
    @FindBy(xpath = "//span[@id='numItemsInCart']")
    private WebElement buttonItemsInCart;

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6']//ul//li//a[@href='#'][contains(text(),'Login')]")
    private WebElement linkLogin;

    @FindBy(xpath = "//div[@id='login-modal']//button[@class='btn btn-primary']")
    private WebElement buttonLogin;

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



    private WebDriver driver;
    private Waits waits;


    public HomePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnButtonItemsInCart(){
        buttonItemsInCart.click();
    }

    public void clickOnLinkLogin(){
        linkLogin.click();
    }

    public boolean checkEnableLoginButton(){
        waits.waitForElementToBeVisible(buttonLogin);
        return buttonLogin.isEnabled();
    }

    public void clickOnLinkHoly(){
        linkOfProductHoly.click();
    }

    public void clickOnPictureHoly(){
        pictureOfProductHoly.click();
    }

    public String getTextFromButtonItemsInCart() {
        waits.waitForElementToBeRefreshed(buttonItemsInCart);
        return buttonItemsInCart.getText();
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


    // zrobic przycisk action -> na nastepnej stronie zaznaczony checkbox Filters - action
}
