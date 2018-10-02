package com.infoshare.bug_busters.ui.Catalogue;

import com.infoshare.bug_busters.pageObject.catalogue.CatalogueHomePage;
import com.infoshare.bug_busters.pageObject.catalogue.CataloguePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PagingThreeProductsTest {

    private WebDriver driver;
    private WebDriverWait waits;
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
    public void checkThreePageProduckt() {
        //driver.get("http://localhost/index.html/");
        driver.get("http://localhost:4180/");
        catalogueHomePage.chooseCatalogue();
        cataloguePage.checkingThreeElementsOnCatalogue();

        assertThat("Showing 3 of 9 products is not selected", cataloguePage.showingThreeOfNineGetText().contains("Showing 3 of 9 products"));

    }

    @After
    public void tearDown() {
        driver.close();
    }

}

