package Tests.AddCustomerPage;

import Pages.AddCustomerPage;
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
@Feature("Add Costumer")
@DisplayName("Тест-кейс № 01. \"Создание клиента (Add Customer)\"")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase01 {
    private WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-infobars"));
    private AddCustomerPage addCustomerPage;
    Setup setup = new Setup(driver);
    InputData inputData = new InputData();

    @Description("Открытие браузера с соответствующими настройками")
    @BeforeEach
    public void setup(){
        setup.open(inputData.addCustomerPageURL);
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

    @Description("Закрытие браузера")
    @AfterEach
    public void after(){
        driver.quit();
    }
}
