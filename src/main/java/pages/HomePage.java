package pages;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;

public class HomePage extends BasePage {
    private final WebDriver driver;
    private HomePageObject homePageObject;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.homePageObject = new HomePageObject();
    }

    public void clickButton() {
        clickToElement(driver, homePageObject.button);
    }

    public void clickCheckbox() {
        clickToElement(driver, homePageObject.checkbox);
    }

    public void clickDatepicker() {
        clickToElement(driver, homePageObject.datepicker);
    }

    public void clickKeyAndMousePress() {
        clickToElementByJavaScript(driver, homePageObject.keyAndMousePress);
    }

    public boolean isCompleteWebFormDisplayed() {
        return isElementDisplayed(driver, homePageObject.completeWebForm);
    }

    public void clickSwitchWindow() {
        clickAndHighLightToElement(driver, homePageObject.switchWindow);
    }

    public void clickFileUpload() {
        clickToElement(driver, homePageObject.fileUpload);
    }

}
