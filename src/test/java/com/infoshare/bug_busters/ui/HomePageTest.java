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

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        shoppingCartPage = new ShoppingCartPage(driver);
        homePage = new HomePage(driver);
        holyPage = new HolyPage(driver);
        cataloguePage = new CataloguePage(driver);

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

/*    @Test
    public void transferToCataloguePage(){
        homePage.clickOnLinkCatalogue(); //wykomentowalem ta metode !!!
        assertThat(homePage.getTextFromCataloguePage())
                .as("Page Catalogue was not open").isEqualTo("Catalogue");
    }*/


    @Test
    public void selectFromCatalogueBlue(){
        homePage.selectBlueFromDropDownMenuCatalogue();
        assertTrue("You do not see blue socks", cataloguePage.checkIfBlueCheckboxIsChecked());
    }



    @Test
    public void buttonItemsInCart() {
        homePage.clickOnButtonItemsInCart();
        assertThat(shoppingCartPage.getTextShippingCart())
                .as("Button was not click").isEqualTo("Shopping cart");
    }








    @Test
    public void footerLinkLogin(){
        homePage.clickOnFooterLinkLogin();
        assertTrue("Login link in the footer of the page doesn't work", homePage.checkEnableLoginButton());
    }



    @After
    public void tearDown() {
        driver.close();
    }

}
