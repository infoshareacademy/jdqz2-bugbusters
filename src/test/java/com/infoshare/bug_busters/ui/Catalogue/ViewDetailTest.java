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

public class ViewDetailTest {
    private WebDriver driver;
    private CatalogueHomePage catalogueHomePage;
    private CataloguePage cataloguePage;
    private ProductPage productPage;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver_Linux64");
        driver = new ChromeDriver();
        catalogueHomePage = new CatalogueHomePage(driver);
        cataloguePage = new CataloguePage(driver);
        productPage = new ProductPage(driver);
    }
    @Test
    public void checkViewDetailButton() {
        driver.get("http://localhost/index.html/");
        //driver.get("http://localhost:4180/");
        catalogueHomePage.chooseCatalogue();
        cataloguePage.seeDetailsByUsingViewDetail();
        assertThat(productPage.getTextFromElementProductDetalis().contains("Product details"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
