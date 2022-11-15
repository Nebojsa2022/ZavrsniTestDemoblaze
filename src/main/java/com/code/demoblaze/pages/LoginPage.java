package com.code.demoblaze.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void openPage () {
        this.driver.get("https://www.demoblaze.com/");
        this.driver.manage().window().maximize();
    }

    public WebElement getLoginBtn () {
        return driver.findElement(By.xpath("//a[@id='login2']"));
    }


    public WebElement getInpUserName () {
        return driver.findElement(By.xpath(".//input[@id='loginusername']"));
    }
    public WebElement getInpPassword () {
        return driver.findElement(By.xpath(".//input[@id='loginpassword']"));
    }
    public WebElement getBtnLogin() {
        return driver.findElement(By.xpath("//input[@oneclick='logIn()']"));
    }

    public void clickOnLoginBtn() {
        this.getLoginBtn().click();
    }

    public void setUserName(String userName) {
        this.getInpUserName().sendKeys(userName);
    }

    public void setPassword(String password) {
        this.getInpPassword().sendKeys(password);
    }
    public void clickOnLogin() {
        this.getBtnLogin().click();

    }



}
