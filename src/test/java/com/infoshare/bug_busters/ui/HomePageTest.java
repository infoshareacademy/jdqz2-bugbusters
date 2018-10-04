package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.*;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class HomePageTest {

    private WebDriver driver;
    private ShoppingCartPage shoppingCartPage;
    private HomePage homePage;
    private HolyPage holyPage;
    private CataloguePage cataloguePage;
    private ColorfulPage colorfulPage;
    private ClassicPage classicPage;
    private MyOrdersPage myOrdersPage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        shoppingCartPage = new ShoppingCartPage(driver);
        homePage = new HomePage(driver);
        holyPage = new HolyPage(driver);
        cataloguePage = new CataloguePage(driver);
        colorfulPage = new ColorfulPage(driver);
        classicPage = new ClassicPage(driver);
        myOrdersPage = new MyOrdersPage(driver);

        driver.get("http://localhost:4180/");
    }

    @Test
    public void linkLogin(){
        homePage.clickOnLinkLogin();
        assertTrue("Login link in the top menu of the page doesn't work", homePage.checkEnableLoginButton());
    }

    @Test
    public void linkRegister(){
        homePage.clickOnLinkRegister();
        assertTrue("Register link in the top menu of the page doesn't work", homePage.checkEnableRegisterButton());
    }

    @Test
    public void transferToHomePageFromTheTopHomeLink(){
        homePage.clickOnLinkHome();
        assertThat(homePage.getTextFromHomePage()).
                as("You are not at Home Page").isEqualTo("WE LOVE SOCKS!");
    }

    @Test
    public void transferToCataloguePage(){
        homePage.clickOnLinkCatalogue();
        assertThat(cataloguePage.getTextFromCataloguePage())
                .as("Page Catalogue was not open").isEqualTo("Catalogue");
    }

    @Test
    public void buttonItemsInCart() {
        homePage.clickOnButtonItemsInCart();
        assertThat(shoppingCartPage.getTextFromHeadingShippingCart())
                .as("Button was not click").isEqualTo("Shopping cart");
    }

    @Test
    public void transferToColorfulPageByClickOnLeftPictureOnSlider(){
        homePage.selectLeftPictureFromMainSlider();
        assertThat(colorfulPage.getTextConfirmationOfColorfulPage())
                .as("Page Colorful was not open").isEqualTo("Colourful");
    }

    @Test
    public void transferToClassicPageByClickOnMiddlePictureOnSlider(){
        homePage.selectMiddlePictureFromMainSlider();
        assertThat(classicPage.getTextConfirmationOfClassicPage())
                .as("Page Classic was not open").isEqualTo("Classic");
    }

    @Test
    public void transferToHolyPageByClickOnRightPictureOnSlider(){
        homePage.selectRightPictureFromMainSlider();
        assertThat(holyPage.getTextConfirmationOfHolylPage())
                .as("Page Holy was not open").isEqualTo("Holy");
    }

    @Test
    public void transferToHomePageFooterHome(){
        homePage.clickOnFooterLinkHome();
        assertThat(homePage.getTextFromHomePage()).
                as("You are not at Home Page").isEqualTo("WE LOVE SOCKS!");
    }

    @Test
    public void transferToCataloguePageFromFooterLinkCatalogue(){
        homePage.clickOnFooterLinkCatalogue();
        assertThat(cataloguePage.getTextFromCataloguePage()).
                as("You are not at Catalogue Page").isEqualTo("Catalogue");
    }

    @Test
    public void footerLinkLogin(){
        homePage.clickOnFooterLinkLogin();
        assertTrue("Login link in the footer of the page doesn't work", homePage.checkEnableLoginButton());
    }

    @Test
    public void transferToShoppingCarPageFromFooterLinkCart(){
        homePage.clickOnFooterLinkCart();
        assertThat(shoppingCartPage.getTextFromHeadingShippingCart()).
                as("You are not at Shopping Cart Page").isEqualTo("Shopping cart");
    }

    @Test
    public void transferToMyOrdersCarPageFromFooterLinkOrders(){
        homePage.clickOnFooterLinkOrders();
        assertThat(myOrdersPage.getTextFromHeadingMyOrders()).
                as("You are not at My Orders Page").isEqualTo("My orders");
    }

    @Test
    public void transferToMagicProductsInCataloguePageFromFooterLinkMagic(){
        homePage.clickOnFooterLinkMagic();
        assertTrue("You are not at Magic Products in Catalogue Page", cataloguePage.checkIfMagicCheckboxIsChecked());
    }

    @Test
    public void transferToSportProductsInCataloguePageFromFooterLinkSport(){
        homePage.clickOnFooterLinkSport();
        assertTrue("You are not at Sport Products in Catalogue Page", cataloguePage.checkIfSportCheckboxIsChecked());
    }

    @Test
    public void transferToActionProductsInCataloguePageFromFooterLinkAction(){
        homePage.clickOnFooterLinkAction();
        assertTrue("You are not at Action Products in Catalogue Page", cataloguePage.checkIfActionCheckboxIsChecked());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
