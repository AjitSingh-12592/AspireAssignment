package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;


    // Constructor to get driver control from Test Cases
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // Declaring Page web elements
    @FindBy(xpath = "img[alt='Logo']")
    public WebElement AspireLogo;

    @FindBy(css = "#login")
    public WebElement email;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement submit;


    // Defining methods to access Login Page web elements
    public WebElement getEmailFld() {
        return email;
    }

    public WebElement getPasswordFld() {
        return password;
    }

    public WebElement getSubmitBtn() {
        return submit;
    }

    public WebElement getAspireLogo() {
        return AspireLogo;
    }

}
