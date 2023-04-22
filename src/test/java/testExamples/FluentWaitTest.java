package testExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FluentWaitTest {
    static WebDriver webDriver;

    @BeforeAll
    public static void initiate() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //INCLUDE ADD BLOCK HERE
        options.addArguments("Start-Maximized");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
    }

    @AfterAll
    public static void close() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    @DisplayName("should fetch elements from page")
    public void shouldFetchElements() {
        FluentWaitEx fluentWaitEx = new FluentWaitEx(webDriver, 60, 5);
        System.out.println(fluentWaitEx.pollForResults());
        Assertions.assertTrue(fluentWaitEx.pollForResults().equals("results"));
    }
}
