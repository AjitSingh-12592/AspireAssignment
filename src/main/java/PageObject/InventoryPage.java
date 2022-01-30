package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage<WebElements> {

    WebDriver driver;

    // Constructor to get driver control from Test Cases
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Declaring Page web elements
    @FindBy(xpath = "//a[contains(text(),'Inventory')]")
    private WebElement inventoryHeader;

    @FindBy(xpath = "//div[contains(text(),'Discuss')]")
    private WebElement discuss;

    @FindBy(xpath = "//div[contains(text(),'Manufacturing')]")
    private WebElement manufacturing;


    @FindBy(css = "button[title='Products']")
    private WebElement products;


    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement ProductsBtn;
//
    @FindBy(css = "button[title='Create record']")
    private WebElement createButton;

    @FindBy(css = "button[title='Save record']") //(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveProductButton;



    public WebElement getSaveProductButton() {
        return saveProductButton;
    }

    public WebElement getInventoryHeader() {
        return inventoryHeader;
    }

    public WebElement getProductsDropdown() {
        return products;
    }

    public WebElement getProductsBtn() {
        return ProductsBtn;
    }

    public WebElement getCreateButton() {
        return createButton;
    }
//
//    public WebElement selectMenuOption(String menuOption) {
//        WebElement option = null;
//        switch (menuOption) {
//            case "Discuss":
//                option = discuss;
//                break;
//
//            case "Inventory":
//                option = inventory;
//                break;
//
//            case "Manufacturing":
//                option = manufacturing;
//                break;
//        }
//        return option;
//    }

}


