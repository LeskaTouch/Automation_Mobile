package lib.test_case;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.Platform;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public abstract class CoreTestCase extends TestCase {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    protected AppiumDriver driver;

    protected String current_platform;

    public CoreTestCase(String platform) {
        this.current_platform = platform;
    }

    @Override()
    public void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = getCapabilitiesByPlatformEnv();
        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");

        driver = getDriver(appiumServerURL, capabilities);

        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected AppiumDriver getDriver(URL appiumServerURL, DesiredCapabilities capabilities) throws Exception {
        // String platform = System.getenv("PLATFORM");
        AppiumDriver driver;
        if (current_platform.equals(PLATFORM_IOS)){
            driver = new IOSDriver(appiumServerURL, capabilities);
        } else if (current_platform.equals(PLATFORM_ANDROID)) {
            driver = new AndroidDriver(appiumServerURL, capabilities);
        } else  {
            throw new Exception();
        }

        return  driver;
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

    protected DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception{
        //String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (current_platform.equals(PLATFORM_ANDROID)){
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Pixel81");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActvity", ".`main.MainActivity`");
            capabilities.setCapability("app", "/Users/dariademskaya/Documents/JavaAppiumAutomation/JavaAppiumAutomation/apks/org.wikipedia.apk");

        } else if (current_platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability("appium:deviceName", "iPhone 14 Pro Max");
            capabilities.setCapability("appium:platformVersion", "17.0");
            capabilities.setCapability("appium:app", "/Users/dariademskaya/Documents/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia693.app");
            capabilities.setCapability("appium:automationName", "XCUITest");
            capabilities.setCapability("xcodeOrgId", "OrgId");
            capabilities.setCapability("xcodeSigningId", "SignId");

        } else {
            throw new Exception("Can not find platform");
        }

        return capabilities;

    }
}
