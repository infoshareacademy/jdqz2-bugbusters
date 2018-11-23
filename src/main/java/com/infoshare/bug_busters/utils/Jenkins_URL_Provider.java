package com.infoshare.bug_busters.utils;

import org.openqa.selenium.WebDriver;

public class Jenkins_URL_Provider {
    public Jenkins_URL_Provider(WebDriver driver) {
        if (System.getenv("JENKINS_HOME") != null){
            driver.get("http://socks:80/");
        }
        else{
            driver.manage().window().maximize();
            driver.get("http://localhost:4180/");
        }
    }
}
