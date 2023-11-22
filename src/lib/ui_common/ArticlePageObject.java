package lib.ui_common;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import lib.ui_common.MainPageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String ARTICLE_TITLE,
    SAVE_BUTTON,
    BACK_BUTTON,
    TITLE_ATTRIBUTE_NAME;
    public ArticlePageObject(MobileDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement(){

        return waitForElement(
                getLocator(ARTICLE_TITLE),
                "Title of the article is not found",
                5);
    }

    public String getTitleText(){
        WebElement el = waitForTitleElement();
        return el.getAttribute(TITLE_ATTRIBUTE_NAME);
    }

    public void assertTitleEquals(String expected_title){
        Assert.assertEquals("The title is not as expected", getTitleText(), expected_title);
    }

    public void saveArticle(){
        waitForElementAndClick(
                getLocator(SAVE_BUTTON),
                "No 'Save' button is found",
                1);
    }

    public void clickBackButton(){
        waitForElementAndClick(
                getLocator(BACK_BUTTON),
                "No back button is found for second search", 1);
    }


}
