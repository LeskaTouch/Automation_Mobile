package lib.ui_android;

import io.appium.java_client.AppiumDriver;
import lib.ui_common.WelcomePageObject;
import org.junit.Test;

public class AndroidWelcomePage extends WelcomePageObject {

    public AndroidWelcomePage(AppiumDriver driver) {
        super(driver);
    }
    @Override
    public void clickSkipButton(){

    }
}
