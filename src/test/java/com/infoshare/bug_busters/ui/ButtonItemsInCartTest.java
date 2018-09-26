package com.infoshare.bug_busters.ui;

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

    private WebDriver driver;

    private ShoppingCartPage shoppingCartPage;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        shoppingCartPage = new ShoppingCartPage(driver);
        homePage = new HomePage(driver);

        driver.get("http://localhost:4180/");
    }


    @Test
    public void buttonItemsInCartTest() {

        homePage.clickOnButtonItemsInCart();
        assertThat(shoppingCartPage.getTextShippingCart())
                .as("Button was not click").isEqualTo("Shopping cart");
    }

    @Test
    public void linkLoginTest(){
        homePage.clickOnLinkLogin();
        assertTrue("Login link on the bottom of the page doesn't work", homePage.checkEnableLoginButton());
    }

   /* @After
    public void tearDown() {
        driver.close();
    }*/

}
