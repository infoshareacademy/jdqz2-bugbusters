package com.infoshare.bug_busters.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.Timestamp;

public class ScreenShotTaker {

    public static void screenShotTest(WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            FileUtils.copyFile(scrFile, new File("Screenshot/" + timestamp.toString() + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



