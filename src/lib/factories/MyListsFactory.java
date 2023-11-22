package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;

import lib.ui_android.AndroidMyListsPageObject;

import lib.ui_common.MyListsPageObject;
import lib.ui_ios.IosMyListsPageObject;

public class MyListsFactory {
    public static MyListsPageObject get(AppiumDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosMyListsPageObject(driver);
        } else

        {
            return new AndroidMyListsPageObject(driver);
        }

    }
}
