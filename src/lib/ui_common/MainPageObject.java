package lib.ui_common;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class MainPageObject {
    private MobileDriver driver;

    public MainPageObject(MobileDriver driver){
        this.driver = driver;

    }
    public void assertElementHasText(By by, String expected_text, String error_message) {
        WebElement element = waitForElement(by, "Title element is not found with parameters " + by, 5);
        String actual_text = element.getText();

        Assert.assertTrue(error_message, actual_text.contains(expected_text));
    }

    public void assertElementHasDescription(By by, String expected_text, String error_message) {
        WebElement element = waitForElement(by, "Title element is not found with parameters " + by, 5);
        String actual_text = element.getAttribute("contentDescription");

        Assert.assertTrue(error_message, actual_text.equals(expected_text));
    }

    public WebElement waitForElement(By selector, String error_message, long timeoutinseconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutinseconds);
        wait.withMessage(error_message);
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public WebElement waitForElementAndClick(By locator, String error_message, long timeoutinseconds){
        WebElement element = waitForElement(locator, error_message, timeoutinseconds);
        element.click();
        return  element;

    }
    public WebElement waitForElementAndSendKeys(By locator, String error_message, long timeoutinseconds, String keys){
        WebElement element = waitForElement(locator, error_message, timeoutinseconds);
        element. sendKeys(keys);
        return element;


    }

    public boolean waitForElementNorPresent(By selector, String error_message, long timeinseconds ){
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

    public int numberOfElements(By locator){

        int number_of_elements = driver.findElements(locator).size();
        return number_of_elements;

    }



    public void assertElementPresent(By locator, String error_message_no_title){
        if (numberOfElements(locator) == 0) {
            Assert.fail(error_message_no_title);
        }

    }

    public String getElementAttribute(By locator, String error_message,String attribute, long timeout){
        WebElement element = waitForElement(locator,error_message, timeout);
        return element.getAttribute(attribute);
    }

    public By getLocator(String locator){
        String[] divided_locator = locator.split(Pattern.quote(":"), 2);
        String by_type = divided_locator[0];
        String by_value = divided_locator[1];
        if (by_type.equals("xpath")){
            return By.xpath(by_value);
        } else if (by_type.equals("id")){
            return By.id(by_value);
        } else if (by_type.equals("name")) {
            return By.name(by_value);
        } else {
            throw new IllegalArgumentException("The locator contains neihter id nor xpath");
        }


    }
}
