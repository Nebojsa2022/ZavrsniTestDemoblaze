package com.code.demoblaze.pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    public WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openPage() {
        this.driver.get("https://www.demoblaze.com/");
        this.driver.manage().window().maximize();
    }
    public WebElement getHomebtn(){
        return this.driver.findElement(By.xpath("//a[@class='nav-link']"));
    }
    public WebElement getItemPage  () {

        return this.driver.findElement(By.xpath("//a[@class='hrefch']"));
    }
    public WebElement getAddToCart () {
        return this.driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
    }

    public WebElement getCart(){
        return this.driver.findElement(By.xpath("//a[@class='nav-link']"));
    }

    public WebElement getInventoryList() {
        return this.driver.findElement(By.id("tbodyid"));
    }


   public List<WebElement> getListInventoryItems(){
        return this.getInventoryList().findElements(By.xpath("//a[@class='hrefch']"));
    }


    int brojac=0;
    public int addToCart() {
        getHomebtn().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> webElementList = new ArrayList<>();
        webElementList = this.getListInventoryItems();

        WebElement item = webElementList.get(brojac);

        item.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getAddToCart().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();

        clickOnHomeBtn();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return ++brojac;
         }


    public int cartItemNo(){

        WebElement cartLink = this.driver.findElement(By.id("cartur"));
        cartLink.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int rowCount = this.driver.findElements(By.xpath("//tr[@class='success']")).size();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(rowCount);
        return  rowCount;
    }


    //Kad se vrati na prethodnu stranicu DOM se ucita ponovo i for petlja ne vidi linkove na koje treba da klikne
   /* public List<Product> getListProducts() {
        List<Product> toReturn = new ArrayList<>();
        List<WebElement> webElementList = new ArrayList<>();
        webElementList = this.getListInventoryItems();



       //  for(int i = 0; i < webElementList.size(); i++) {



            //System.out.println( webElementList.get(i).getText());

            WebElement item = webElementList.get(0);

            item.click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            getAddToCart().click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.switchTo().alert().accept();

            clickOnHomeBtn();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

/*
            WebElement itemName = item.findElement(By.xpath(".//a[@class='hrefch']"));
            String name = itemName.getText();
            Product product = new Product(name);
            toReturn.add(product);

*/
                //nema webelement za cenu (ja nisam nasao u @class='card-title')
            //WebElement itemPrice = item.findElement(By.xpath(".//[@'']"));
           // String price = itemPrice.getText();
            //String tmpPrice = price.substring(1);
            //Product product = new Product(name, Double.parseDouble(price));
            //toReturn.add(product);




       // return toReturn;
    // }


    public void clickOnHomeBtn (){
        this.getHomebtn().click();
    }
    public void clickOnItemPage (){
        this.getItemPage().click();
    }
    public void clickOnAddToCart(){
        this.getAddToCart().click();
    }
    public void clickOnCart() {
        this.getCart().click();
    }






    public void addItemToCartByName(String name) {
        List<WebElement> webElementList = new ArrayList<>();
        webElementList = this.getListInventoryItems();

        int index = 0;
        for(int i = 0; i < webElementList.size(); i++) {

            WebElement webElementItemName = webElementList.get(i);
            System.out.println(i);
            System.out.println(webElementItemName.getText());

            String itemName = webElementItemName.getText();



            if(itemName.equals(name)) {
                index = i;
                System.out.println(index);
                System.out.println(itemName);

                WebElement item = webElementList.get(index);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                item.click();
                break;

            }

        }



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getAddToCart().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnHomeBtn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


     /* public void addItemToCartByName(List<String> listItemName) {


        List<WebElement> webElementList = new ArrayList<>();
        webElementList = this.getListInventoryItems();

        int index = 0;

        for(int j = 0; j < listItemName.size(); j++) {


            for (int i = 0; i < webElementList.size(); i++) {
             WebElement webElementItemName = webElementList.get(i);
                String itemName = webElementItemName.getText();



                if (itemName.equals(listItemName.get(j))) {
                    index = i;
                     WebElement item = webElementList.get(index);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                item.click();
                    break;
                }

                WebElement item = webElementList.get(i);
                item.click();
                getAddToCart().click();
                driver.switchTo().alert().accept();
                clickOnHomeBtn();
                break;
            }

        }
          try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getAddToCart().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnHomeBtn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
     } */

    }






