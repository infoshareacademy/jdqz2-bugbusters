package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.*;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
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
    public void transferToCataloguePage(){
        homePage.clickOnLinkCatalogue();
        assertThat(homePage.getTextFromCataloguePage())
                .as("Page Catalogue was not open").isEqualTo("Catalogue");
    }

    @Test
    public void buttonItemsInCart() {
        homePage.clickOnButtonItemsInCart();
        assertThat(shoppingCartPage.getTextShippingCart())
                .as("Button was not click").isEqualTo("Shopping cart");
    }

    @Test
    public void transferToColorfulPageByClickOnLeftPictureOnSlider(){
        homePage.selectLeftPictureFromMainSlider();
        assertThat(colorfulPage.getTextConfirmationOfColorfulPage())
                .as("Page Colorful was not open").isEqualTo("Colourful");
        //test czesto przechodzi ale czasem daje fail wydaje mi sie, ze to zalezy od tego jak strona sie zaladuje
        //czemu skoro sa waity??
    }

    @Test
    public void transferToClassicPageByClickOnMiddlePictureOnSlider(){
        homePage.selectMiddlePictureFromMainSlider();
        assertThat(classicPage.getTextConfirmationOfClassicPage())
                .as("Page Classic was not open").isEqualTo("Classic");
        //test czesto przechodzi ale czasem daje fail wydaje mi sie, ze to zalezy od tego jak strona sie zaladuje
        //czemu skoro sa waity??
        //czesciej failuje niz ten wyzej i sie czasami sie zawiesza przy przylaczaniu elementu slidera

        //tez dodac fluent waita
    }

    @Test
    public void transferToHolyPageByClickOnRightPictureOnSlider(){
        homePage.selectRightPictureFromMainSlider();
        assertThat(holyPage.getTextConfirmationOfHolylPage())
                .as("Page Holy was not open").isEqualTo("Holy");
        //test czesto przechodzi ale czasem daje fail wydaje mi sie, ze to zalezy od tego jak strona sie zaladuje
        //czemu skoro sa waity??
        //ani razu poprawnie sie nie wykonal, zacina sie przy przlaczaniu obrazka i go nie klika
        //jakie znaczniki z jakimi atrybutami ze strony  reaguja na metody selenium????


    }







    @Test
    public void footerLinkLogin(){
        homePage.clickOnFooterLinkLogin();
        assertTrue("Login link in the footer of the page doesn't work", homePage.checkEnableLoginButton());
    }



/*    @After
    public void tearDown() {
        driver.close();
    }*/

}
