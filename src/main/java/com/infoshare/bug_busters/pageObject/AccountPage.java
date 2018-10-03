package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;
    private Waits waits;

    @FindBy(xpath = "//a[contains(text(),'Account')]")
    private WebElement labelAccount;
    @FindBy(xpath = "//h1[contains(text(),'My orders')]")
    private WebElement myOrdersLabel;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    private WebElement viewButtonInMyOrders;
    @FindBy(xpath = "//a[contains(text(),'Colourful')]")
    private WebElement colorFullLabelInMyOrders;

    public AccountPage(WebDriver driver) {
        waits = new Waits(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnLabelAccount() {
        labelAccount.click();
    }

    public String getTextFromColorFulLabelInMyOrders() {
        waits.waitForElementToBeVisible(colorFullLabelInMyOrders);
        return colorFullLabelInMyOrders.getText(); }
}
