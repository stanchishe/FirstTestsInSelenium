package testExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePageTest {
    static WebDriver webDriver;

    //@AfterEach
    //@BeforeEach

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
    @DisplayName("should check if the home page is open correctly")
    public void shouldOpenHomePage() {
        String expectedHomeText = "Selenium Easy!";
        HomePage homePage = new HomePage(webDriver);
        webDriver.get("https://www.seleniumeasy.com/");
        Assertions.assertEquals(expectedHomeText, homePage.checkHomePage());
    }
}
