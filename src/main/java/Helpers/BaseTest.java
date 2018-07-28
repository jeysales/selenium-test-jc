package Helpers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class BaseTest {
    public final StringBuilder errorMessages = new StringBuilder();

    @Before
    public void beforeTest(){
        DriverHelper.Default.openBrowser();
    }

    @After
    public void afterTest(){
//        DriverHelper.Default.quit();
        assertFail();
    }

    public void assertFail() {
        if (errorMessages.length() > 0)
            Assert.fail(errorMessages.toString());
    }

    public void assertTrue(boolean value, String message) {
        if (value != true)
            errorMessages.append("\n" + message);
    }
}
