package Tests.CustomersPage;

import Pages.CustomersPage;
import Helpers.InputData;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("SDET_Practice")
@Feature("Deleting Costumer")
@DisplayName("Тест-кейс № 03. \"Удаление клиента\"")
public class TestCase03 extends BaseTest {
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

    @Description("Тест удаления покупателя с именем близким к среднему арифметическому всех имён")
    @Test
    @Order(1)
    public void deleteCustomerTest(){
        String customerToDelete = customersPage.findCustomerFirstNameNearAverage();
        assertEquals("Harry", customerToDelete);
        assertEquals(1, customersPage.findIndex(customerToDelete));
        customersPage.deleteCustomer(customerToDelete);
        assertEquals("not found", customersPage.findCustomerInTable(customerToDelete));
    }
}
