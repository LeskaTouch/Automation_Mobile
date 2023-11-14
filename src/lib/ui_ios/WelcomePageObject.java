package lib.ui_ios;

import io.appium.java_client.AppiumDriver;
import lib.ui_common.MainPageObject;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {
    private static final String LEARN_MORE = "name:Learn more about Wikipedia";
    private static final String NEXT_BUTTON = "name:Next";
    private static final String NEW_WAYS = "id:New ways to explore";
    private static final String SEARCH_IS_OVER = "id:Search in over 300 languages";
    private static final String MAKE_APP_BETTER = "id:Help make the app better";
    private static final String GET_STARTED = "name:Get started";


    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public void waitForLearnMoreLink(){
        waitForElement(getLocator(LEARN_MORE), "No 'Learn more about Wikipedia' text is found", 10 );

    }
    public void clickNextButton(){
        waitForElementAndClick(getLocator(NEXT_BUTTON), "No 'Next' button is found", 10);
    }

    public void waitForNewWaysToExplore(){
        waitForElement(getLocator(NEW_WAYS), "No 'New ways to explore' is found", 10);
    }
    public void waitForSearchInOverLanguages(){
        waitForElement(getLocator(SEARCH_IS_OVER), "No 'Search in over 300 languages' text is found", 10);
    }
    public void waitForHelpMakeAppBetter(){
        waitForElement(getLocator(MAKE_APP_BETTER), "No 'Help make the app better' text is found", 10 );
    }

    public void clickGetStartedButton(){
        waitForElementAndClick(getLocator(GET_STARTED), "No 'Get started' button is found", 10);
    }






}
