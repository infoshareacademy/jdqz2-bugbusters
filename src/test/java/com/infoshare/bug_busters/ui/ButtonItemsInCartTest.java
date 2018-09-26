package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.ColorfulPage;
import com.infoshare.bug_busters.pageObject.HolyPage;
import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.pageObject.ShoppingCartPage;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class ButtonItemsInCartTest {

    //sprawdzic czy testow nie trzeba rozbic na osobne klasy


    private WebDriver driver;

    private ShoppingCartPage shoppingCartPage;
    private HomePage homePage;
    private HolyPage holyPage;
    private ColorfulPage colorfulPage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        shoppingCartPage = new ShoppingCartPage(driver);
        homePage = new HomePage(driver);
        holyPage = new HolyPage(driver);
        colorfulPage = new ColorfulPage(driver);

        driver.get("http://localhost:4180/");
    }


    @Test
    public void buttonItemsInCart() {
        homePage.clickOnButtonItemsInCart();
        assertThat(shoppingCartPage.getTextShippingCart())
                .as("Button was not click").isEqualTo("Shopping cart");
    }

    @Test
    public void linkLogin(){
        homePage.clickOnLinkLogin();
        assertTrue("Login link on the bottom of the page doesn't work", homePage.checkEnableLoginButton());
    }

    @Test
    public void addingToCartHollySocksByClickInLinkFromHomePage(){
        homePage.clickOnLinkHoly();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    @Test
    public void addingToCartHollySocksByClickInPictureFromHomePage(){
        homePage.clickOnPictureHoly();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    @Test
    public void addingToCartColorfulSocksByClickInLinkFromHomePage() {
        homePage.clickOnLinkColorful();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    @Test
    public void addingToCartColorfulSocksByClickPictureFromHomePage() { // za pierwszym razem test przeszedl , a za drugim mialem blad Actual:"0 items in cart" czemu skoro jest refresh?? , a potem 3 razy test przeszedl
        homePage.clickOnPictureColorful();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    // zobaczyc czy zadziala double click ?? wtedy w przycisku itesm in cart sa 2


    @Test
    public void addingToCartSportXLSocksByClickInLinkFromHomePage(){
        homePage.clickOnLinkSportXL();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    @Test
    public void addingToCartSportXLSocksByClickInPictureFromHomePage(){
        homePage.clickOnPictureSportXL();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    @Test
    public void addingToCartCrossedSocksByClickInLinkFromHomePage(){
        homePage.clickOnLinkCrossed();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    @Test
    public void addingToCartCrossedSocksByClickInPictureFromHomePage(){
        homePage.clickOnPictureCrossed();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    @Test
    public void addingToCartFigueroaSocksByClickInLinkFromHomePage(){
        homePage.clickOnLinkFigueroa();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

    @Test
    public void addingToCartFigueroaSocksByClickInPictureFromHomePage(){
        homePage.clickOnPictureFigueroa();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }


    @After
    public void tearDown() {
        driver.close();
    }

}
