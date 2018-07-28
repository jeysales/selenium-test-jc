package SharedInstance;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by LENOVO on 21/07/2018.
 */
public class Var {

    // TEST_01
    public static final String TEST_EMAIL = "planeturanus123@gmail.com";
    public static final String TEST_FB_PASSWORD = "hellotesting1";
    public static final String TEST_STATUS = "Hello World";


    //TEST_02
    public static final String TEST_PASSWORD = "Hellotesting@1";
    public static final String TEST_RATING = "5";
    public static final String COMPANY_PROFILE_TO_REVIEW = "Test Insurance Company";
    public static final String TEST_USERNAME = "planeturanus123";
    public static final String RANDOM_STRING_REVIEW = RandomStringUtils.randomAlphanumeric(20) +
            "4JhFLSSx EyxDUUKxxKVx3S Da &E KxJgn xRE1KJPSanFwgP4iD&a bi21bPQJK5EV2cQ&c56P56 c i21bPQT4biD&wV xRE1KJPSanFwgP4iD&a" +
            "EEcFnS2V& 5 RTUbb E535mS a*c6 iTKEa T6U1 3cPoh4JE xmaV6TP FPo& LT4biD&wV h 5Jy*&6T&oTSE";

    public enum Policy {
        ANNUITIES("Annuities"),
        HEALTH("Health"),
        LIFE("Life"),
        OVERALL("Overall - Multiple Products");

        private String option;
        Policy(String option){
            this.option = option;
        }
        public String str(){
            return option;
        }

    }

    public enum UserOption{
        PROFILE("Profile"),
        SETTINGS("Settings"),
        LOGOUT("Logout");

        private String option;

        UserOption(String option){
            this.option = option;
        }

        public String str(){
            return option;
        }
    }

    public enum ProfileNavTab{
        INFO("Info"),
        ACTIVITY("Activity"),
        REVIEWS("Reviews"),
        ANSWERS("Answers");

        private String option;

        ProfileNavTab(String option){
            this.option = option;
        }

        public String str(){
            return option;
        }
    }

}
