package com.infoshare.bug_busters.utils;

import org.openqa.selenium.By;
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
    private static final int PULLING_TIMEOUT_IN_SEC = 3;
    private static final int DEFAULT_TIMEOUT_IN_SEC = 15;



    private WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToNotBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeSOMETHING(By by) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElement(by, "1 item(s) in cart"));
    }

}
