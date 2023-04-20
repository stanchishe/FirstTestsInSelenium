package testExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExplicitWaitTest {
    static WebDriver webDriver;

    @BeforeAll
    public static void initiate() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
    }

    @AfterAll
    public static void cleanup() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    @DisplayName("should check if page values are fetched")
    public void shouldOpenResultsPage() throws InterruptedException {
        webDriver.get("https://google.com/");
        ExplicitWaitEx explicitWaitEx = new ExplicitWaitEx(webDriver, 10);
        Assertions.assertTrue(explicitWaitEx.firstPageEls().contains("Yahoo"));
    }

}
