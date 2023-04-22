package testExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitEx {
    private WebDriver webDriver;
    private int timeToWait;

    public ExplicitWaitEx(WebDriver webDriver, int timeToWait) {
        this.webDriver = webDriver;
        this.timeToWait = timeToWait;
    }

    public String firstPageEls() {
        webDriver.get("https://www.google.com/");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeToWait));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeToWait));
        webDriver.findElement(By.id("L2AGLb")).click();
        webDriver.findElement(By.name("q")).sendKeys("yahoo");
        WebElement searchButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")
                )
        );
        searchButton.click();

        WebElement firstResult = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a//h3")));
        String firstResultText = firstResult.getText();

        return  firstResultText;
    }
}
