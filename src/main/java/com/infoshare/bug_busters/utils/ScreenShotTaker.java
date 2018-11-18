package com.infoshare.bug_busters.utils;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.Timestamp;

public class ScreenShotTaker extends TestWatcher {

    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
        description.getMethodName();
        screenShotTest(driver);
    }

    @Override
    protected void finished(Description description) {
        if(driver != null)
            driver.close();
    }


    private void screenShotTest(WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            FileUtils.copyFile(scrFile, new File("Screenshot/" + timestamp.toString() + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



