package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    WebDriver driver;

    // Constructor to get driver control from Test Cases
    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Declaring Page web elements
    @FindBy(xpath = "//div[contains(text(),'Inventory')]")
    private WebElement inventory;


    @FindBy(css = "a[title='Previous view']")
    private WebElement backButton;

    @FindBy(xpath = "//div[contains(text(),'Discuss')]")
    private WebElement discuss;

    @FindBy(xpath = "//div[contains(text(),'Manufacturing')]")
    private WebElement manufacturing;
//
//    @FindBy(css = "button[type='submit']")
//    private WebElement Login;


    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getInventory() {
        return inventory;
    }

    public WebElement getDiscuss() {
        return discuss;
    }

    public WebElement getManufacturing() {
        return manufacturing;
    }

    public WebElement selectMenuOption(String menuOption) {
        WebElement option = null;
        switch (menuOption) {
            case "Discuss":
                option = discuss;
                break;

            case "Inventory":
                option = inventory;
                break;

            case "Manufacturing":
                option = manufacturing;
                break;
        }
        return option;
    }

}


