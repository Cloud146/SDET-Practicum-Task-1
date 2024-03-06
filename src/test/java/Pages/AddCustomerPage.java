package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddCustomerPage {
    private WebDriver driver;
    private Elements elements;

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
        elements = new Elements(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input.form-control[ng-model=\"fName\"]\n")
    private WebElement firstNameField;
    @FindBy(css = "input.form-control[ng-model=\"lName\"]\n")
    private WebElement lastNameField;
    @FindBy(css = "input.form-control[ng-model=\"postCd\"]\n")
    private WebElement postCodeField;
    @FindBy(css = "button[type=\"submit\"].btn.btn-default\n")
    private WebElement addCustomerButton;

    public AddCustomerPage enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        return this;
    }

    public AddCustomerPage enterLastName(String lastName){
        lastNameField.sendKeys(lastName);
        return this;
    }
    public AddCustomerPage enterPostCode(String postCode){
        postCodeField.sendKeys(postCode);
        return this;
    }
    public AddCustomerPage clickAddCustomerButton(){
        addCustomerButton.click();
        return this;
    }

    public void clickCustomersTab(){
        elements.getCustomersTabButton().click();
    }


    public AddCustomerPage addCustomer(String firstName, String lastName, String postCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostCode(postCode);
        clickAddCustomerButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public String getAlertText(String firstName, String lastName, String postCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostCode(postCode);
        clickAddCustomerButton();
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String getCustomerFromTable(String newCustomer){
        clickCustomersTab();
        CustomersPage customersPage = new CustomersPage(driver);
        return customersPage.findCustomerInTable(newCustomer);
    }
}
