package Tests.AddCustomerPage;

import Pages.AddCustomerPage;
import Helpers.InputData;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Epic("SDET_Practice")
@Feature("Add Costumer")
@DisplayName("Тест-кейс № 01. \"Создание клиента (Add Customer)\"")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase01 extends BaseTest {
    private WebDriver driver;
    private AddCustomerPage addCustomerPage;
    InputData inputData = new InputData();


    @Description("Открытие начальной страницы теста")
    @BeforeEach
    public void setup(){
        driver = getDriver();
        driver.get(inputData.addCustomerPageURL);
        addCustomerPage = new AddCustomerPage(driver);
    }

    @Description("Проверка появления алёрта")
    @Test
    @Order(1)
    public void getAlertTest(){
        assertEquals("Customer added successfully with customer id :6", addCustomerPage.getAlertText(inputData.firstName, inputData.lastName, inputData.postCode));
    }

    @Description("Проверка создания новой строки в таблице Customers")
    @Test
    @Order(2)
    public void addCustomerTest(){
        addCustomerPage.addCustomer(inputData.firstName, inputData.lastName, inputData.postCode);
        assertEquals(inputData.Customer, addCustomerPage.getCustomerFromTable(inputData.Customer));
    }
}
