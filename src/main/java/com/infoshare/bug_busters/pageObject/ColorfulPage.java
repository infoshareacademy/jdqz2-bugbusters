package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ColorfulPage {

    //w sumie na razie klasa nie potrzebna bo:
    // przycisk add to cart jest w klasie HollyPage
    // metoda kliknij przycisk add to cart tez jest w klasie HollyPage
    // metoda pobierajaca text z przycisku item(s) in cart jest w klasie HomePage
    // czy powinno powielac sie metody ktore sa w paru klasach ???
    // jednak sie przyda bo sprawdzam czy po kliknieciu mnie w obrazek na glownym sliderze przeniesie an stronie produktu Colorful

    //necessary for slider test
    @FindBy(xpath = "//h1[@id='title']")
    private WebElement textColorfulOnProductSite;


    private WebDriver driver;
    private Waits waits;

    public ColorfulPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        // Remember to use this! If you use HomePage.class you will get memory leak!
        PageFactory.initElements(driver, this);
    }

    public String getTextConfirmationOfColorfulPage(){
        waits.waitForElementToBeVisible(textColorfulOnProductSite);
        return textColorfulOnProductSite.getText();
    }


}
