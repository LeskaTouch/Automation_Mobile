package tests.ios;

import lib.test_case.IosTestCase;
import lib.ui_ios.WelcomePageObject;
import org.junit.Test;

public class WelcomePageTests extends IosTestCase {
    @Test
    public void testWelcomePage(){
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForNewWaysToExplore();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForSearchInOverLanguages();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForHelpMakeAppBetter();
        welcomePageObject.clickGetStartedButton();

    }
}
