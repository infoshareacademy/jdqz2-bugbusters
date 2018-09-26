package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ColorfulPage {

    //w sumie na razie klasa nie potrzebna bo:
    // przycisk add to cart jest w klasie HollyPage
    // metoda kliknij przycisk add to cart tez jest w klasie HollyPage
    // metoda pobierajaca text z przycisku item(s) in cart jest w klasie HomePage

    private WebDriver driver;
    private Waits waits;

    public ColorfulPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        // Remember to use this! If you use HomePage.class you will get memory leak!
        PageFactory.initElements(driver, this);
    }


}
