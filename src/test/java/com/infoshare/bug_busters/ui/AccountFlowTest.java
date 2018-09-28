package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.AccountPage;
import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.pageObject.ShoppingCartPage;
import com.infoshare.bug_busters.payment.PaymentDataGenerator;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountFlowTest {


    private WebDriver driver;

    private HomePage homePage;

    private AccountPage accountPage;

    private ShoppingCartPage shoppingCartPage;

    private UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());
    private ShippingDataGenerator shippingDataGenerator = new ShippingDataGenerator(new RandomDataGenerator());
    private PaymentDataGenerator paymentDataGenerator = new PaymentDataGenerator(new RandomDataGenerator());


    @Before
    public void setUp() throws IOException {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);


    }

   /*@After
    public void tearDown() {
        driver.close();

    }*/

    @Test

    public void testinIfOrdersAreVisibleInMyOrderPageInUserAccounAnd() throws IOException {

        driver.get("http://localhost:4180/");
        homePage.loginUserAfterRegistration();
        accountPage.clickOnLabelAccount();
        shoppingCartPage.clickOnIteamsInCartButton();
        shoppingCartPage.fillingShippingAddressInfowithDataGeneratorMethod(shippingDataGenerator.prepareShippingData().getHouseNumber(), shippingDataGenerator.prepareShippingData().getStreetName(), shippingDataGenerator.prepareShippingData().getCity(), shippingDataGenerator.prepareShippingData().getPostCode(), shippingDataGenerator.prepareShippingData().getCountry());
        shoppingCartPage.fillingPaymentDatawithDataGenerator(paymentDataGenerator.preparePayments().getCardNumber(), paymentDataGenerator.preparePayments().getExpires(), paymentDataGenerator.preparePayments().getCcv());
        shoppingCartPage.clickoInscriptionCorolful();
        shoppingCartPage.clickOnAddToCartButton();
        shoppingCartPage.clickOnIteamsInCartButton();
        Assertions.assertThat(shoppingCartPage.getTextFromButtonItemsInCart()).as(" Item was not added to shopping cart").isBetween("0 items in cart","You currently have 1 item(s) in your cart.");
        shoppingCartPage.clickdProcedToCheckout();
        /*shoppingCartPage.clickOnViewButton();*/
        /*String actualString = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm']")).getText();
        assertTrue("Product is visible", actualString.contains("View"));*/
        Assertions.assertThat(shoppingCartPage.getTextFromViewButton()).as("View").isEqualTo("View");
        Assertions.assertThat(accountPage.getTextFromColorFulLabelInMyOrders()).as("Order for Socks Colorful with  Brand has not been added").isEqualTo("Colourful");



        /* shoppingCartPage.clickOnViewButton();*/







    }
}
