package lib.ui;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{
    private static final String SAVED_ARTICLES_FOLDER_XPATH = "//*[@text='Default list for your saved articles']";
    private static final String ARTICLE_XPATH = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{ARTICLE_NAME}']";
    private static final String ARTICLE_DESCRIPTION_XPATH = "//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{ARTICLE_DESCRIPTION}']";
    public MyListsPageObject(MobileDriver driver){
        super(driver);

    }

    public void openSavedArticlesFolder(){
        waitForElementAndClick(
                By.xpath(SAVED_ARTICLES_FOLDER_XPATH),
                "No saved articles are found",
                5);

    }

    public void swipeByArticleToDelete(String article_name){
        swipeToTheLeft(
                By.xpath(getArticleName(article_name)),
                "No article with" +article_name + "is found to swipe");
    }

    private String getArticleName(String article_name){
        return ARTICLE_XPATH.replace("{ARTICLE_NAME}", article_name);


    }
    private String getArticleDescription(String article_description){
        return ARTICLE_DESCRIPTION_XPATH.replace("{ARTICLE_DESCRIPTION}", article_description);

    }

    public void clickArticleDescription(String article_description){
        waitForElementAndClick(
                By.xpath(getArticleDescription(article_description)),
                "Article with" + article_description + "is not present",
                5);
    }

}
