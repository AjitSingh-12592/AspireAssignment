package com.aspireapp.www.TestCases;

import PageObject.*;
import com.aspireapp.www.Resources.Initializations;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class Assignment extends Initializations {

    @BeforeSuite
    public void initialize() throws IOException {
        driver = InitializeDriver();
    }

    @Test(priority = 1)
    public void loginApp() throws InterruptedException {

        wait = getExplicitWait();

        // Getting  data from .properties file : from parent class:
        String username = data.getProperty("username");
        String password = data.getProperty("password");
        String AppUrl = data.getProperty("url");

        LoginPage lp = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get(AppUrl);

        while (!driver.getCurrentUrl().equals("https://aspireapp.odoo.com/web/login")) {
            System.out.println("Waiting for login page to load...");
        }
        System.out.println("Url " + AppUrl + " opened successfully");
        lp.getEmailFld().sendKeys(username);
        System.out.println("Providiing username as: " + username);
        lp.getPasswordFld().sendKeys(password);
        System.out.println("Providiing password as: " + password);
        lp.getSubmitBtn().click();
        System.out.println("Clicked on Log in Button");
        while (!driver.getCurrentUrl().equals("https://aspireapp.odoo.com/web#cids=1&action=menu")) {
            System.out.println("Waiting for menu page to load...");
        }
        System.out.println("User logged in successfully -> Navigated to Menu page.");

    }

    @Test(priority = 2)
    public void selectInventory() throws InterruptedException {
        MenuPage mp = new MenuPage(driver);
        InventoryPage ip = new InventoryPage(driver);
        mp.selectMenuOption("Inventory").click();
        System.out.println("Clicked on inventory page.");
        wait.until(ExpectedConditions.visibilityOf(ip.getInventoryHeader()));
        System.out.println("Navigated to inventory page successfully.");
    }

    @Test(priority = 3)
    public void createProduct() throws InterruptedException {

        InventoryPage ip = new InventoryPage(driver);
        ProductPage pp = new ProductPage(driver);
        MenuPage mp = new MenuPage(driver);

        String productName = data.getProperty("productName");
        String productQuantity = data.getProperty("productQuantity");

        ip.getProductsDropdown().click();
        System.out.println("Clicked on Products tab.");

        wait.until(ExpectedConditions.visibilityOf(ip.getProductsBtn()));
        System.out.println("Products dropdown list displayed successfully");
        ip.getProductsBtn().click();
        System.out.println("Clicked on Product button from Products dropdown");

        wait.until(ExpectedConditions.visibilityOf(ip.getCreateButton()));
        System.out.println("Products page is loaded successfully.");
        ip.getCreateButton().click();
        System.out.println("Clicked on Create Products button.");

        wait.until(ExpectedConditions.visibilityOf(ip.getSaveProductButton()));
        System.out.println("Create product page is loaded successfully.");

        // create new product
        pp.getProductNameField().sendKeys(productName);
        System.out.println("Create new product with name: '" + productName + "'");
        pp.getSaveButton().click();
        System.out.println("Clicked on 'Save' button");
        wait.until(ExpectedConditions.visibilityOf(pp.getEditButton()));
        System.out.println("Product saved successfully.");
        pp.getUpdateQuantity().click();

        System.out.println("Clicked on 'UPDATE QUANTITY' button.");

        wait.until(ExpectedConditions.visibilityOf(pp.getLocationButton()));
        System.out.println("'Update Quantity' page loaded successfully.");

        pp.getCreateButton().click();
        System.out.println("Clicked on 'CREATE' button.");
        wait.until(ExpectedConditions.visibilityOf(pp.getCountedQuantity()));

        pp.getCountedQuantity().clear();
        pp.getCountedQuantity().sendKeys(productQuantity);
        System.out.println("Updated product's 'Counted Quantity' to :" + productQuantity);
        ip.getSaveProductButton().click();
        System.out.println("Clicked on 'SAVE' button successfully.");
        pp.getHomeButton().click();
        System.out.println("Clicked on Home Button successfully.");
        wait.until(ExpectedConditions.visibilityOf(mp.getBackButton()));
        System.out.println("Navigated to home page successfully.");
    }


    @Test(priority = 3)
    public void selectManufacturing() throws InterruptedException {
        MenuPage hp = new MenuPage(driver);
        ManufacturingPage mp = new ManufacturingPage(driver);


        hp.selectMenuOption("Manufacturing").click();
        System.out.println("Clicked on Manufacturing page.");
        wait.until(ExpectedConditions.visibilityOf(mp.getManufacturingHeader()));
        System.out.println("Navigated to Manufacturing page successfully.");

    }

    @Test(priority = 4)
    public void createManufacturingOrder() throws InterruptedException {

        ManufacturingPage mp = new ManufacturingPage(driver);
        String productName = data.getProperty("productName");
        String ManufactureQuantity = data.getProperty("ManufactureQuantity");
        String unitOfMeasurement = data.getProperty("unitOfMeasurement");
        String statusValidate = data.getProperty("statusValidate");

        mp.getCreateButton().click();
        System.out.println("Clicked on 'CREATE' button.");

        wait.until(ExpectedConditions.visibilityOf(mp.getSelectProductName()));
        System.out.println("Navigated to 'Create New Manufacturing Orders' page successfully.");
        System.out.println("Current order status is : '" + mp.getCurrentState().getText() + "'");
        mp.getSelectProductName().sendKeys(productName);
        System.out.println("Entered product name as : '" + productName + "'");
        mp.getSaveButton().click();
        System.out.println("Clicked on 'Save' Button");
        wait.until(ExpectedConditions.visibilityOf(mp.getPopUpCreateButton()));
        mp.getPopUpCreateButton().click();
        System.out.println("Pop-up Appeared. Clicked on 'Create' Button");
        wait.until(ExpectedConditions.elementToBeClickable(mp.getSaveButton()));
        mp.getSaveButton().click();
        System.out.println("Clicked on 'Save' Button");
        Thread.sleep(3000);
        mp.getConfirmButton().click();
        System.out.println("Clicked on 'Confirm' Button");
        Thread.sleep(3000);
        System.out.println("Order status has been updated to : '" + mp.getCurrentState().getText() + "'");
        mp.getProductQuantityField().click();
        mp.getProductQuantityInputField().clear();
        mp.getProductQuantityInputField().sendKeys(ManufactureQuantity);
        System.out.println("Selected product Quantity to: " + ManufactureQuantity);
        mp.getSaveButton().click();
        System.out.println("Clicked on 'Save' Button");
        Thread.sleep(3000);
        System.out.println("Order status has been updated to : '" + mp.getCurrentState().getText() + "'");
        Thread.sleep(3000);
        mp.getAddComponentsButton().click();
//        Thread.sleep(3000);
//        wait.until(ExpectedConditions.elementToBeClickable(mp.getComponentsSelectProducts()));
        mp.getComponentsSelectProducts().clear();
        mp.getComponentsSelectProducts().sendKeys(productName);
        System.out.println("Selected product '" + productName + "' from Components section.");
        Thread.sleep(3000);
        mp.getSaveButton().click();
        System.out.println("Clicked on 'Save' Button");
        Thread.sleep(3000);
        mp.getUnitOfMeasurement().clear();
        mp.getUnitOfMeasurement().clear();
        mp.getUnitOfMeasurement().sendKeys(unitOfMeasurement);
        System.out.println("Selected product's unit of measurement as '" + unitOfMeasurement + "' from Components section.");
        mp.getComponentsQuantity().click();
        mp.getComponentsQuantity().clear();
        mp.getComponentsQuantity().sendKeys(ManufactureQuantity);
        System.out.println("Selected product's manufacture quantity as '" + ManufactureQuantity + "' from Components section.");
        mp.getSaveButton().click();
        System.out.println("Clicked on 'Save' Button");
        Thread.sleep(3000);
        mp.getMarkAsDoneButton().click();
        System.out.println("Clicked on 'Mark As Done' button");
        System.out.println("Order status has been updated to : '" + mp.getCurrentState().getText() + "'");
        Thread.sleep(3000);
        while(!mp.getCurrentState().getText().equals("DONE")){
            System.out.println("Waiting for status to get updated. Current status is: " + mp.getCurrentState().getText() +"'");
        }
        Assert.assertEquals(mp.getCurrentState().getText(), statusValidate);

    }

    @AfterSuite
    public void tearDown() throws IOException, InterruptedException {
//        driver.close();
        System.out.println("Browser closed successfully");
    }

}

