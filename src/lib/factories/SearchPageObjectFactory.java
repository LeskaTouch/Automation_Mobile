package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;
import lib.ui_android.AndroidSearchPageObject;
import lib.ui_common.SearchPageObject;
import lib.ui_ios.IosSearchPageObject;

public class SearchPageObjectFactory {
    public static SearchPageObject get(AppiumDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosSearchPageObject(driver);
        } else

        {
            return new AndroidSearchPageObject(driver);
        }


    }
}
