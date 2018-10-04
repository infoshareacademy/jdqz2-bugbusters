package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CataloguePage {

    @FindBy(xpath = "//ul[@class='breadcrumb']//li[text()='Catalogue']")
    private WebElement catalogueTextOnPageCatalogue;

    @FindBy(xpath = "//input[@value='blue']")
    private WebElement blueCheckboxInFiltersFromCatalogue;

    @FindBy(xpath = "//input[@value='brown']")
    private WebElement brownCheckboxInFiltersFromCatalogue;

    @FindBy(xpath = "//input[@value='green']")
    private WebElement greenCheckboxInFiltersFromCatalogue;

    @FindBy(xpath = "//input[@value='magic']")
    private WebElement magicCheckboxInFiltersFromCatalogue;

    @FindBy(xpath = "//input[@value='formal']")
    private WebElement formalCheckboxInFiltersFromCatalogue;

    @FindBy(xpath = "//input[@value='sport']")
    private WebElement sportCheckboxInFiltersFromCatalogue;

    @FindBy(xpath = "//input[@value='action']")
    private WebElement actionCheckboxInFiltersFromCatalogue;

    private WebDriver driver;
    private Waits waits;

    public CataloguePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        // Remember to use this! If you use HomePage.class you will get memory leak!
        PageFactory.initElements(driver, this);
    }

    public String getTextFromCataloguePage(){
        waits.waitForElementToBeVisible(catalogueTextOnPageCatalogue);
        return catalogueTextOnPageCatalogue.getText();
    }

    public boolean checkIfBlueCheckboxIsChecked(){
        waits.waitForElementToBeVisible(blueCheckboxInFiltersFromCatalogue);
        return blueCheckboxInFiltersFromCatalogue.isSelected();
    }

    public boolean checkIfBrownCheckboxIsChecked(){
        waits.waitForElementToBeVisible(brownCheckboxInFiltersFromCatalogue);
        return brownCheckboxInFiltersFromCatalogue.isSelected();
    }

    public boolean checkIfGreenCheckboxIsChecked(){
        waits.waitForElementToBeVisible(greenCheckboxInFiltersFromCatalogue);
        return greenCheckboxInFiltersFromCatalogue.isSelected();
    }

    public boolean checkIfMagicCheckboxIsChecked(){
        waits.waitForElementToBeVisible(magicCheckboxInFiltersFromCatalogue);
        return magicCheckboxInFiltersFromCatalogue.isSelected();
    }

    public boolean checkIfFormalCheckboxIsChecked(){
        waits.waitForElementToBeVisible(formalCheckboxInFiltersFromCatalogue);
        return formalCheckboxInFiltersFromCatalogue.isSelected();
    }

    public boolean checkIfSportCheckboxIsChecked(){
        waits.waitForElementToBeVisible(sportCheckboxInFiltersFromCatalogue);
        return sportCheckboxInFiltersFromCatalogue.isSelected();
    }

    public boolean checkIfActionCheckboxIsChecked(){
        waits.waitForElementToBeVisible(actionCheckboxInFiltersFromCatalogue);
        return actionCheckboxInFiltersFromCatalogue.isSelected();
    }


}
