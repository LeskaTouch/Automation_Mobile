package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;
import lib.ui_android.AndroidArticlePageObject;
import lib.ui_android.AndroidSearchPageObject;
import lib.ui_common.ArticlePageObject;
import lib.ui_common.SearchPageObject;
import lib.ui_ios.IosArticlePageObject;
import lib.ui_ios.IosSearchPageObject;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(AppiumDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosArticlePageObject(driver);
        } else

        {
            return new AndroidArticlePageObject(driver);
        }

    }
}
