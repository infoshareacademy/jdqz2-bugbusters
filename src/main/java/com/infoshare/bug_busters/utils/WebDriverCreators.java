package com.infoshare.bug_busters.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverCreators {

    public static final WebDriverCreator FIREFOX_GECKO = () -> {
        startGeckoDriverServer();
        return (WebDriver) new FirefoxDriver();
    };

    public static final WebDriverCreator CHROME = () -> {
        if (System.getenv("JENKINS_HOME") != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            try {
                return (WebDriver) new RemoteWebDriver(new URL(ChromeDriverExecutor.getProperDriverExecutable()), capabilities);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
        }
            startChromeDriverServer();
            return (WebDriver) new ChromeDriver();
    };

    private static void startGeckoDriverServer() {
        System.setProperty("webdriver.firefox.marionette", Objects.requireNonNull(GeckoDriverExecutor.getProperDriverExecutable()));
    }

    private static void startChromeDriverServer() {
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(ChromeDriverExecutor.getProperDriverExecutable()));
    }

}

