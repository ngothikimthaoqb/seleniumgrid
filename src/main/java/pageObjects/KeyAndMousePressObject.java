package pageObjects;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyAndMousePressObject extends BasePage {
    private final WebDriver driver;

    public final By fullNameInput = By.xpath("//input[@id='name']");

    public  final By button = By.id("button");

    public KeyAndMousePressObject(WebDriver driver) {
        this.driver = driver;
    }


}
