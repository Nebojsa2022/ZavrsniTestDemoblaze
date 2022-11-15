package com.code.demoblaze.tests;

import com.code.demoblaze.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void verifyLoginWithCorrectCredentials () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.clickOnLoginBtn();
        loginPage.setUserName("test");
        loginPage.setPassword("test");
        loginPage.clickOnLogin();


    }
}
