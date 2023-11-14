package lib.ui_android;
import io.appium.java_client.MobileDriver;
import lib.ui_common.MainPageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String ARTICLE_TITLE= "xpath://*[@resource-id='pcs']//*[@class='android.view.View'][1]//*[@class='android.view.View'][1]";
    private static final String SAVE_BUTTON = "id:org.wikipedia:id/page_save";
    private static final String BACK_BUTTON = "xpath://*[@content-desc='Navigate up']";
    public ArticlePageObject(MobileDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement(){

        return waitForElement(
                getLocator(ARTICLE_TITLE),
                "Title of the article is not found",
                15);
    }

    public String getTitleText(){
        return waitForTitleElement().getAttribute("contentDescription");
    }

    public void assertTitleEquals(String expected_title){
        Assert.assertEquals("The title is not as expected", getTitleText(), expected_title);
    }

    public void saveArticle(){
        waitForElementAndClick(
                getLocator(SAVE_BUTTON),
                "No 'Save' button is found",
                5);
    }

    public void clickBackButton(){
        waitForElementAndClick(
                getLocator(BACK_BUTTON),
                "No back button is found for second search",
                5);
    }


}
