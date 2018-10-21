package com.infoshare.bug_busters.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private static final int EXPLICIT_WAIT_TIMEOUT = 10;

    private WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeSOMETHING(By by) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElement(by, "1 item(s) in cart"));
    }

    public void waitForTextInElementToBePresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElement(by, "1 item(s) in cart"));
    }

    public void waitForElementToBeRefreshed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
        WebElement waitForElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

}


