package com.infoshare.bug_busters.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {



    private WebDriver driver;
    private WebDriverWait waits;

    @FindBy(xpath = "///a[contains(text(),'Account')]")
    private WebElement labelAccount;
    @FindBy(xpath ="//h1[contains(text(),'My orders')]")
    private WebElement myOrdersLabel;
    @FindBy(xpath ="//span[@id='numItemsInCart']")
    private WebElement itemsInCartButton;




    public AccountPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }






}
