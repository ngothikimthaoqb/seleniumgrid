package pages.datepicker;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.datepicker.DatepickerPageObject;
import utilities.DateAndTimeUtil;

public class DatepickerPage extends BasePage {
    private final WebDriver driver;
    private DatepickerPageObject datepickerPageObject;

    public DatepickerPage(WebDriver driver) {
        this.driver = driver;
        this.datepickerPageObject = new DatepickerPageObject();
    }

    public void clickCurrentDate() {
        waitForElementUntilClickable(driver, datepickerPageObject.datepicker);
        clickToElement(driver, datepickerPageObject.datepicker);
        clickToElement(driver, datepickerPageObject.currentDay);
    }

    public String getCurrentDate() {
       return getElementValue(driver, datepickerPageObject.datepicker);
    }


}
