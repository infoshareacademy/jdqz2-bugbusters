package com.infoshare.bug_busters.ui.Catalogue;

import com.infoshare.bug_busters.pageObject.CatalogueHomePage;
import com.infoshare.bug_busters.pageObject.CataloguePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class PagingSixProductsTest {
    private WebDriver driver;
    private CatalogueHomePage catalogueHomePage;
    private CataloguePage cataloguePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver_Linux64");
        driver = new ChromeDriver();
        catalogueHomePage = new CatalogueHomePage(driver);
        cataloguePage = new CataloguePage(driver);
    }

    @Test
    public void checkSixPageProduckt() {
        driver.get("http://localhost/index.html/");
        //driver.get("http://localhost:4180/");
        catalogueHomePage.chooseCatalogue();
        cataloguePage.checkingSixElementsOnCatalogue();
        assertThat(cataloguePage.showingSixOfNineGetText().contains("Showing 6 of 9 products"));
    }

    @After
    public void tearDown() {
        driver.close();
    }

}


