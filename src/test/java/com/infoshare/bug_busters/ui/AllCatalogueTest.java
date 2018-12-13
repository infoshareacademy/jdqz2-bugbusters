package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.CataloguePage;
import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.pageObject.ProductPage;
import com.infoshare.bug_busters.utils.URLProvider;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AllCatalogueTest {
    private WebDriver driver;
    private HomePage homePage;
    private CataloguePage cataloguePage;
    private ProductPage productPage;
    private URLProvider urlProvider;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        homePage = new HomePage(driver);
        cataloguePage = new CataloguePage(driver);
        productPage = new ProductPage(driver);
        urlProvider = new URLProvider(driver);
        homePage.chooseCatalogue();
    }
    @Test
    public void addingProductTooCart() {
        cataloguePage.chooseProducts();
        productPage.addingProduct();
        assertThat(productPage.getTextFromButtonNumberOfElementsInCart().contains("1 item(s) in cart"));
    }
    @Test
    public void checkThreePageProduckt() {
        cataloguePage.checkingThreeElementsOnCatalogue();
        assertThat(cataloguePage.showingThreeOfNineGetText().contains("Showing 3 of 9 products"));
    }
    @Test
    public void checkSixPageProduckt() {
        cataloguePage.checkingSixElementsOnCatalogue();
        assertThat(cataloguePage.showingSixOfNineGetText().contains("Showing 6 of 9 products"));
    }
    @Test
    public void checkNinePageProduckt() {
        cataloguePage.checkingNineElementsOnCatalogue();
        assertThat(cataloguePage.showingNineOfNineGetText().contains("Showing 9 of 9 products"));
    }
    @Test
    public void checkProducktUsingScroll() {
        cataloguePage.chooseProducts();
        productPage.checkProductsDetails();
        assertThat(productPage.getTextFromElementProductDetalis().contains("Product details"));
    }
    @Test
    public void checkViewDetailButton() {
        cataloguePage.seeDetailsByUsingViewDetail();
        assertThat(productPage.getTextFromElementProductDetalis().contains("Product details"));
    }
    @After
    public void tearDown() {
        driver.close();
    }
}

