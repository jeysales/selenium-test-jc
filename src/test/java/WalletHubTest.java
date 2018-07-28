import Helpers.BaseTest;
import Pages.FacebookPage;
import Pages.WalletHubLoginPage;
import Pages.WalletHubProfilePage;
import Pages.WalletHubReviewPage;
import SharedInstance.TestMessage;
import SharedInstance.Var;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class WalletHubTest extends BaseTest {
    FacebookPage facebookPage;
    WalletHubLoginPage walletHubLoginPage;
    WalletHubProfilePage walletHubProfilePage;
    WalletHubReviewPage  walletHubReviewPage;


    @Override
    @Before
    public void beforeTest(){
        super.beforeTest();
        facebookPage = new FacebookPage();
        walletHubLoginPage = new WalletHubLoginPage();
        walletHubProfilePage = new WalletHubProfilePage();
        walletHubReviewPage = new WalletHubReviewPage();
    }

    @Override
    public void afterTest(){
        super.afterTest();
    }

    @Test
    public void test_01(){
        facebookPage
                .loginToFacebook(Var.TEST_EMAIL, Var.TEST_FB_PASSWORD)
                .inputStatus(Var.TEST_STATUS)
                .clickShareButton();
    }

    @Test
    public void test_02(){
        walletHubLoginPage
                .goToLoginPage()
                .loginToWalletHub(Var.TEST_EMAIL, Var.TEST_PASSWORD);
        walletHubProfilePage
                .goToProfileToReview(Var.COMPANY_PROFILE_TO_REVIEW)
                .closeFooter()
                .hoverToRating()
                .hoverToStarRating(Var.TEST_RATING)
                .clickStarRating(Var.TEST_RATING);
        walletHubReviewPage
                .selectPolicyOption(Var.Policy.HEALTH.str())
//                .clickStarRating(Var.TEST_RATING)  //TODO: BUG: RATING IS REMOVED AFTER SELECTING POLICY. REMOVE THIS LINE WHEN BUG IS FIXED.
                .inputReview(Var.RANDOM_STRING_REVIEW)
                .clickSubmitReviewButton();
        assertTrue(walletHubReviewPage.isReviewConfirmationDisplayed(), TestMessage.REVIEW_CONFIRMATION_NOT_DISPLAYED);
        walletHubProfilePage
                .goToUserOption(Var.UserOption.PROFILE.str())
                .selectProfileNav(Var.ProfileNavTab.REVIEWS.str());
        assertTrue(walletHubProfilePage.isReviewFeedPostedInPersonalProfile(Var.COMPANY_PROFILE_TO_REVIEW,
                Var.RANDOM_STRING_REVIEW), TestMessage.REVIEW_FEED_NOT_FOUND);
        walletHubProfilePage
                .goToProfileToReview(Var.COMPANY_PROFILE_TO_REVIEW);
        assertTrue(walletHubProfilePage.isReviewPostedInOtherProfile(Var.TEST_USERNAME, Var.RANDOM_STRING_REVIEW),
                TestMessage.REVIEW_NOT_VISIBLE);

    }




}
