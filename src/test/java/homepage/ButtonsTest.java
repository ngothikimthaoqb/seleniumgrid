package homepage;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.buttons.ButtonPageObject;
import pageObjects.homepage.HomePageObject;
import utilities.listeners.TestListener;

@Listeners({TestListener.class})

public class ButtonsTest extends BaseTest {

    private HomePageObject homePage;
    private ButtonPageObject buttonPage;
    SoftAssert softAssert;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePageObject(driver);
        buttonPage =  new ButtonPageObject(driver);
        softAssert = new SoftAssert();
        driver.get(pageUrl);
    }

    @Test()
    public void verifyButtonsDisplayed() {
        homePage.clickToElement(driver, homePage.button);
        softAssert.assertEquals(buttonPage.getElementText(driver, buttonPage.primaryButton), "Primary");
        softAssert.assertEquals(buttonPage.getElementText(driver, buttonPage.dangerButton), "Danger");
        softAssert.assertEquals(buttonPage.getElementText(driver, buttonPage.infoButton), "Info");
        softAssert.assertEquals(buttonPage.getElementText(driver, buttonPage.successButton), "Success");
        softAssert.assertAll();
    }
}
