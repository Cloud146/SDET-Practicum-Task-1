package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersPage {
    private WebDriver driver;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > table")
    private WebElement customersTable;
    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > table > thead > tr > td:nth-child(1) > a")
    public WebElement firstNameSortingButton;
    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > table > thead > tr > td:nth-child(2) > a")
    public WebElement lastNameSortingButton;
    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > table > thead > tr > td:nth-child(3) > a")
    public WebElement postCodeSortingButton;

    public WebElement getFirstNameSortingButton() {
        return firstNameSortingButton;
    }

    public CustomersPage tableDescSortBy(WebElement sortingElement) {
        sortingElement.click();
        return this;
    }

    public CustomersPage tableAscSortBy(WebElement sortingElement) {
        sortingElement.click();
        sortingElement.click();
        return this;
    }

    public String getFirstCellText() {
        List<WebElement> rows = customersTable.findElements(By.tagName("tr"));
        return rows.get(1).getText();
    }


    public String findCustomerInTable(String searchCustomer) {
        String foundCustomer = "not found";
        List<WebElement> rows = customersTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int lastIndex = cells.size() - 2;
            String rowText = cells.stream()
                    .limit(lastIndex)
                    .map(WebElement::getText)
                    .collect(Collectors.joining(", "));
            if (rowText.contains(searchCustomer)) {
                foundCustomer = rowText;
            }
        }
        return foundCustomer;
    }

    public String findCustomerFirstNameNearAverage() {
        List<WebElement> rows = customersTable.findElements(By.tagName("tr"));
        List<String> names = rows.stream()
                .skip(1)
                .map(row -> row.findElement(By.tagName("td")).getText())
                .collect(Collectors.toList());

        List<Integer> lengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        double average = lengths.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        String nameToRemove = names.stream()
                .min(Comparator.comparingDouble(name -> Math.abs(name.length() - average)))
                .get();
        return nameToRemove;
    }

    public int findIndex(String firstName){
        List<WebElement> rows = customersTable.findElements(By.tagName("tr"));
        List<String> names = rows.stream()
                .skip(1)
                .map(row -> row.findElement(By.tagName("td")).getText())
                .collect(Collectors.toList());
        int index = names.indexOf(firstName);
        return index;
    }

    public CustomersPage deleteCustomer(String customerFirstName){
        int indexOfCustomer = findIndex(customerFirstName)+1;
        WebElement customerDeleteButton = driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > table > tbody > tr:nth-child("+indexOfCustomer+") > td:nth-child(5) > button"));
        customerDeleteButton.click();
        return this;
    }
}
