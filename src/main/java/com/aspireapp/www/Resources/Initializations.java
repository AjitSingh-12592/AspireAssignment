package com.aspireapp.www.Resources;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Initializations {
    public WebDriver driver;
    public Properties data;
    public WebDriverWait wait;
    public TakesScreenshot scrShot;

    public WebDriverWait getExplicitWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    public WebDriver InitializeDriver() throws IOException {

        scrShot =((TakesScreenshot)driver);

        data = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/aspireapp/www/Resources/data.properties");
        data.load(fis);
        String productName = "AjitSingh_"+DateTimeFormatter.ofPattern("yyyy/MM/dd_HH:mm:ss").format(java.time.LocalDateTime.now());
        System.out.println(productName);
        data.setProperty("productName", productName);
        FileOutputStream fos = new FileOutputStream("src/main/java/com/aspireapp/www/Resources/data.properties");
        data.store(fos, "updated data file, with unique product name");

        // creating unique product name, and store it in variable -> to be used in test lifecycle
        String browser = data.getProperty("browser");
        int timeout = Integer.parseInt(data.getProperty("timeout"));
        System.out.println("Executing Tests in: " + browser + " browser");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/java/com/aspireapp/www/Resources/WedDrivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.chrome.driver", "WebDrivers\\chromedriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.chrome.driver", "WebDrivers\\chromedriver.exe");
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
        driver.manage().deleteAllCookies();
        return driver;
    }
}
