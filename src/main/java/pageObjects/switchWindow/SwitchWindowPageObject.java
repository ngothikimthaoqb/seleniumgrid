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

    private final WebDriver driver;

    public SwitchWindowPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToAnotherBrowser() {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        Assert.assertEquals(browserTabs.size(), 2);
        driver.switchTo().window(browserTabs .get(1));
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }
}
