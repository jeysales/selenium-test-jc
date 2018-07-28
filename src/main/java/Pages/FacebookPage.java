package Pages;

import Helpers.DriverHelper;
import Helpers.WebDriverExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class FacebookPage extends WebDriverExtension {
    private static final String URL_FACEBOOK_SITE = "https://www.facebook.com/";
    private static final String ID_EMAIL_FIELD = "email";
    private static final String ID_PASSWORD_FIELD = "pass";
    private static final String ID_LOGIN_BUTTON = "loginbutton";
    private static final String NAME_STATUS_FIELD = "xhpc_message";
    private static final String CLASS_SHARE_BUTTON = "_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft";
    private static final String CLASS_PROFILE_BUTTON = "_2s25 _606w";



    private WebElement findEmailField(){
        return findElement(By.id(ID_EMAIL_FIELD));
    }

    private WebElement findPasswordField(){
        return findElement(By.id(ID_PASSWORD_FIELD));
    }

    private WebElement findLoginButton(){
        return findElement(By.id(ID_LOGIN_BUTTON));
    }

    private WebElement findStatusField(){
        return findElement(By.name(NAME_STATUS_FIELD));
    }

    private WebElement findShareButton(){
        return findElementByTagNameText("button", "Share");
    }

    private WebElement findProfileButton(){
        return findElement(By.className(CLASS_PROFILE_BUTTON));
    }


    public FacebookPage inputEmail(String email){
        sendKeys(findEmailField(), email);
        return this;
    }

    public FacebookPage inputPassword(String password){
        sendKeys(findPasswordField(), password);
        return this;
    }

    public FacebookPage clickLoginButton(){
        click(findLoginButton());
        return this;
    }

    public FacebookPage loginToFacebook(String email, String password){
        goToFacebook().inputEmail(email).inputPassword(password).clickLoginButton();
        return this;
    }

    public FacebookPage inputStatus(String status){
        sendKeys(findStatusField(), status);
        return this;
    }

    public FacebookPage clickShareButton(){
        click(findShareButton());
        return this;
    }

    public FacebookPage goToFacebook(){
        DriverHelper.Default.getWebDriver().get(URL_FACEBOOK_SITE);
        return this;
    }

}
