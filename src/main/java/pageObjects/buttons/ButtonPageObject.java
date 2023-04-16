package pageObjects.buttons;

import commons.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonPageObject extends BasePage {
    public final By primaryButton = By.xpath("//button[text()='Primary']");
    public final By successButton = By.xpath("//button[text()='Success']");
    public final By infoButton = By.xpath("//button[text()='Info']");
    public final By dangerButton = By.xpath("//button[text()='Danger']");

    private final WebDriver driver;

    public ButtonPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
