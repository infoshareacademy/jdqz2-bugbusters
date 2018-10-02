package com.infoshare.bug_busters.ui.Catalogue;

import com.infoshare.bug_busters.pageObject.catalogue.CatalogueHomePage;
import com.infoshare.bug_busters.pageObject.catalogue.CataloguePage;
import com.infoshare.bug_busters.pageObject.catalogue.ProductPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;

public class FiltersTest {
    private WebDriver driver;
    private WebDriverWait waits;
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
    public void checkFilters() {
        choosingFormalButton();
        assertTrue("Formal is not checked",cataloguePage.filterFormalIsSelected());

    }

    private void choosingFormalButton() {
        //driver.get("http://localhost/index.html/");
        driver.get("http://localhost:4180/");
        catalogueHomePage.chooseCatalogue();
        cataloguePage.checkFiltersFormal();
    }

    @Test
    public void checkClearOption(){
        choosingFormalButton();
        cataloguePage.checkButtonClear();
        assertTrue("Formal is checked",cataloguePage.filterFormalIsNotChecked());

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
