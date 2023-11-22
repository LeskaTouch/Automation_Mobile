package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;
import lib.ui_android.AndroidSearchPageObject;
import lib.ui_android.AndroidWelcomePage;
import lib.ui_common.SearchPageObject;
import lib.ui_common.WelcomePageObject;
import lib.ui_ios.IosSearchPageObject;
import lib.ui_ios.IosWelcomePage;

public class WelcomePageFactory {
    public static WelcomePageObject get(AppiumDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosWelcomePage(driver);
        } else

        {
            return new AndroidWelcomePage(driver);
        }


    }

}
