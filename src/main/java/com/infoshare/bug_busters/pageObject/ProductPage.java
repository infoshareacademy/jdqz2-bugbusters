package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private Actions actions;
    private WebDriver driver;
    private Waits waits;
    @FindBy(id="productDetails")
    WebElement productDetails;
    @FindBy(xpath = "//a[@class='scroll-to']")
    WebElement scrollProduct;
    @FindBy(xpath = "//a[@id='buttonCart']")
    WebElement buttonAddToCart;
    @FindBy(id="numItemsInCart")
    WebElement buttoNnumberOfElementsInCart;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public void checkProductsDetails() {
        showProduct();
        buttonAddToCart.isDisplayed();
    }
    public void addingProduct() {
        showProduct();
        actions.moveToElement(buttonAddToCart).perform();
        waits.waitForElementToBeVisible(buttonAddToCart);
        waits.waitForElementToBeClickable(buttonAddToCart);
        buttonAddToCart.click();
    }
    public String getTextFromButtonNumberOfElementsInCart() {
        return buttoNnumberOfElementsInCart.getText();
    }

    public String getTextFromElementProductDetalis() {
        return productDetails.getText();
    }

    private void showProduct() {
        scrollProduct.click();
        productDetails.isDisplayed();
    }
}