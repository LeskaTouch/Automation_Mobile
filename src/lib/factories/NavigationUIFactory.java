package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;

import lib.ui_android.AndroidNavigationUI;

import lib.ui_common.NavigationUI;

import lib.ui_ios.IosNavigationUI;

public class NavigationUIFactory {
    public static NavigationUI get(AppiumDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosNavigationUI(driver);
        } else

        {
            return new AndroidNavigationUI(driver);
        }

    }
}

