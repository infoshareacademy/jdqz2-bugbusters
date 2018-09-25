package com.infoshare.bug_busters.pageObject.catalogue;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

import static junit.framework.TestCase.assertTrue;

public class CataloguePage {

    private WebDriver driver;
    private Waits waits;

    @FindBy(xpath = "//ul[@class='breadcrumb']")
    private WebElement confirmCatalogue;
    @FindBy(xpath = "//div[@id='products-number']")
    private WebElement labelShow;
    @FindBy(xpath = "//a[@class='btn btn-default btn-sm' and text()='3']")
    private WebElement product3;
    @FindBy(xpath = "//div[@id='totalProducts']")
    private WebElement showingThreeOfNine;
    @FindBy(xpath = "//a[@class='btn btn-default btn-sm' and text()='6']")
    private WebElement product6;
    @FindBy(xpath = "//div[@id='totalProducts']")
    private WebElement showingSixOfNine;
    @FindBy (xpath = "//a[@class='btn btn-default btn-sm' and text()='9']")
    private WebElement product9;
    @FindBy(xpath ="//div[@id='totalProducts']" )
    private WebElement showingNineOfNine;



    public CataloguePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);

    }
    public void CheckingThreeElementsOnCatalogue(){

        confirmCatalogue.isDisplayed();
        waits.waitForElementToBeVisible(labelShow);
        labelShow.click();

        product3.click();

        assertTrue("Showing 3 of 9 products is not selected", showingThreeOfNine.isSelected());
    }
    public void CheckingSixElementsOnCatalogue() {

        confirmCatalogue.isDisplayed();
        labelShow.click();
        product6.click();

        assertTrue("Showing 6 of 9 products is not selected", showingSixOfNine.isSelected());
    }

    public void CheckingNineElementsOnCatalogue() {

        confirmCatalogue.isDisplayed();
        labelShow.click();
        product9.click();

        assertTrue("Showing 9 of 9 products is not selected", showingNineOfNine.isSelected());
    }





}




