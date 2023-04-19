package testExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ImplicitWaitEx {
    private WebDriver webDriver;
    private int timeToWait;

    public ImplicitWaitEx(WebDriver webDriver, int timeToWait) {
        this.webDriver = webDriver;
        this.timeToWait = timeToWait;
    }

    public String basicImpWait() {
        webDriver.get("https://reqres.in/api/users?delay=3");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeToWait));
        WebElement jsonElement = webDriver.findElement(By.xpath("/html/body/pre"));
        String jsonResultString = jsonElement.getText();
        return jsonResultString;
    }
}
