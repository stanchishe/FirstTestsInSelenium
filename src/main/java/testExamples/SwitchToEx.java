package testExamples;

import org.openqa.selenium.*;

public class SwitchToEx {
    private WebDriver webDriver;

    public SwitchToEx(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String createAlert() throws UnhandledAlertException {
        //Open page
        webDriver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        webDriver.findElement(By.id("accept-choices")).click();

        //Switch frame
        WebElement frameOfHtml = webDriver.findElement(By.id("iframeResult"));
        webDriver.switchTo().frame(frameOfHtml);

        //Create alert and get text from alert
        String alertText = "BAD ALERT!";
        webDriver.findElement(By.xpath("/html/body/button")).click();
        Alert alert = webDriver.switchTo().alert();
        alertText = alert.getText();
        System.out.println("Alert data: " + alertText);

        //Accept the alert
        alert.accept();

        //Return to base HTML page, apparently alert is generated for it?!
        webDriver.switchTo().parentFrame();



        return alertText;
    }
}
