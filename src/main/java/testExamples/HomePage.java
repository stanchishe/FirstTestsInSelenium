package testExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String checkHomePage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            String failedSleep = "SLEEP FAILED";
            System.out.println(failedSleep);
            return failedSleep;
        }

        WebElement welcomePage = webDriver.findElement(By.xpath(
                "//strong[contains(text(), 'Selenium Easy!')]"
        ));
        String homePageText = welcomePage.getText();
        return homePageText;
    }
}
