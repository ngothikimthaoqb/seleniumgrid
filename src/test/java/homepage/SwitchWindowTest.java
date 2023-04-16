package homepage;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.homepage.HomePageObject;
import pageObjects.switchWindow.SwitchWindowPageObject;
import utilities.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Java mentoring")
@Feature("HomePage")
public class SwitchWindowTest  extends BaseTest {
    private HomePageObject homePage;
    private SwitchWindowPageObject switchWindowPage;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePageObject(driver);
        switchWindowPage =  new SwitchWindowPageObject(driver);
        driver.get(pageUrl);
    }

    @Description("Test description: switch To Window Successfully")
    @Story("Switch Window")
    @Test
    public  void switchToWindowSuccessfully() {
        homePage.clickToElement(driver, homePage.switchWindow);
        switchWindowPage.clickToElement(driver, switchWindowPage.newTabButton);
        switchWindowPage.switchToAnotherBrowser();
        Assert.assertEquals(switchWindowPage.getPageTitle(driver), "Formy");
        Assert.assertEquals("a", "b");
    }

    @Description("Test description: open Alert Successfully")
    @Story("Switch Window")
    @Test
    public  void openAlertSuccessfully() {
        homePage.clickToElement(driver, homePage.switchWindow);
        switchWindowPage.clickToElement(driver, switchWindowPage.alertButton);
        if(switchWindowPage.isAlertPresent(driver)) {
            switchWindowPage.acceptAlert(driver);
        }
        else {
            logger.error("The alert is not displayed");
        }
    }
}
