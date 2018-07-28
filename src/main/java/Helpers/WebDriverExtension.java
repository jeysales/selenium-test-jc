package Helpers;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class WebDriverExtension {

    public static WebElement findElement(By by){
        try{
            WebElement element = WaitUtil.fluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
            return element;
        } catch (Exception e){
            System.out.println("No element found");
            return null;
        }
    }

    public static List<WebElement> findElements(By by){
        try {
            return WaitUtil.fluentWait().until(
                    e -> DriverHelper.Default.getWebDriver().findElements(by));
        } catch (NoSuchElementException | NullPointerException e) {
            System.out.println("No element found");
            return null;
        }
    }

    public static WebElement findElement(WebElement parentElement, By by) {
        try {
            WebElement element = parentElement.findElement(by);
            return element;
        } catch (NoSuchElementException | NullPointerException e) {
            System.out.println("No element found");
            return null;
        }
    }

    public static WebElement findElementByTagNameText(String tagName, String text) {
        List<WebElement> elements = findElements(By.tagName(tagName));
        for (WebElement element : elements ){
            if(element.getText().equals(text))
                return element;
        }
        return null;
    }

    public static void click(WebElement e){
        WebElement element = WaitUtil.fluentWait().until(ExpectedConditions.elementToBeClickable(e));
        element.click();
    }

    public static void sendKeys(WebElement e, String text){
        if (e!=null && e.isDisplayed()){
            e.clear();
            e.sendKeys(text);
        }else
            System.out.println("Element is null or not displayed");
    }

    public static WebElement getParent(WebElement e) {
        return findElement(e, new By.ByXPath(".."));
    }

}
