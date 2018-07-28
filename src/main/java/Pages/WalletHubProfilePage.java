package Pages;

import Helpers.DriverHelper;
import Helpers.WaitUtil;
import Helpers.WebDriverExtension;
import SharedInstance.Var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class WalletHubProfilePage extends WebDriverExtension {

    Actions action = new Actions(DriverHelper.Default.getWebDriver());

    private static final String URL_WALLET_HUB_SITE = "https://wallethub.com/profile/";
    private static final String CLASS_FOOTER_MAIN_CONTENT = "main-content";
    private static final String CLASS_FOOTER_ARROW_DOWN = "cta_arrow down";
    private static final String ID_FOOTER = "footer_cta";
    private static final String TEXT_RATING = "Rating:";
    private static final String CLASS_REVIEWS = "reviews";


    private WebElement findHeaderLoginButton(){
        return findElement(By.className("login"));
    }

    private WebElement findRatings(){
        return findElementByTagNameText("span", TEXT_RATING);
    }

    private WebElement findStarRating(String rating){
        return findElementByTagNameText("a", rating);
    }

    private WebElement findFooterMainContent(){
        List<WebElement> footerSpan = findFooter().findElements(By.tagName("div"));
        for (WebElement footer : footerSpan){
            if(footer.getAttribute("class").equals(CLASS_FOOTER_MAIN_CONTENT))
                return footer;
        }
        return null;
    }

    private WebElement findFooterCloseButton(){
        List<WebElement> footerSpan = findFooter().findElements(By.tagName("span"));
        for (WebElement footer : footerSpan){
            if(footer.getAttribute("class").equals(CLASS_FOOTER_ARROW_DOWN))
                return footer;
        }
        return null;
    }

    private WebElement findFooter(){
        return findElement(By.id(ID_FOOTER));
    }

    private WebElement findWalletNewsField(){
        return getParent(findElement(By.id("_wpnonce_post_update")));
    }

    private WebElement findReviewsSection(){
        return findElement(By.className("reviews"));
    }

    private List<WebElement> findReviewAuthors(){
        return findReviewsSection().findElements(By.className("author"));
    }

    private WebElement findReview(String author){
        int count = findReviewAuthors().size();
        for (int i=0; i<=count-1; i++)
            if(findReviewAuthors().get(i).getText().equals("By: "+author))
                return findReviewsSection().findElements(By.className("review")).get(i);
        return null;
    }

    private WebElement findUserDropdown(){
        return findElement(By.className("user"));
    }

    private WebElement findUserDropdownOption(String option){
        List<WebElement> elements = findElement(By.id("m-user")).findElements(By.tagName("a"));
        for (WebElement element : elements)
            if(element.getText().equals(option))
                return element;
        return null;
    }

    private WebElement findProfileNav(String nav){
        List<WebElement> navs = findElement(By.className("profilenav")).findElements(By.tagName("a"));
        for (WebElement element : navs)
            if (element.getText().contains(nav))
                return element;
        return null;
    }

    private WebElement findReviewFeed(String company){
        List<WebElement> companyNames = findReviewsSection().findElements(By.className("profile-company-name"));
        int count = companyNames.size();
        for (int i=0; i<=count-1; i++)
            if (companyNames.get(i).findElement(By.tagName("strong")).getText().equals(company))
                return findReviewsSection().findElements(By.tagName("p")).get(i);
        return null;
    }


    public WalletHubProfilePage clickHeaderLoginButton(){
        click(findHeaderLoginButton());
        return this;
    }

    public WalletHubProfilePage hoverToRating(){
        action.moveToElement(findRatings()).build().perform();
        return this;
    }

    public WalletHubProfilePage hoverToStarRating(String rating){
        action.moveToElement(findStarRating(rating)).build().perform();
        return this;
    }

    public WalletHubProfilePage clickStarRating(String rating){
        click(findStarRating(rating));
        return this;
    }

    public WalletHubProfilePage closeFooter(){
        if(findFooterMainContent().isDisplayed())
            click(findFooterCloseButton());
        return this;
    }

    public WalletHubProfilePage goToProfileToReview(String company){
        String temp = company.toLowerCase();
        String newCompany = temp.replace(" ", "_");
        String companyName = URL_WALLET_HUB_SITE + newCompany + "/";
        DriverHelper.Default.getWebDriver().get(companyName);
        return this;
    }

    public WalletHubProfilePage goToUserOption(String option){
        click(findUserDropdown());
        click(findUserDropdownOption(option));
        return this;
    }

    public WalletHubProfilePage selectProfileNav(String nav){
        click(findProfileNav(nav));
        return this;
    }

    public Boolean isReviewFeedPostedInPersonalProfile(String otherProfile, String review){
        return findReviewFeed(otherProfile).getText().equals(review);
    }

    public Boolean isReviewPostedInOtherProfile(String author, String review){
        return findReview(author).getText().equals(review);
    }

}
