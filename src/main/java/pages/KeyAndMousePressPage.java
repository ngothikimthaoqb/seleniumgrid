package pages;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.KeyAndMousePressObject;

public class KeyAndMousePressPage extends BasePage {
    private final WebDriver driver;
    private KeyAndMousePressObject keyAndMousePressObject;

    public KeyAndMousePressPage(WebDriver driver) {
        this.driver = driver;
        this.keyAndMousePressObject = new KeyAndMousePressObject();
    }

    public void inputToFullName(String firstname, String lastname) {
        sendKeyToElement(driver, keyAndMousePressObject.fullNameInput, firstname);
        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.SPACE)
                .sendKeys(lastname)
                .perform();
    }

    public String getFullNameInput() {
        return getElementValue(driver, keyAndMousePressObject.fullNameInput);
    }

    public void moveToMouseButton() {
        moveToElement(driver, keyAndMousePressObject.button);
    }

    public String getBackgroundMouseButton() {
        return  getCssValue(driver, keyAndMousePressObject.button, "background-color");
    }
}
