package com.code.demoblaze.tests;

import com.code.demoblaze.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void verifyLoginWithCorrectCredentials () {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver =new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.clickOnLoginLink();
        loginPage.setUserName("test");
        loginPage.setPassword("test");
        loginPage.clickOnLogin();


    }
}
