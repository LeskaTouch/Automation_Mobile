package lib.ui_android;

import io.appium.java_client.MobileDriver;
import lib.ui_common.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {
    public AndroidMyListsPageObject(MobileDriver driver) {
        super(driver);
    }

    static {
        SAVED_ARTICLES_FOLDER = "xpath://*[@text='Default list for your saved articles']";
        ARTICLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{ARTICLE_NAME}']";
        ARTICLE_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{ARTICLE_DESCRIPTION}']";
    }

    @Override
    public  void closeSyncPopup() {}
}
