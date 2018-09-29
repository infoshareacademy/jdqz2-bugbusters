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
import static org.hamcrest.MatcherAssert.assertThat;

public class CataloguePage {

    private WebDriver driver;
    private Waits waits;

    @FindBy(xpath = "//ul[@class='breadcrumb']")
    private WebElement confirmCatalogue;
    @FindBy(xpath = "//div[@id='products-number']")
    private WebElement labelShow;
    @FindBy(xpath = "//a[contains(text(),'3')]")
    private WebElement product3;
    @FindBy(xpath = "//div[@id='totalProducts']")
    private WebElement showingThreeOfNine;
    @FindBy(xpath = "//a[contains(text(),'6')]")
    private WebElement product6;
    @FindBy(xpath = "//div[@id='totalProducts']")
    private WebElement showingSixOfNine;
    @FindBy(xpath = "//a[contains(text(),'9')]")
    private WebElement product9;
    @FindBy(xpath = "//div[@id='totalProducts']")
    private WebElement showingNineOfNine;
    @FindBy(xpath = "//a[contains(text(),'Holy')]")
    private WebElement choosingHolyProducts;
    @FindBy(xpath = "//a[@id='buttonCart']")
    WebElement buttonAddToCart;
    @FindBy(xpath = "//a[@class='btn btn-default']")
    WebElement buttonViewDetailHolly;
    @FindBy(xpath = "//input[@value='formal']")
    WebElement inputFormal;
    @FindBy(xpath = "//a[@class='btn btn-default btn-sm btn-primary']")
    WebElement buttonAplly;
    @FindBy(xpath = "//a[@class='btn btn-xs btn-danger pull-right']")
    WebElement buttonClear;


    public CataloguePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);

    }

    public void CheckingThreeElementsOnCatalogue() {

        showElements(product3);


    }




    public void CheckingSixElementsOnCatalogue() {

        showElements(product6);


        assertThat("Showing 6 of 9 products is not selected", showingSixOfNine.getText().contains("Showing 6 of 9 products"));
    }

    public void CheckingNineElementsOnCatalogue() {

        showElements(product9);


        assertThat("Showing 9 of 9 products is not selected", showingThreeOfNine.getText().contains("Showing 9 of 9 products"));
    }


    public void ChooseProducts() {
        choosingHolyProducts.click();


    }


    public void SeeDetailsByUsingViewDetail() {

        confirmCatalogue.isDisplayed();
        waits.waitForElementToBeVisible(buttonViewDetailHolly);
        buttonViewDetailHolly.click();
    }

    public void CheckFilters() {
        confirmCatalogue.isDisplayed();
        waits.waitForElementToBeVisible(inputFormal);
        inputFormal.click();
        buttonAplly.click();
        buttonClear.click();
    }
    public String showingThreeOfNineGetText(){
        return showingThreeOfNine.getText();

    }


    private void showElements(WebElement product3) {
        confirmCatalogue.isDisplayed();
        waits.waitForElementToBeVisible(labelShow);
        labelShow.click();
        waits.waitForElementToBeVisible(product3);
        product3.click();
    }


}




