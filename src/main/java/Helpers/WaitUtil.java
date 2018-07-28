package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class WaitUtil {

    public static Wait<WebDriver> fluentWait() {
        Wait<WebDriver> wait = new FluentWait(DriverHelper.Default.getWebDriver())
                .withTimeout(5000, TimeUnit.MILLISECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return wait;
    }

    public static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
