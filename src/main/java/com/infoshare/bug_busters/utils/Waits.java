package com.infoshare.bug_busters.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Waits {

    private static final int EXPLICIT_WAIT_TIMEOUT = 10;
    private static final int PULLING_TIMEOUT_IN_SEC = 2;
    private static final int DEFAULT_TIMEOUT_IN_SEC = 8;



    private WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        WebElement waitForElement = wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        WebElement waitForElement = wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementUntilCorrectTextShowUp(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        boolean waitForElement = wait.until(ExpectedConditions.textToBePresentInElement(element, "1 item(s) in cart"));
    }

    public void waitForItemsInCartToBeChanged(WebElement element){
        FluentWait wait = new FluentWait(driver).withTimeout(DEFAULT_TIMEOUT_IN_SEC, TimeUnit.SECONDS)
                .pollingEvery(PULLING_TIMEOUT_IN_SEC, TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class);
        wait.until((ExpectedCondition) driver -> (element.getText().equals("1 item(s) in cart")));
    }

}
