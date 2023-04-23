package pages.switchWindow;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.switchWindow.SwitchWindowPageObject;

import java.util.ArrayList;
import java.util.List;

public class SwitchWindowPage extends BasePage {
    private WebDriver driver;
    private SwitchWindowPageObject switchWindowPageObject;

    public SwitchWindowPage(WebDriver driver) {
        this.driver = driver;
        this.switchWindowPageObject = new SwitchWindowPageObject();
    }

    public void switchToAnotherBrowser() {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        Assert.assertEquals(browserTabs.size(), 2);
        driver.switchTo().window(browserTabs .get(1));
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    public void clickNewTabButton() {
        clickAndHighLightToElement(driver, switchWindowPageObject.newTabButton);
    }

    public void clickAlertButton() {
        clickAndHighLightToElement(driver, switchWindowPageObject.alertButton);
    }
}
