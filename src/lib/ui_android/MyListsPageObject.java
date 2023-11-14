package lib.ui_android;

import io.appium.java_client.MobileDriver;
import lib.ui_common.MainPageObject;

public class MyListsPageObject extends MainPageObject {
    private static final String SAVED_ARTICLES_FOLDER = "xpath://*[@text='Default list for your saved articles']";
    private static final String ARTICLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{ARTICLE_NAME}']";
    private static final String ARTICLE_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{ARTICLE_DESCRIPTION}']";
    public MyListsPageObject(MobileDriver driver){
        super(driver);

    }

    public void openSavedArticlesFolder(){
        waitForElementAndClick(
                getLocator(SAVED_ARTICLES_FOLDER),
                "No saved articles are found",
                5);

    }

    public void swipeByArticleToDelete(String article_name){
        swipeToTheLeft(
                getLocator(getArticleName(article_name)),
                "No article with" +article_name + "is found to swipe");
    }

    private String getArticleName(String article_name){
        return ARTICLE.replace("{ARTICLE_NAME}", article_name);


    }
    private String getArticleDescription(String article_description){
        return ARTICLE_DESCRIPTION.replace("{ARTICLE_DESCRIPTION}", article_description);

    }

    public void clickArticleDescription(String article_description){
        waitForElementAndClick(
                getLocator(getArticleDescription(article_description)),
                "Article with" + article_description + "is not present",
                5);
    }

}
