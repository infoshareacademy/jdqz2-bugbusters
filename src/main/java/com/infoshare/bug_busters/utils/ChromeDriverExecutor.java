package com.infoshare.bug_busters.utils;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ChromeDriverExecutor extends DriverExecutor {

    private static final String CHROME_WINDOWS_PATH = "src/main/resources/drivers/chrome/chromedriver.exe";
    private static final String CHROME_MACOS_PATH = "src/main/resources/drivers/chrome/chromedriverMac";
    private static final String CHROME_LINUX_64_PATH = "src/main/resources/drivers/chrome/chromedriver_Linux64";
    private static final String CHROME_JENKINS_URL_PATH = "http://chrome:4444/wd/hub/";

    private static Logger logger = LoggerFactory.getLogger(ChromeDriverExecutor.class);

    static String getProperDriverExecutable() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (SystemUtils.IS_OS_MAC) {
            System.out.println("Mac OS X detected, assigning proper executable.");
            return CHROME_MACOS_PATH;
        } else if (SystemUtils.IS_OS_WINDOWS) {
            System.out.println("Windows detected, assigning proper executable.");
            return CHROME_WINDOWS_PATH;
        } else if (osName.contains("linux")) {
            if (System.getenv("JENKINS_HOME") != null){
                logger.info("Jenkins detected, assigning proper executable.");
                return CHROME_JENKINS_URL_PATH;
            }
            setFullPermissionsForDriver(CHROME_LINUX_64_PATH);
            return CHROME_LINUX_64_PATH;
        }
        return null;
    }

}