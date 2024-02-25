package Tests.CustomersPage;

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

@Epic("SDET_Practice")
@Feature("Sorting Costumers")
@DisplayName("Тест-кейс № 02. \"Сортировка клиентов по имени (First Name)\"")
public class TestCase02 extends BaseTest {
    private WebDriver driver;
    private CustomersPage customersPage;
    InputData inputData = new InputData();

    @Description("Открытие начальной страницы теста")
    @BeforeEach
    public void setup(){
        driver = getDriver();
        driver.get(inputData.customersPageURL);
        customersPage = new CustomersPage(driver);
    }

    @Description("Тест сортировки по First Name по возрастанию")
    @Test
    @Order(1)
    public void ascSortByFirstNameTest(){
        customersPage.tableAscSortBy(customersPage.getFirstNameSortingButton());
        assertEquals("Albus Dumbledore E55656 1010 1011 1012 Delete", customersPage.getFirstCellText());
    }

    @Description("Тест сортировки по First Name по убыванию")
    @Test
    @Order(2)
    public void descSortByFirstNameTest(){
        customersPage.tableDescSortBy(customersPage.getFirstNameSortingButton());
        assertEquals("Ron Weasly E55555 1007 1008 1009 Delete", customersPage.getFirstCellText());
    }
}
