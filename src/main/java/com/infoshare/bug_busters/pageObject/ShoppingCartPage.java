package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.payment.PaymentDataGenerator;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingData;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;
import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ShoppingCartPage {

    @FindBy (xpath = "//h1[text()='Shopping cart']")
    WebElement textFromHeadingShoppingCart;

    private WebDriver driver;
    private Waits waits;
    private Actions actions;

    private RandomDataGenerator dataGenerator = new RandomDataGenerator();
    private ShippingDataGenerator shippingDataGenerator = new ShippingDataGenerator(new RandomDataGenerator());
    private PaymentDataGenerator paymentDataGenerator = new PaymentDataGenerator();

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTextFromHeadingShippingCart() {
        waits.waitForElementToBeVisible(textFromHeadingShoppingCart);
        return textFromHeadingShoppingCart.getText();
    }


    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    private WebElement textShoppingCart;
    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    private WebElement shoppingCartConfirmatonLabel;
    @FindBy(id = "numItemsInCart")
    private WebElement itemsInCartButton;
    @FindBy(xpath = "//div[@class='row same-height-row']//div[1]//div[1]//div[1]//p[1]//a[1]")
    private WebElement changeButtonShippingAdress;
    @FindBy(id = "form-number")
    private WebElement houseNumberFieldShippingAddress;
    @FindBy(id = "form-street")
    private WebElement streetNameFieldShippingAddress;
    @FindBy(id = "form-city")
    private WebElement cityFieldShippingAddress;
    @FindBy(id= "form-post-code")
    private WebElement postCodeFieldShippingAddress;
    @FindBy(id = "form-country")
    private WebElement countryFieldShippingAddress;
    @FindBy(xpath = "//form[@id='form-address']//button[@class='btn btn-primary'] ")
    private WebElement updateButtonShippingAddress;
    @FindBy(xpath = "//div[@class='row same-height-row']//div[2]//div[1]//div[1]//p[1]//a[1]")
    private WebElement changePaymentButton;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")
    private WebElement cardNumberFieldPayment;
    @FindBy(id = "form-expires")
    private WebElement cardExpiresFiledPayment;
    @FindBy(id = "form-ccv")
    private WebElement ccvFieldPayment;
    @FindBy(xpath = " //p[@class='text-right']//button[@class='btn btn-primary']")
    private WebElement updateButtonPayment;
    @FindBy(id= "orderButton")
    private WebElement proceedToCheckOutButton;
    @FindBy(xpath = " //a[contains(text(),'Colourful')]")
    private WebElement colorfulInscriptionOnShoppingCartWebsite;
    @FindBy(id = "buttonCart")
    private WebElement addToCartButton;
    @FindBy(xpath = "//span[@class='label-success']")
    private WebElement labelShipped;
    @FindBy(xpath = "//tbody[@id='tableOrders']//tr[1]//td[4]//a[1]")
    private WebElement viewButton;
    @FindBy(xpath = "//i[@class='fa fa-trash-o']")
    private WebElement deleteRubishBinIcon;


    public void shippingAdressSteps(ShippingData shippingData) {
        changeButtonShippingAdress.click();
        waits.waitForElementToBeVisible(houseNumberFieldShippingAddress);
        houseNumberFieldShippingAddress.sendKeys(shippingData.getHouseNumber().toString());
        streetNameFieldShippingAddress.sendKeys(shippingData.getStreetName());
        cityFieldShippingAddress.sendKeys(shippingData.getCity());
        postCodeFieldShippingAddress.sendKeys(shippingData.getPostCode());
        countryFieldShippingAddress.sendKeys(shippingData.getCountry());
        updateButtonShippingAddress.click();
        waits.waitForElementToBeVisible(changePaymentButton);
    }
    public void fillingShippingAddressInfowithDataGeneratorMethodFillingPaymentsInfowithDataGeneratorMethod() throws IOException {
        shippingAdressSteps(shippingDataGenerator.prepareShippingData());
        addinPaymentsSteps(paymentDataGenerator.preparePayments());
    }

    public void addinPaymentsSteps(PaymentData paymentData) {
        changePaymentButton.click();
        waits.waitForElementToBeVisible(cardNumberFieldPayment);
        cardNumberFieldPayment.click();
        cardNumberFieldPayment.sendKeys(paymentData.getCardNumber());
        cardExpiresFiledPayment.sendKeys(paymentData.getExpires());
        ccvFieldPayment.sendKeys(paymentData.getCcv());
        updateButtonPayment.click();
    }

    public void addOnlyOneProductColorFulltoToCartFromShoppingCartPage() {
        try {
            itemsInCartButton.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement button = driver.findElement(By.id("numItemsInCart]"));
            itemsInCartButton.click();
        }
        waits.waitForElementToBeVisible(colorfulInscriptionOnShoppingCartWebsite);
        colorfulInscriptionOnShoppingCartWebsite.click();
        waits.waitForElementToBeRefreshed(addToCartButton);
        addToCartButton.click();
        try {
            itemsInCartButton.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement button = driver.findElement(By.id("numItemsInCart"));
            itemsInCartButton.click();
        }
    }

    public String getTextFromButtonItemsInCart() {
        waits.waitForTextInElementToBePresent(By.id("numItemsInCart"));
        return itemsInCartButton.getText();
    }
    public void clickOnIteamsInCartButton() {
        try {
            itemsInCartButton.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement button = driver.findElement(By.id("numItemsInCart]"));
            itemsInCartButton.click();
        }
    }
    public void clickProcedToCheckoutandViewButton() {
        proceedToCheckOutButton.click();
        waits.waitForElementToBeClickable(viewButton);
        actions.moveToElement(viewButton).perform();
        viewButton.click();
    }
}