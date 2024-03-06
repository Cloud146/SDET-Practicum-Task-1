package Tests.CustomersPage;

import Helpers.InputData;
import Pages.AddCustomerPage;
import Pages.CustomersPage;
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
@DisplayName("Тест-кейс № 02. \"Сортировка клиентов по имени (First Name). 2 способ\"")
public class TestCase00 extends BaseTest {
    private WebDriver driver;
    private AddCustomerPage addCustomerPage;
    private CustomersPage customersPage;
    InputData inputData = new InputData();

    public interface CompareData {
        String validAscData = "A_firstName, LastName, postCode, , Delete \n" +
                "Albus, Dumbledore, E55656, 1010 1011 1012, Delete \n" +
                "Harry, Potter, E725JB, 1004 1005 1006, Delete \n" +
                "Hermoine, Granger, E859AB, 1001 1002 1003, Delete \n" +
                "Neville, Longbottom, E89898, 1013 1014 1015, Delete \n" +
                "Ron, Weasly, E55555, 1007 1008 1009, Delete \n" +
                "Z_firstName, LastName, postCode, , Delete";

        String validDescData = "Z_firstName, LastName, postCode, , Delete \n" +
                "Ron, Weasly, E55555, 1007 1008 1009, Delete \n" +
                "Neville, Longbottom, E89898, 1013 1014 1015, Delete \n" +
                "Hermoine, Granger, E859AB, 1001 1002 1003, Delete \n" +
                "Harry, Potter, E725JB, 1004 1005 1006, Delete \n" +
                "Albus, Dumbledore, E55656, 1010 1011 1012, Delete \n" +
                "A_firstName, LastName, postCode, , Delete";
    }

    @Description("Открытие браузера с соответствующими настройками")
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

    @Test
    @Order(1)
    public void TestTest(){
        String tableDataBeforeSorting = customersPage.getTableDataAsString();
        customersPage.tableAscSortBy(customersPage.getFirstNameSortingButton());
        String tableDataAfterSorting = customersPage.getTableDataAsString();
        assertNotEquals(tableDataBeforeSorting, tableDataAfterSorting);
        assertEquals(CompareData.validAscData, tableDataAfterSorting);
    }

    @Test
    @Order(2)
    public void TestTest2(){
        String tableDataBeforeSorting = customersPage.getTableDataAsString();
        customersPage.tableDescSortBy(customersPage.getFirstNameSortingButton());
        String tableDataAfterSorting = customersPage.getTableDataAsString();
        assertNotEquals(tableDataBeforeSorting, tableDataAfterSorting);
        assertEquals(CompareData.validDescData, tableDataAfterSorting);
    }
}
