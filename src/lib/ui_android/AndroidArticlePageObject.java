package lib.ui_android;

import io.appium.java_client.MobileDriver;
import lib.ui_common.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    public AndroidArticlePageObject(MobileDriver driver){

        super(driver);
    }

    static {
        ARTICLE_TITLE = "xpath://*[@resource-id='pcs']//*[@class='android.view.View'][1]//*[@class='android.view.View'][1]";
        SAVE_BUTTON = "id:org.wikipedia:id/page_save";
        BACK_BUTTON = "xpath://*[@content-desc='Navigate up']";
        TITLE_ATTRIBUTE_NAME = "contentDescription";
    }
}
