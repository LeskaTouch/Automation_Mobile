import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        capabilities.setCapability("deviceName", "Pixel5");
        capabilities.setCapability("platformVersion", "8.0");
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

    public void assertElementHasText(By by, String expected_text, String error_message) {
      WebElement element = driver.findElement(by);
      String actual_text = element.getText();
      Assert.assertTrue(error_message, actual_text.contains(expected_text));
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




}
