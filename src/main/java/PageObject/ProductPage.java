package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    // Constructor to get driver control from Test Cases
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Declaring Page web elements

    @FindBy(css = "button[title='Save record']")
    private WebElement saveButton;

    @FindBy(css = "th[title='Location']")
    private WebElement locationButton;

    @FindBy(css = "input[name='name']")
    private WebElement productNameField;

    @FindBy(css = "button[title='Edit record']")
    private WebElement editButton;

    @FindBy(xpath = "//span[contains(text(),'Update Quantity')]")
    private WebElement updateQuantity;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    private WebElement createButton;

    @FindBy(css = "input[name='inventory_quantity']")
    private WebElement countedQuantity;

    @FindBy(css = "a[title='Home menu']")
    private WebElement homeButton;

    public WebElement getLocationButton() {
        return locationButton;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getUpdateQuantity() {
        return updateQuantity;
    }

    public WebElement getCreateButton() {
        return createButton;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getCountedQuantity() {
        return countedQuantity;
    }

    public WebElement getProductNameField() {
        return productNameField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }


}


