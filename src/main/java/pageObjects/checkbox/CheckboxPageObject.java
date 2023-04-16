package pageObjects.checkbox;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPageObject extends BasePage {
    public final By checkbox1 = By.id("checkbox-1");
    public final By checkbox2 = By.id("checkbox-2");
    public final By checkbox3 = By.id("checkbox-3");
    private final WebDriver driver;

    public CheckboxPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
