package Pages;

import Helpers.WaitUtil;
import Helpers.WebDriverExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class WalletHubReviewPage extends WebDriverExtension {

    private static final String ID_REVIEW_TEXT_AREA = "review-content";
    private static final String ID_OVERALL_RATING = "overallRating";
    private static final String TEXT_SELECT_YOUR_POLICY = "Please select your policy";
    private static final String TEXT_REVIEW_CONFIRMATION = "Your Test Insurance Company review has been posted.";


    private WebElement findPolicyDropdown(){
        return findElementByTagNameText("span", TEXT_SELECT_YOUR_POLICY);
    }

    private WebElement findPolicyOptions(String option){
        return findElementByTagNameText("a",option);
    }

    private WebElement findReviewTextArea(){
        return findElement(By.id(ID_REVIEW_TEXT_AREA));
    }

    private WebElement findSubmitReviewButton(){
        List<WebElement> buttons = findElements(By.tagName("input"));
        for(WebElement button : buttons){
            if(button.getAttribute("value").equals("Submit"))
                return button;
        }
        return null;
    }

    private WebElement findStarRating(String rating){
        int rate = Integer.valueOf(rating);
        int i = rate - 1;
        return findElement(By.id(ID_OVERALL_RATING)).findElements(By.tagName("a")).get(i);
    }

    private WebElement findLoadingImage(){
        return findElement(By.className("loading-image"));
    }

    private WebElement findReviewConfirmation(){
        return findElement(By.tagName("h1"));
    }



    public WalletHubReviewPage clickPolicyDropdown(){
        click(findPolicyDropdown());
        return this;
    }




    public WalletHubReviewPage selectPolicyOption(String option){
        WaitUtil.sleep(5000);
        clickPolicyDropdown();
        click(findPolicyOptions(option));
        waitUntilLoadingIsComplete(5);
        return this;
    }

    public WalletHubReviewPage inputReview(String review){
        sendKeys(findReviewTextArea(), review);
        return this;
    }

    public WalletHubReviewPage clickSubmitReviewButton(){
        click(findSubmitReviewButton());
        return this;
    }

    public WalletHubReviewPage clickStarRating(String rating){
        click(findStarRating(rating));
        return this;
    }

    private void waitUntilLoadingIsComplete(int sec){
        for(int i =0; i<sec; i++) {
            if (findLoadingImage() != null)
                WaitUtil.sleep(1000);
        }
    }

    public Boolean isReviewConfirmationDisplayed(){
         String text = findReviewConfirmation().getText();
         if (findReviewConfirmation().isDisplayed() && text.contains(TEXT_REVIEW_CONFIRMATION))
             return true;
         return false;
    }
}
