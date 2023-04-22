package testExamples;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitEx {
    private WebDriver webDriver;
    private int  timeToWait;
    private int pollIntervals;

    public FluentWaitEx(WebDriver webDriver, int timeToWait, int pollIntervals) {
        this.webDriver = webDriver;
        this.timeToWait = timeToWait;
        this.pollIntervals = pollIntervals;
    }

    public String pollForResults() {
        Wait<WebDriver> wait = new FluentWait(webDriver)
                .withTimeout(Duration.ofSeconds(timeToWait))
                .pollingEvery(Duration.ofSeconds(pollIntervals))
                .ignoring(InvalidArgumentException.class);

        //Add possible real life examples in the code, currently not used!

        return "results";
    }
}
