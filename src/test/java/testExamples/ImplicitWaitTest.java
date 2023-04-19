package testExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ImplicitWaitTest {
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
    @DisplayName("should fetch an elements value from page")
    public void shouldFetchValue()  {
        ImplicitWaitEx implicitWait = new ImplicitWaitEx(webDriver, 10);
        //System.out.println(implicitWait.basicImpWait());
        Assertions.assertTrue(implicitWait.basicImpWait().contains("charles.morris"));
    }
}
