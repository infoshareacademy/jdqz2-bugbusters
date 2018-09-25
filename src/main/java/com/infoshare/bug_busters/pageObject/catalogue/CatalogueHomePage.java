package com.infoshare.bug_busters.pageObject.catalogue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class CatalogueHomePage {
    private WebDriver driver;
    private WebDriverWait waits;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement labelCatalogue;
    @FindBy(xpath = "//img[@class='hidden-xs']")
    private WebElement logoElement;




    public CatalogueHomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void chooseCatalogue(){
        logoElement.isDisplayed();
        labelCatalogue.click();
    }


}
