package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.payment.PaymentDataGenerator;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;
import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;


public class ShoppingCartPage {


    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    private WebElement shoppingCartConfirmatonLabel;

    @FindBy(xpath = "//span[@id='numItemsInCart']")
    private WebElement itemsInCartButton;

    @FindBy(xpath = "//div[@class='row same-height-row']//div[1]//div[1]//div[1]//p[1]//a[1]")
    private WebElement changeButtonShippingAdress;

    @FindBy(xpath = "//input[@id='form-number']")
    private WebElement houseNumberFieldShippingAddress;

    @FindBy(xpath = "//input[@id='form-street']")
    private WebElement streetNameFieldShippingAddress;

    @FindBy(xpath = "//input[@id='form-city']")
    private WebElement cityFieldShippingAddress;

    @FindBy(xpath = "//input[@id='form-post-code']")
    private WebElement postCodeFieldShippingAddress;

    @FindBy(xpath = " //input[@id='form-country']")
    private WebElement countryFieldShippingAddress;

    @FindBy(xpath = "//form[@id='form-address']//button[@class='btn btn-primary'] ")
    private WebElement updateButtonShippingAddress;

    @FindBy(xpath = "//div[@class='row same-height-row']//div[2]//div[1]//div[1]//p[1]//a[1]")
    private WebElement changePaymentButton;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")
    private WebElement cardNumberFieldPayment;

    @FindBy(xpath = " //input[@id='form-expires']")
    private WebElement cardExpiresFiledPayment;


    @FindBy(xpath = " //input[@id='form-ccv']")
    private WebElement ccvFieldPayment;

    @FindBy(xpath = " //p[@class='text-right']//button[@class='btn btn-primary']")
    private WebElement updateButtonPayment;


    @FindBy(xpath = " //button[@id='orderButton']")
    private WebElement proceedToCheckOutButton;

    @FindBy(xpath = " //a[contains(text(),'Colourful')]")
    private WebElement colorfulInscriptionOnShoppingCartWebsite;

    @FindBy(xpath = " //a[@id='buttonCart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='label-success']")
    private WebElement labelShipped;


    private WebDriver driver;
    private Waits waits;
    private UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());
    private ShippingDataGenerator shippingDataGenerator = new ShippingDataGenerator(new RandomDataGenerator());
    private PaymentDataGenerator paymentDataGenerator = new PaymentDataGenerator(new RandomDataGenerator());




    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickoInscriptionCorolful() {
        waits.waitForElementToBeVisible(colorfulInscriptionOnShoppingCartWebsite);
        colorfulInscriptionOnShoppingCartWebsite.click();
    }




    public String getTextFromButtonItemsInCart() {
            waits.waitForElementToBeRefreshed(itemsInCartButton);
            return itemsInCartButton.getText();}



    public void clickOnIteamsInCartButton() {

        try { itemsInCartButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement button = driver.findElement(By.xpath("//span[@id='numItemsInCart']"));
            itemsInCartButton.click();
        }
    }

    public void clickOnAddToCartButton() {
        waits.waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();

    }public void clickOnLabelShipped() {labelShipped.click();
    waits.waitForElementToBeVisible(labelShipped);
    }


    public void fillingShippingAddressInfowithDataGeneratorMethod(Integer houseNumber, String streetName, String city, String postCode, String country) throws IOException {
        changeButtonShippingAdress.click();
        waits.waitForElementToBeVisible(houseNumberFieldShippingAddress);
        houseNumberFieldShippingAddress.sendKeys(houseNumber.toString());
        streetNameFieldShippingAddress.sendKeys(streetName);
        cityFieldShippingAddress.sendKeys(city);
        postCodeFieldShippingAddress.sendKeys(postCode);
        countryFieldShippingAddress.sendKeys(country);
        updateButtonShippingAddress.click();
        waits.waitForElementToBeVisible(changePaymentButton);


    }

    public void fillingPaymentDatawithDataGenerator(String cardNumber, String expires, String CCV) {
        changePaymentButton.click();
        waits.waitForElementToBeVisible(cardNumberFieldPayment);
        cardNumberFieldPayment.click();
        cardNumberFieldPayment.sendKeys(cardNumber);
        cardExpiresFiledPayment.sendKeys(expires);
        ccvFieldPayment.sendKeys(CCV);
        updateButtonPayment.click();
    }

    public void addItemsToShoppingCartList() {

        addToCartButton.click();
        waits.waitForElementToBeVisible(itemsInCartButton);
        itemsInCartButton.click();
    }
    public void addIteamsToShoppingCartandCheckout() {

        /*addToCartButton.click();
        waits.waitForElementToBeVisible(itemsInCartButton);
        itemsInCartButton.click();
        waits.waitForElementToBeVisible(itemsInCartButton);*/
        proceedToCheckOutButton.click();
        waits.waitForElementToBeVisible(labelShipped);
    }


}




