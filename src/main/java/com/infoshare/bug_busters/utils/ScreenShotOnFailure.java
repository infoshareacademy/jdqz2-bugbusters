package com.infoshare.bug_busters.utils;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class ScreenShotOnFailure extends TestWatcher {

    private static Logger logger = LoggerFactory.getLogger(ScreenShotOnFailure.class);

    private WebDriver driver;

    public ScreenShotOnFailure(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
        try {
            captureScreenShot(description.getMethodName());
        } catch (IOException e1) {
            logger.error(e1.getMessage());
        }
    }

    public void captureScreenShot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        fileName += LocalDate.now().toString();
       File targetFile = new File("Screenshot/" + fileName + ".png");
       FileUtils.copyFile(scrFile, targetFile);
   }
}
