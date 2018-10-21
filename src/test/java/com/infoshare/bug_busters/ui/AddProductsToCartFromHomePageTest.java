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

public class AddProductsToCartFromHomePageTest {

    private WebDriver driver;
    private HomePage homePage;
    private HolyPage holyPage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        holyPage = new HolyPage(driver);
        driver.get("http://localhost:4180/");
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
    public void addingToCartColorfulSocksByClickPictureFromHomePage() {
        homePage.clickOnPictureColorful();
        holyPage.clickOnButtonAddToCart();
        assertThat(homePage.getTextFromButtonItemsInCart())
                .as("Item was not add to cart")
                .isEqualTo("1 item(s) in cart");
    }

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
