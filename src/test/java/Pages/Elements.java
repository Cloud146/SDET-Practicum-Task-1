package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
    private WebDriver driver;

    public Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[ng-click=\"addCust()\"]\n")
    public WebElement addCustomerTabButton;
    @FindBy(css = "button[ng-click=\"openAccount()\"]\n")
    private WebElement openAccountTabButton;
    @FindBy(css = "button[ng-click=\"showCust()\"]\n")
    public WebElement customersTabButton;
    @FindBy(css = "button[ng-click=\"home()\"]\n")
    private WebElement homeButton;

    public WebElement getCustomersTabButton() {
        return customersTabButton;
    }
    public WebElement getAddCustomerTabButton() {
        return addCustomerTabButton;
    }
}
