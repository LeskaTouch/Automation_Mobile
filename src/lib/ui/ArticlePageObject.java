package lib.ui;
import io.appium.java_client.MobileDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String ARTICLE_TITLE_XPATH = "//*[@resource-id='pcs']//*[@class='android.view.View'][1]//*[@class='android.view.View'][1]";
    private static final String SAVE_BUTTON_XPATH = "//*[@resource-id='org.wikipedia:id/page_save']";
    private static final String BACK_BUTTON_XPATH = "//*[@content-desc='Navigate up']";
    public ArticlePageObject(MobileDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement(){

        return waitForElement(
                By.xpath(ARTICLE_TITLE_XPATH),
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
                By.xpath(SAVE_BUTTON_XPATH),
                "No 'Save' button is found",
                5);
    }

    public void clickBackButton(){
        waitForElementAndClick(
                By.xpath(BACK_BUTTON_XPATH),
                "No back button is found for second search",
                5);
    }


}
