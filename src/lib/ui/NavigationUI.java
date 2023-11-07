package lib.ui;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    private static final String SAVED_ARTICLE_BUTTON = "//*[@content-desc='Saved']";
    public NavigationUI(MobileDriver driver){
        super(driver);
    }

    public void clickSavedArticles(){
        waitForElementAndClick(
                By.xpath(SAVED_ARTICLE_BUTTON),
                "No Saved button on the main screen is found",
                5);
    }

}
