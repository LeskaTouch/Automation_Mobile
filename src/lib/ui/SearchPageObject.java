package lib.ui;

import io.appium.java_client.MobileDriver;
import org.omg.CORBA.INTERNAL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject {

    private static final String INIT_SEARCH_ELEMENT_XPATH = "//*[@resource-id='org.wikipedia:id/search_container']";
    private static final String SEARCH_ELEMENT_XPATH = "//*[@resource-id='org.wikipedia:id/search_src_text']";
    private static final String SEARCH_RESULTS_XPATH = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']";
    private static final String CLEAR_BUTTON_XPATH = "org.wikipedia:id/search_close_btn";
    private static final String SEARCH_RESULT_ITEM_TITLE_XPATH = "(//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title'])[{ORDER}]";
    private static final String ARTICLE_NAME_XPATH_TEMPLATE = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text = '{TITLE}']";

    private static final String ARTICLE_TITLE_AND_DESCRIPTION_XPATH = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup'][*[@text = '{DESCRIPTION}'] and *[@text='{TITLE}']]";


    public SearchPageObject(MobileDriver driver){
        super(driver);
    };

    public void initSearchElement(){
        waitForElementAndClick(By.xpath(INIT_SEARCH_ELEMENT_XPATH),
                "No search field is found",
                5);

    };

    public void typeSearchLine(String search_line){
        waitForElementAndSendKeys(
                By.xpath(SEARCH_ELEMENT_XPATH),
                "No tapped search field is found",
                5,
                search_line);

    }

    public void waitSearchResultList(){
        waitForElement(
                By.xpath(SEARCH_RESULTS_XPATH),
                "No results",
                5);


    }

    public void clearSearch(){
        waitForElementAndClick(
                By.id(CLEAR_BUTTON_XPATH),
                "Search is not closed",
                5);
    }

    public void waitCloseButtonIsNotPresent(){
        waitForElementNorPresent(
                By.id(CLEAR_BUTTON_XPATH),
                "Close button is present",
                5);

    }

    public void assertSearchResultHasText(String expected_text, int item_order){
        assertElementHasText(
                By.xpath(getSearchResultItemTitleXpath(item_order)),
                expected_text,
                expected_text + " is not present in each line");
    }



    public void clickArticleName(String article_id){
        String article_xpath = getArticleNameXpath(article_id);

        waitForElementAndClick(
                By.xpath(article_xpath),
                "No article is found for: " + article_id,
                5);

    }


    public WebElement waitForElementByTitleAndDescription(String title, String description) {
        return waitForElement(
                By.xpath(getSearchResultItemByTitleAndDescription(title, description)),
                "No article with TITLE " + title + " and DESCRIPTION " + description + " is found",
                5);
    }

    // TEMPLATES METHODS
    private String getSearchResultItemTitleXpath(int order){
        return SEARCH_RESULT_ITEM_TITLE_XPATH.replace("{ORDER}", Integer.toString(order));
    }
    private String getArticleNameXpath(String title){
        return ARTICLE_NAME_XPATH_TEMPLATE.replace("{TITLE}", title);

    }

    private String getSearchResultItemByTitleAndDescription(String title, String description){
        return  ARTICLE_TITLE_AND_DESCRIPTION_XPATH.replace("{TITLE}", title).replace ("{DESCRIPTION}", description);
    }
    // TEMPLATES METHODS

}
