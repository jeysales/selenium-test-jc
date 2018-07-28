package Helpers;

import com.sun.jna.platform.win32.Netapi32Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class DriverHelper {
    public static final DriverHelper Default = new DriverHelper();
    private static WebDriver driver;

    public void openBrowser(){
        File path = new File("src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void quit(){
        driver.close();
        driver.quit();
    }

    public WebDriver getWebDriver(){
        return this.driver;
    }


}
