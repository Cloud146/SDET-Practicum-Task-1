package Tests;


import Helpers.InputData;
import io.qameta.allure.Description;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    @Description("Открытие браузера с соответствующими настройками")
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver(new ChromeOptions()
                .addArguments("--remote-allow-origins=**")
                .addArguments("--disable-gpu")
                .addArguments("--disable-infobars")
                .addArguments("--start-maximized"));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Description("Закрытие браузера")
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


//    @BeforeEach
//    public void setUp(){
//        String browserName = System.getProperty("browser", "chrome");
//        switch (browserName) {
//            case "chrome":
//                driver = new ChromeDriver(new ChromeOptions()
//                        .addArguments("--remote-allow-origins=**")
//                        .addArguments("--disable-gpu")
//                        .addArguments("--disable-infobars")
//                        .addArguments("--start-maximized"));
//                break;
//            default:
//                throw new IllegalStateException("Unexpected browser name: " + browserName);
//        }
//        driver.manage().window().setSize(new Dimension(1920, 1080));
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
