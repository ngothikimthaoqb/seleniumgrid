package homepage;

import commons.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.KeyAndMousePressObject;
import pageObjects.homepage.HomePageObject;

public class KeyAndMousePressTest extends BaseTest {
    private HomePageObject homePage;
    private KeyAndMousePressObject keyAndMousePressPage;


    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePageObject(driver);
        keyAndMousePressPage =  new KeyAndMousePressObject(driver);
        driver.get(pageUrl);
    }

    @Test
    public void keyboardActionTest() {
        System.out.println("Thread Id: " +  Thread.currentThread().getId());
        homePage.clickToElementByJavaScript(driver, homePage.keyAndMousePress);
        keyAndMousePressPage.sendKeyToElement(driver, keyAndMousePressPage.fullNameInput, "NGO");
        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.SPACE)
                .sendKeys("KIM")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.SPACE)
                .sendKeys("THAO")
                .perform();

        String fullNameExpected = "NGO KIM THAO";
        Assert.assertEquals(fullNameExpected,
                keyAndMousePressPage.getElementValue(driver, keyAndMousePressPage.fullNameInput));
    }

    @Test
    public void mouseActionTest() {
        System.out.println("Thread Id: " +  Thread.currentThread().getId());
        homePage.clickToElementByJavaScript(driver, homePage.keyAndMousePress);
        keyAndMousePressPage.hoverToElement(driver, keyAndMousePressPage.button);
        String backgroundExpected = "rgba(0, 107, 221, 1)";
        Assert.assertEquals(backgroundExpected,
                keyAndMousePressPage.getCssValue(driver, keyAndMousePressPage.button, "background-color"));
    }

    @Test
    public void JavascriptExecutorTest() {
        System.out.println("Thread Id: " +  Thread.currentThread().getId());
       Assert.assertEquals(keyAndMousePressPage.getPageTitle(driver),
               keyAndMousePressPage.getTitleByJavaScript(driver));

       keyAndMousePressPage.scrollByJavaScript(driver);
       Assert.assertTrue(keyAndMousePressPage.isElementDisplayed(driver, homePage.completeWebForm));
    }
}
