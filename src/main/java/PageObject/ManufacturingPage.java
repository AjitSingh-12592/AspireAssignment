package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturingPage {

    WebDriver driver;

    // Constructor to get driver control from Test Cases
    public ManufacturingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Declaring Page web elements
    @FindBy(xpath = "//a[contains(text(),'Manufacturing')]")
    private WebElement manufacturingHeader;

//    @FindBy(css = "button[title='Save record']") //(xpath = "//button[contains(text(),'Save')]")
//    private WebElement saveManufacturingButton;


//    @FindBy(css = "#o_field_input_643")
//    private WebElement selectProductName;


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/div[1]/div[1]/input[1]")
    private WebElement selectProductName;


    @FindBy(xpath = "//button[contains(text(),'Add a line')]")
    private WebElement AddLine;

    @FindBy(xpath = "/html/body/div[2]/div[5]/div/div/div/footer/button[1]/span")
    private WebElement popUpCreateButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/table[1]/tbody/tr[9]/td[2]/div/div/span")
    private WebElement productQuantityField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/table[1]/tbody/tr[9]/td[2]/div/div/input")
    private WebElement productQuantityInputField;

    @FindBy(linkText = "Add a line")
    private WebElement addComponentsButton;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[3]")
    private WebElement componentsSelectProducts;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[4]")
    private WebElement unitOfMeasurement;

    @FindBy(css = "button[title='Current state']")
    private WebElement currentState;

    @FindBy(css = "input[name='quantity_done']")
    private WebElement componentsQuantity;

    public WebElement getProductQuantityField() {
        return productQuantityField;
    }

    public WebElement getCurrentState() {
        return currentState;
    }

    public WebElement getProductQuantityInputField() {
        return productQuantityInputField;
    }

    public WebElement getAddComponentsButton() {
        return addComponentsButton;
    }

    public WebElement getComponentsSelectProducts() {
        return componentsSelectProducts;
    }

    public WebElement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public WebElement getComponentsQuantity() {
        return componentsQuantity;
    }

    @FindBy(css = "button[title='Save record']")
    private WebElement saveButton;

    @FindBy(css = "input[name='name']")
    private WebElement productNameField;

    @FindBy(xpath = "//span[contains(text(),'Update Quantity')]")
    private WebElement updateQuantity;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    private WebElement createButton;

    @FindBy(xpath = "(//button[@name='button_mark_done'])[3]")
    private WebElement markAsDoneButton;

    @FindBy(css = "input[name='inventory_quantity']")
    private WebElement countedQuantity;

    @FindBy(css = "a[title='Home menu']")
    private WebElement homeButton;

    @FindBy(css = "button[name='action_confirm']")
    private WebElement confirmButton;

    public WebElement getMarkAsDoneButton() {
        return markAsDoneButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public WebElement getAddLine() {
        return AddLine;
    }

    public WebElement getPopUpCreateButton() {
        return popUpCreateButton;
    }

    public WebElement getSelectProductName() {
        return selectProductName;
    }

    public WebElement getManufacturingHeader() {
        return manufacturingHeader;
    }

    public WebElement getCreateButton() {
        return createButton;
    }

//    public WebElement getSaveManufacturingButton() {
//        return saveManufacturingButton;
//    }


    public WebElement getUpdateQuantity() {
        return updateQuantity;
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


