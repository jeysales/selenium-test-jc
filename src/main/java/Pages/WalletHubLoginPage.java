package Pages;

import Helpers.DriverHelper;
import Helpers.WaitUtil;
import Helpers.WebDriverExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class WalletHubLoginPage extends WebDriverExtension {

    private static final String URL_LOGIN_PAGE = "https://wallethub.com/join/light";

    private WebElement findEmailField(){
        return findElement(By.name("em"));
    }

    private WebElement findPasswordField(){
        return findElement(By.name("pw1"));
    }

    private WebElement findLoginButton(){
        return findElementByTagNameText("span", "Login");
    }

    private WebElement findLoginTab(){
        return findElementByTagNameText("a", "Login");
    }

    public WalletHubLoginPage inputEmail(String email){
        sendKeys(findEmailField(), email);
        return this;
    }

    public WalletHubLoginPage inputPassword(String password){
        sendKeys(findPasswordField(), password);
        return this;
    }

    public WalletHubLoginPage clickLoginButton(){
        WaitUtil.sleep(5000);
        click(findLoginButton());
        return this;
    }

    public WalletHubLoginPage clickLoginTab(){
        WaitUtil.sleep(2000);
        click(findLoginTab());
        return this;
    }

    public WalletHubLoginPage loginToWalletHub(String email, String password){
        goToLoginPage().clickLoginTab().inputEmail(email).inputPassword(password).clickLoginButton();
        return this;
    }

    public WalletHubLoginPage goToLoginPage(){
        DriverHelper.Default.getWebDriver().get(URL_LOGIN_PAGE);
        return this;
    }


}
