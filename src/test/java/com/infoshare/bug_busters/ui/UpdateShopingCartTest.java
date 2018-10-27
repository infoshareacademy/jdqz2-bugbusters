package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.Catalogue;
import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.pageObject.ShoppingCart;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(DataProviderRunner.class)
public class UpdateShopingCartTest {
    private final String PAGE_URL = "http://localhost:4180/";

    private WebDriver driver;

    private HomePage homePage;

    private ShoppingCart shoppingCart;

    private Catalogue catalogue;

    private static UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

    private static int iteration;

    private static List<Boolean> setUserCreated = new ArrayList<>();

    private Boolean isUserCreated() {
        return setUserCreated.set(iteration, true);
    }
    @DataProvider
    public static Object[][] testDataForRegistration() throws IOException {
        return new Object[][] {
                new Object[] { userDataGenerator.prepareUserData() , false},
                new Object[] { userDataGenerator.prepareUserData() , false},
        };
    }

    @BeforeClass
    public static void setUpBeforeAll() {
            iteration = 0;
            setUserCreated.add(false);
            setUserCreated.add(false);
            setUserCreated.add(false);
            setUserCreated.add(false);
            setUserCreated.add(false);
    }

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        shoppingCart = new ShoppingCart(driver);
        catalogue = new Catalogue(driver);

    }

    @After
    public void tearDown() {
        shoppingCart.resetCartBasketAfterTest();
        driver.close();
    }

    @Test
    @UseDataProvider("testDataForRegistration")
    public void addingAllPossibleProducts(UserData userData, Boolean setUserCreated2) {
        if(!setUserCreated2 && !setUserCreated.get(iteration).booleanValue()){
            driver.get(PAGE_URL);
            homePage.registrationSteps(userData);
            isUserCreated();
            homePage.waitsWhenLogout();
            iteration++;
        }
        driver.get(PAGE_URL);
        homePage.loginSteps(userData);
        homePage.clickItemsInCartButton();
        shoppingCart.clickCatalogueDropDownList();
        catalogue.changeTo_9_Products();
        assertThat(catalogue.getTextFromHowManyProductsAreVisible()).contains("Showing 9 of 9 products").as("Unexpected text");
        catalogue.addingAll_9_Products();
        homePage.clickItemsInCartButton();
        assertThat(shoppingCart.forAssertionForAll_9_ProductsAdded()).contains("Colourful", "Holy", "Figueroa", "SuperSport XL", "Crossed", "Cat socks", "YouTube.sock" , "Nerd leg", "Classic");

    }
    @Test
    @UseDataProvider("testDataForRegistration")
    public void changingQuantityAtOnceInAllProducts(UserData userData, Boolean setUserCreated2) {
        driver.get(PAGE_URL);
        iteration = 0;
        addingAllPossibleProducts(userData, setUserCreated2);
        String costBeforeChanginfQuantity = shoppingCart.costOfOrder();
        shoppingCart.changingQuantity();
        assertThat(shoppingCart.costOfOrder()).isNotEqualTo(costBeforeChanginfQuantity).as("The cart is not Updated");
    }
    @Test
    @UseDataProvider("testDataForRegistration")
    public void deleteAll_9_products(UserData userData, Boolean setUserCreated2) {
        driver.get(PAGE_URL);
        iteration = 0;
        addingAllPossibleProducts(userData, setUserCreated2);
        shoppingCart.deleteAllProductsFromBasket();
        assertThat(shoppingCart.numberOfItemsInCartBasket()).isEqualTo(0).as("There are still items in basket");
    }

}
