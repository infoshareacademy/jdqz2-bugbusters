package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductPage {

    private static Logger logger = LoggerFactory.getLogger(ProductPage.class);

    private Actions actions;
    private WebDriver driver;
    private Waits waits;
    @FindBy(id="productDetails")
    private WebElement productDetails;
    @FindBy(xpath = "//a[@class='scroll-to']")
    private WebElement scrollProduct;
    @FindBy(xpath = "//a[@id='buttonCart']")
    private WebElement buttonAddToCart;

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
        try {
            return driver.findElement(By.id("numItemsInCart")).getText();
        } catch (StaleElementReferenceException e) {
            logger.info(e.getMessage());
            logger.info("Search again");
            return driver.findElement(By.id("numItemsInCart")).getText();
        }
    }

    public String getTextFromElementProductDetalis() {
        return productDetails.getText();
    }

    private void showProduct() {
        scrollProduct.click();
        productDetails.isDisplayed();
    }
}