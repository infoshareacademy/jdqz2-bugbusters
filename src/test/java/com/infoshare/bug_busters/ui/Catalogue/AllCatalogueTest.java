package com.infoshare.bug_busters.ui.Catalogue;

import com.infoshare.bug_busters.pageObject.CatalogueHomePage;
import com.infoshare.bug_busters.pageObject.CataloguePage;
import com.infoshare.bug_busters.pageObject.ProductPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AllCatalogueTest {
    private WebDriver driver;
    private CatalogueHomePage catalogueHomePage;
    private CataloguePage cataloguePage;
    private ProductPage productPage;
    private final String URL=("http://localhost:4180/");
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver_Linux64");
        driver = new ChromeDriver();
        catalogueHomePage = new CatalogueHomePage(driver);
        cataloguePage = new CataloguePage(driver);
        productPage = new ProductPage(driver);
        driver.get(URL);
    }
    @Test
    public void addingProductTooCart() {
        catalogueHomePage.chooseCatalogue();
        cataloguePage.chooseProducts();
        productPage.addingProduct();
        assertThat(productPage.getTextFromButtonNumberOfElementsInCart().contains("1 item(s) in cart"));
    }
    @Test
    public void checkThreePageProduckt() {
        catalogueHomePage.chooseCatalogue();
        cataloguePage.checkingThreeElementsOnCatalogue();
        assertThat(cataloguePage.showingThreeOfNineGetText().contains("Showing 3 of 9 products"));
    }
    @Test
    public void checkSixPageProduckt() {
        catalogueHomePage.chooseCatalogue();
        cataloguePage.checkingSixElementsOnCatalogue();
        assertThat(cataloguePage.showingSixOfNineGetText().contains("Showing 6 of 9 products"));
    }
    @Test
    public void checkNinePageProduckt() {
        catalogueHomePage.chooseCatalogue();
        cataloguePage.checkingNineElementsOnCatalogue();
        assertThat(cataloguePage.showingNineOfNineGetText().contains("Showing 9 of 9 products"));
    }
    @Test
    public void checkProducktUsingScroll() {
        catalogueHomePage.chooseCatalogue();
        cataloguePage.chooseProducts();
        productPage.checkProductsDetails();
        assertThat(productPage.getTextFromElementProductDetalis().contains("Product details"));
    }
    @Test
    public void checkViewDetailButton() {
        catalogueHomePage.chooseCatalogue();
        cataloguePage.seeDetailsByUsingViewDetail();
        assertThat(productPage.getTextFromElementProductDetalis().contains("Product details"));
    }
    @After
    public void tearDown() {
        driver.close();
    }
}

