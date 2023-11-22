package lib.ui_common;

import io.appium.java_client.MobileDriver;
import lib.ui_common.MainPageObject;

public class NavigationUI extends MainPageObject {

    protected static String SAVED_ARTICLE_BUTTON;
    public NavigationUI(MobileDriver driver){
        super(driver);
    }

    public void clickSavedArticles(){
        waitForElementAndClick(
                getLocator(SAVED_ARTICLE_BUTTON),
                "No Saved button on the main screen is found",
                5);
    }

}
