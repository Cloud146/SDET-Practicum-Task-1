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
    @FindBy(css = "body > div > div > div.ng-scope > div > div.center > button.btn.btn-lg.tab.btn-primary")
    public WebElement addCustomerTabButton;
    @FindBy(css = "body > div > div > div.ng-scope > div > div.center > button:nth-child(2)")
    private WebElement openAccountTabButton;
    @FindBy(css = "body > div > div > div.ng-scope > div > div.center > button:nth-child(3)")
    public WebElement customersTabButton;
    @FindBy(css = "body > div > div > div.box.mainhdr > button.btn.home")
    private WebElement homeButton;

    public WebElement getCustomersTabButton() {
        return customersTabButton;
    }
    public WebElement getAddCustomerTabButton() {
        return addCustomerTabButton;
    }
}
