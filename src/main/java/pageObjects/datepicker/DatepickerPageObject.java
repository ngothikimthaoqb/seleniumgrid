package pageObjects.datepicker;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatepickerPageObject extends BasePage {
    public final By datepicker = By.id("datepicker");

    public final By currentDay = By.xpath("//*[contains(@class, 'today day')]");
    private final WebDriver driver;

    public DatepickerPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
