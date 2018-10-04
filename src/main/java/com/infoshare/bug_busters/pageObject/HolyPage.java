package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HolyPage {

    @FindBy(id = "buttonCart")
    WebElement buttonAddToCart;

    @FindBy(id = "title")
    WebElement textHolyOnProductSite;

    private WebDriver driver;
    private Waits waits;

    public HolyPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        // Remember to use this! If you use HomePage.class you will get memory leak!
        PageFactory.initElements(driver, this);
    }

    public void clickOnButtonAddToCart() {
        waits.waitForElementToBeClickable(buttonAddToCart);
        buttonAddToCart.click();
    }

    public String getTextConfirmationOfHolylPage(){
        waits.waitForElementToBeVisible(textHolyOnProductSite);
        return textHolyOnProductSite.getText();
    }
}
