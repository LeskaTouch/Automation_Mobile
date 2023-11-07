package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;

    public  void setUp() throws Exception {
        super.setUp();
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

        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void tearDown() throws Exception {
        super.tearDown();
        driver.quit();
    }
    public void rotateLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void rotatePortrate(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
}
