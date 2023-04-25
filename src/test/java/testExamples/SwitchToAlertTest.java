package testExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchToAlertTest {
    static WebDriver webDriver;

    @BeforeAll
    public static void initiate() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterAll
    public static void close() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    @DisplayName("should check if alert is created")
    public void checkForAlertCreation() {
        SwitchToEx switchToEx = new SwitchToEx(webDriver);
        Assertions.assertTrue(switchToEx.createAlert().contains("Hello! I am an alert box!"));
    }
}
