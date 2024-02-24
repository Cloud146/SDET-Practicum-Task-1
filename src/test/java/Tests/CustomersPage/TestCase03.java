package Tests.CustomersPage;

import Pages.CustomersPage;
import Pages.InputData;
import Tests.Setup;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("SDET_Practice")
@Feature("Deleting Costumer")
@DisplayName("Тест-кейс № 03. \"Удаление клиента\"")
public class TestCase03 {
    private WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-infobars"));
    private CustomersPage customersPage;
    Setup setup = new Setup(driver);
    InputData inputData = new InputData();

    @Description("Открытие браузера с соответствующими настройками")
    @BeforeEach
    public void setup(){
        setup.open(inputData.customersPageURL);
        customersPage = new CustomersPage(driver);
    }

    @Description("Тест удаления покупателя с именем близким к среднему арифметическому всех имён")
    @Test
    public void deleteCustomerTest(){
        String customerToDelete = customersPage.findCustomerFirstNameNearAverage();
        assertEquals("Harry", customerToDelete);
        assertEquals(1, customersPage.findIndex(customerToDelete));
        customersPage.deleteCustomer(customerToDelete);
        assertEquals("not found", customersPage.findCustomerInTable(customerToDelete));
    }

    @Description("Закрытие браузера")
    @AfterEach
    public void after(){
        driver.quit();
    }
}
