package homepage;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pages.HomePage;
import pages.KeyAndMousePressPage;
import utilities.PropertyReader;
import utilities.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Java mentoring")
@Feature("HomePage")
public class KeyAndMousePressTest extends BaseTest {
    private HomePage homePage;
    private KeyAndMousePressPage keyAndMousePressPage;


    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePage(driver);
        keyAndMousePressPage =  new KeyAndMousePressPage(driver);
        driver.get(pageUrl);
    }

    @Description("Test description: keyboard action")
    @Story("Key And Mouse Press")
    @Test
    @Parameters({"env"})
    public void keyboardActionTest(String env) {
        String lastname, firstname;
        PropertyReader propertyReader;
        if(env == GlobalConstants.ENV.test.toString()) {
            propertyReader = new PropertyReader("testdata/" + GlobalConstants.TEST_DATA_FILE_KEY);
        }
        else {
            propertyReader = new PropertyReader("testdata/" + GlobalConstants.DEV_DATA_FILE_KEY);
        }
        lastname = propertyReader.getValue(GlobalConstants.LAST_NAME);
        firstname = propertyReader.getValue(GlobalConstants.FIRST_NAME);
        homePage.clickKeyAndMousePress();
        keyAndMousePressPage.inputToFullName(lastname, firstname);
        String fullNameExpected = lastname + " " + firstname;
        Assert.assertEquals(fullNameExpected, keyAndMousePressPage.getFullNameInput());
    }

    @Description("Test description: mouse action")
    @Story("Key And Mouse Press")
    @Test
    public void mouseActionTest() {
        homePage.clickKeyAndMousePress();
        keyAndMousePressPage.moveToMouseButton();
    }

    @Description("Test description: JavaScript Executor")
    @Story("Key And Mouse Press")
    @Test
    public void JavascriptExecutorTest() {
       Assert.assertEquals(keyAndMousePressPage.getPageTitle(driver),
               keyAndMousePressPage.getTitleByJavaScript(driver));
       keyAndMousePressPage.scrollByJavaScript(driver);
       Assert.assertTrue(homePage.isCompleteWebFormDisplayed());
    }
}
