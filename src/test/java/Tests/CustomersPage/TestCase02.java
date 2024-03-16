package Tests.CustomersPage;

import Pages.AddCustomerPage;
import Pages.CustomersPage;
import Helpers.InputData;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Epic("SDET_Practice")
@Feature("Sorting Costumers")
@DisplayName("Тест-кейс № 02. \"Сортировка клиентов по имени (First Name)\"")
public class TestCase02 extends BaseTest {
    private WebDriver driver;
    private AddCustomerPage addCustomerPage;
    private CustomersPage customersPage;
    InputData inputData = new InputData();


    @Description("Открытие начальной страницы теста")
    @BeforeEach
    public void setup(){
        driver = getDriver();
        driver.get(inputData.addCustomerPageURL);
        addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addCustomer("A_firstName", "LastName", "postCode");
        addCustomerPage.addCustomer("Z_firstName", "LastName", "postCode");
        addCustomerPage.clickCustomersTab();
        customersPage = new CustomersPage(driver);
    }

    @Description("Тест сортировки по First Name по возрастанию")
    @Test
    @Order(1)
    public void ascSortByFirstNameSimpleTest(){
        customersPage.tableAscSortBy(customersPage.getFirstNameSortingButton());
        assertEquals("A_firstName LastName postCode Delete", customersPage.getFirstCellText());
    }

    @Description("Тест сортировки по First Name по убыванию")
    @Test
    @Order(2)
    public void descSortByFirstNameSimpleTest(){
        customersPage.tableDescSortBy(customersPage.getFirstNameSortingButton());
        assertEquals("Z_firstName LastName postCode Delete", customersPage.getFirstCellText());
    }

    @Description("Тест сортировки по First Name по возрастанию до и после сортировки")
    @Test
    @Order(3)
    public void ascSortByFirstNameTest(){
        String tableDataBeforeSorting = customersPage.getTableDataAsString();
        customersPage.tableAscSortBy(customersPage.getFirstNameSortingButton());
        String tableDataAfterSorting = customersPage.getTableDataAsString();
        assertNotEquals(tableDataBeforeSorting, tableDataAfterSorting);
        assertEquals(inputData.validAscData, tableDataAfterSorting);
    }

    @Description("Тест сортировки по First Name по убыванию до и после сортировки")
    @Test
    @Order(4)
    public void descSortByFirstNameTest(){
        String tableDataBeforeSorting = customersPage.getTableDataAsString();
        customersPage.tableDescSortBy(customersPage.getFirstNameSortingButton());
        String tableDataAfterSorting = customersPage.getTableDataAsString();
        assertNotEquals(tableDataBeforeSorting, tableDataAfterSorting);
        assertEquals(inputData.validDescData, tableDataAfterSorting);
    }
}
