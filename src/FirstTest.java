import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel81");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActvity", ".`main.MainActivity`");
        capabilities.setCapability("app", "/Users/dariademskaya/Documents/JavaAppiumAutomation/JavaAppiumAutomation/apks/org.wikipedia.apk");

        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(appiumServerURL, capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void myTest() {
        assertElementHasText(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']"),
                "Search Wikipedia",
                "Search input contains incorrect text");
    }

    @Test
    public void mySecondTest(){
        WebElement search_element = waitForElement(By.id("org.wikipedia:id/search_container"), "Search element is not found", 5);
        search_element.click();
        WebElement search_second_element = waitForElement(By.id("org.wikipedia:id/search_src_text"), "Second input is not found", 5);
        search_second_element.sendKeys("Java");
        WebElement result_search = waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']"), "No results", 5);
        WebElement close_search = waitForElement(By.id("org.wikipedia:id/search_close_btn"), "Search is not closed", 5);
        close_search.click();
        Boolean close_search_not_present = waitForElementNorPresent(By.id("org.wikipedia:id/search_close_btn"), "x is present", 5);

    }

    @Test
    public void myThirdTest(){
        WebElement search_element = waitForElement(By.id("org.wikipedia:id/search_container"), "Search element is not found", 5);
        search_element.click();

        WebElement search_second_element = waitForElement(By.id("org.wikipedia:id/search_src_text"), "Second input is not found", 5);
        search_second_element.sendKeys("Java");

        waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']"), "No results", 20);

        assertElementHasText(
                By.xpath("(//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title'])[1]"),
                "Java",
                "Java is not present in each line");

        assertElementHasText(
                By.xpath("(//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title'])[2]"),
                "Java",
                "Java is not present in each line");

        assertElementHasText(
                By.xpath("(//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title'])[3]"),
                "Java",
                "Java is not present in each line");

        assertElementHasText(
                By.xpath("(//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title'])[4]"),
                "Java",
                "Java is not present in each line");

        assertElementHasText(
                By.xpath("(//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title'])[5]"),
                "Java",
                "Java is not present in each line");

        assertElementHasText(
                By.xpath("(//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title'])[6]"),
                "Java",
                "Java is not present in each line");

    }

    @Test public void saveToArticles(){
        WebElement search_field = waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/search_container']"), "No search field is found", 10);
        search_field.click();

        WebElement tap_search_field = waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/search_src_text']"), "No tapped search field is found", 10);
        tap_search_field.sendKeys("Nadal");

        WebElement element_in_list = waitForElement(By.xpath("//*[@text = 'Rafael Nadal']"), "No such article is found", 10);
        element_in_list.click();

        WebElement save_button = waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"), "No 'Save' button is found", 10);
        save_button.click();

        WebElement back_first = waitForElement(By.xpath("//*[@content-desc='Navigate up']"), "No back button is found", 10);
        back_first.click();

        WebElement close_element = waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/search_close_btn']"), "No close button is found", 5);
        close_element.click();

        WebElement tap_search_field_second_time = waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/search_src_text']"), "No tapped search field is found for second search", 5);
        tap_search_field_second_time.sendKeys("Federer");

        WebElement element_in_list_second_search = waitForElement(By.xpath("//*[@text='Roger Federer']"), "No result found for second search", 5);
        element_in_list_second_search.click();

        WebElement save_button_second_search = waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"), "No 'Save' button is found to sve the second article", 5);
        save_button_second_search.click();

        WebElement back_first_second_article = waitForElement(By.xpath("//*[@content-desc='Navigate up']"), "No back button is found for second search", 5);
        back_first_second_article.click();

        WebElement back_second_second_article = waitForElement(By.xpath("//*[@content-desc='Navigate up']"), "No second back button is found for second search", 5);
        back_second_second_article.click();

        WebElement saved_element_main_page = waitForElement(By.xpath("//*[@content-desc='Saved']"), "No Saved button on the main screen is found", 5);
        saved_element_main_page.click();

        WebElement saved_articles = waitForElement(By.xpath("//*[@text='Default list for your saved articles']"), "No saved articles are found", 5);
        saved_articles.click();

        swipeToTheLeft(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Rafael Nadal']"), "No article to swipe");

        WebElement second_article_present = waitForElement(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']"), "Second article is not present", 5);
        second_article_present.click();

        String title_selector = "//*[@resource-id='pcs']//*[@content-desc='Roger Federer']";
        waitForElement(By.xpath(title_selector), " Title of the article is not found", 10);

        assertElementHasText(By.xpath(title_selector), "Roger Federer", "Title is not as expected");
    }

    public void assertElementHasText(By by, String expected_text, String error_message) {
      WebElement element = waitForElement(by, "Title element is not found with parameters " + by, 5);
      String actual_text = element.getAttribute("contentDescription");

      Assert.assertTrue(error_message, actual_text.equals(expected_text));
    }

    private WebElement waitForElement(By selector, String error_message, long timeoutinseconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutinseconds);
        wait.withMessage(error_message);
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    private boolean waitForElementNorPresent(By selector, String error_message, long timeinseconds ){
        WebDriverWait wait = new WebDriverWait(driver,timeinseconds);
        wait.withMessage(error_message);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    public void swipeToTheLeft(By locator, String error_to_show){
        WebElement element_to_swipe = waitForElement(locator, error_to_show, 10 );
        int x_left = element_to_swipe.getLocation().x;
        int y_top = element_to_swipe.getLocation().y;
        int y_bottom = y_top+element_to_swipe.getSize().height;
        int x_right = x_left+element_to_swipe.getSize().width;
        int y_middle = (y_bottom+y_top)/2;
       TouchAction action = new TouchAction(driver);
       action.press(x_right-10,y_middle).waitAction(150).moveTo(x_left+10,y_middle).release().perform();
    }
}
