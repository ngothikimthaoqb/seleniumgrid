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
import pages.HomePage;
import pages.switchWindow.SwitchWindowPage;
import utilities.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Java mentoring")
@Feature("HomePage")
public class SwitchWindowTest  extends BaseTest {
    private HomePage homePage;
    private SwitchWindowPage switchWindowPage;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePage(driver);
        switchWindowPage =  new SwitchWindowPage(driver);
        driver.get(pageUrl);
    }

    @Description("Test description: switch To Window Successfully")
    @Story("Switch Window")
    @Test
    public  void switchToWindowSuccessfully() {
        homePage.clickSwitchWindow();
        switchWindowPage.clickNewTabButton();
        switchWindowPage.switchToAnotherBrowser();
        Assert.assertEquals(switchWindowPage.getPageTitle(driver), "Formy");
        Assert.assertEquals("a", "b");
    }

    @Description("Test description: open Alert Successfully")
    @Story("Switch Window")
    @Test
    public  void openAlertSuccessfully() {
        homePage.clickSwitchWindow();
        switchWindowPage.clickAlertButton();
        if(switchWindowPage.isAlertPresent(driver)) {
            switchWindowPage.acceptAlert(driver);
        }
        else {
            logger.error("The alert is not displayed");
        }
    }
}
