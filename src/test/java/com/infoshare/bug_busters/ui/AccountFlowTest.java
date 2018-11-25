package com.infoshare.bug_busters.ui;
import com.infoshare.bug_busters.pageObject.AccountPage;
import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.pageObject.ShoppingCartPage;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.io.IOException;


public class AccountFlowTest {

    private WebDriver driver;
    private HomePage homePage;
    private AccountPage accountPage;
    private ShoppingCartPage shoppingCartPage;
    private final String URL=("http://localhost:4180/");

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        driver.get(URL);
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void flowTestifNewOrderShowsUpInMyOrdersTabandViewButtonWorks() throws IOException {
        homePage.loginUserAfterRegistrationWithDDT();
        Assertions.assertThat(homePage.getTextFromLogoutToConfirmLoginOrRegistration().contains("Logout")).as("User is not Logged");
        accountPage.clickOnLabelAccount();
        shoppingCartPage.clickOnIteamsInCartButton();
        shoppingCartPage.fillingShippingAddressInfowithDataGeneratorMethodFillingPaymentsInfowithDataGeneratorMethod();
        shoppingCartPage.addOnlyOneProductColorFulltoToCartFromShoppingCartPage();
        Assertions.assertThat(shoppingCartPage.getTextFromButtonItemsInCart()).as("Item not added").isEqualTo("1 item(s) in cart");
        shoppingCartPage.clickProcedToCheckoutandViewButton();
        Assertions.assertThat(accountPage.getTextFromColorFulLabelInMyOrders())
                .as("Order for Socks Colorful has not been added").isEqualTo("Colourful");
    }
}