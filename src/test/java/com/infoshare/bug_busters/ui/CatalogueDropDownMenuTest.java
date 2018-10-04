package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.CataloguePage;
import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CatalogueDropDownMenuTest {

    private WebDriver driver;
    private HomePage homePage;
    private CataloguePage cataloguePage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        cataloguePage = new CataloguePage(driver);

        driver.get("http://localhost:4180/");
    }

    @Test
    public void selectBlueFromCatalogue(){
        homePage.selectBlueFromDropDownMenuCatalogue();
        assertTrue("Blue checkbox in Catalogue is not checked", cataloguePage.checkIfBlueCheckboxIsChecked());
    }

    @Test
    public void selectBrownFromCatalogue(){
        homePage.selectBrownFromDropDownMenuCatalogue();
        assertTrue("Brown checkbox in Catalogue is not checked", cataloguePage.checkIfBrownCheckboxIsChecked());
    }

    @Test
    public void selectGreenFromCatalogue(){
        homePage.selectGreenFromDropDownMenuCatalogue();
        assertTrue("Green checkbox in Catalogue is not checked", cataloguePage.checkIfGreenCheckboxIsChecked());
    }

    @Test
    public void selectMagicFromCatalogue(){
        homePage.selectMagicFromDropDownMenuCatalogue();
        assertTrue("Magic checkbox in Catalogue is not checked", cataloguePage.checkIfMagicCheckboxIsChecked());
    }

    @Test
    public void selectFormalFromCatalogue(){
        homePage.selectFormalFromDropDownMenuCatalogue();
        assertTrue("Formal checkbox in Catalogue is not checked", cataloguePage.checkIfFormalCheckboxIsChecked());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
