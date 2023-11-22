package lib.ui_android;

import io.appium.java_client.MobileDriver;
import lib.ui_common.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {

    public AndroidNavigationUI(MobileDriver driver) {
        super(driver);
    }

    static {SAVED_ARTICLE_BUTTON = "xpath://*[@content-desc='Saved']";};
}
