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
@Feature("Sorting Costumers")
@DisplayName("Тест-кейс № 02. \"Сортировка клиентов по имени (First Name)\"")
public class TestCase02 {
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

    @Description("Закрытие браузера")
    @AfterEach
    public void after(){
        driver.quit();
    }
}
