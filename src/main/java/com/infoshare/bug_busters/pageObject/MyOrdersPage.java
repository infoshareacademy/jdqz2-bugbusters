package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage {

    @FindBy(xpath = "//h1[text()='My orders']")
    WebElement textFromHeadingMyOrders;

    private WebDriver driver;
    private Waits waits;

    public MyOrdersPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        // Remember to use this! If you use HomePage.class you will get memory leak!
        PageFactory.initElements(driver, this);
    }

    public String getTextFromHeadingMyOrders() {
        waits.waitForElementToBeVisible(textFromHeadingMyOrders);
        return textFromHeadingMyOrders.getText();
    }
}
