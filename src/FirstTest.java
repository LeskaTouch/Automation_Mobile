import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

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

    public void assertElementHasText(By by, String expected_text, String error_message) {
      WebElement element = driver.findElement(by);
      String actual_text = element.getText();
      Assert.assertEquals(error_message, expected_text, actual_text);
    }


}
