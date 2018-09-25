package com.infoshare.bug_busters.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartClass {
    private WebDriver driver;
    private WebDriverWait waits;

    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    private WebElement shoppingCartConfirmatonLabel;
    @FindBy(xpath ="//span[@id='numItemsInCart']")
    private WebElement itemsInCartButton;
    @FindBy(xpath ="//a[contains(text(),'contact us')]")
    private WebElement contactUsEmailLink;

    public ShoppingCartClass(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
