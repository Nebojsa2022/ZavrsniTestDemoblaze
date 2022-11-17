package com.code.demoblaze.tests;

import com.code.demoblaze.pages.LoginPage;
import com.code.demoblaze.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.StringWriter;

import static org.testng.Assert.assertEquals;

public class LoginTests {

    @Test
    public void verifyLogin(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver =new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.clickOnLoginLink();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginPage.setUserName("test");
        loginPage.setPassword("test");
        loginPage.clickOnLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement getLogout = driver.findElement(By.id("logout2"));
        Assert.assertEquals(true, getLogout.isDisplayed());
        System.out.println("login successful");


    }

    }



