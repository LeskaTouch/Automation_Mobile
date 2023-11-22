package lib.test_case;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String URL_ANDROID ="http://127.0.0.1:4723/wd/hub";
    private static final String URL_IOS = "http://127.0.0.1:4723";
    private static final String PLATFORM = "PLATFORM";

    private static Platform instance;

    private Platform() {}

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }

        return instance;
    }


    protected DesiredCapabilities getCapabilitiesAndroid() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Pixel81");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("platformVersion", "8.1");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActvity", ".`main.MainActivity`");
            capabilities.setCapability("app", "/Users/dariademskaya/Documents/JavaAppiumAutomation/JavaAppiumAutomation/apks/org.wikipedia.apk");

        return capabilities;


    }

    protected DesiredCapabilities getCapabilitiesIos() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:deviceName", "iPhone 14 Pro Max");
            capabilities.setCapability("appium:platformVersion", "17.0");
            capabilities.setCapability("appium:app", "/Users/dariademskaya/Documents/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia693.app");
            capabilities.setCapability("appium:automationName", "XCUITest");
            capabilities.setCapability("xcodeOrgId", "OrgId");
            capabilities.setCapability("xcodeSigningId", "SignId");

        return capabilities;


    }

    protected AppiumDriver getDriver() throws Exception {

        if (isIOS()){
            return new IOSDriver<>(new URL(URL_IOS), getCapabilitiesIos());
        }

        if (isAndroid()) {
            return new AndroidDriver<>(new URL(URL_ANDROID), getCapabilitiesAndroid());
        }

        throw new Exception();

    }

    public boolean isAndroid() {
        return getPlatform().equals(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return getPlatform().equals(PLATFORM_IOS);

    }

    public String getPlatform(){
        return System.getenv(PLATFORM);
    }


}
