package lib.test_case;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.factories.WelcomePageFactory;
import org.openqa.selenium.ScreenOrientation;

public abstract class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override()
    public void setUp() throws Exception {
        super.setUp();

        driver = Platform.getInstance().getDriver();
        driver.rotate(ScreenOrientation.PORTRAIT);
        skipWelcomePage();
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

    public void skipWelcomePage(){
        WelcomePageFactory.get(driver).clickSkipButton();
    }
}
