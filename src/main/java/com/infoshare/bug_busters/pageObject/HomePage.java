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

    @FindBy(xpath = "//div[@class='back']//a[@href='detail.html?id=03fef6ac-1896-4ce8-bd69-b798f85c6e0b']//img[@class='img-responsive']")
    private WebElement pictureOfProductHoly;


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
        waits.waitForElementToBeClickable(pictureOfProductHoly);
        pictureOfProductHoly.click();
    }

    public String getTextFromButtonItemsInCart() {
        waits.waitForElementToBeRefreshed(buttonItemsInCart);
        return buttonItemsInCart.getText();
    }
}
