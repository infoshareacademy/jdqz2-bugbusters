package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(DataProviderRunner.class)
public class RegistrationAndLoginWithDDT_Test {

    private WebDriver driver;

    private HomePage homePage;

    private static UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

    @DataProvider
    public static Object[][] testDataForRegistration() throws IOException {
        return new UserData[][] {
                new UserData[] { userDataGenerator.prepareUserData() },
        };
    }
    @DataProvider
    public static Object[][] testDataForRegistrationTwiceWithTheSameData() throws IOException {
        return new UserData[][] {
                new UserData[] { userDataGenerator.prepareUserData() },
        };
    }
    @DataProvider
    public static Object[][] testDataForLoginAfterRegistration() throws IOException {
        return new UserData[][] {
                new UserData[] { userDataGenerator.prepareUserData() },
        };
    }

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        driver.get("http://localhost:4180/");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    @UseDataProvider("testDataForRegistration")
    public void registrationWithUserDataGeneratorMethodTest(UserData userData) {
        homePage.registerUserWithDataGeneratorMethodWithDDT(userData);
        assertThat(homePage.getTextFromLogoutToConfirmLoginOrRegistration().contains("Logout")).as("User is not Registered");
    }

    @Test
    @UseDataProvider("testDataForRegistrationTwiceWithTheSameData")
    public void registrationTwiceWithTheSameData(UserData userData) {
        homePage.registerUserTwiceWithTheSameDataWithDDT(userData);
        assertThat(homePage.alertRegistration().contains("There was a problem with your registration: Internal Server Error")).as("Alert is not show after creating two indentical accounts");
    }

    @Test
    @UseDataProvider("testDataForLoginAfterRegistration")
    public void loginAfterRegistration(UserData userData) {
        homePage.loginUserAfterRegistrationWithDDT(userData);
        assertThat(homePage.getTextFromLogoutToConfirmLoginOrRegistration().contains("Logout")).as("User is not Logged");
    }

}