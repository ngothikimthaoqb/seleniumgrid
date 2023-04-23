package pageObjects.switchWindow;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SwitchWindowPageObject extends BasePage {
    public final By newTabButton = By.id("new-tab-button");
    public final By alertButton = By.id("alert-button");
}
