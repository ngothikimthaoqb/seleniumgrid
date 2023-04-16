package homepage;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.buttons.ButtonPageObject;
import pageObjects.checkbox.CheckboxPageObject;
import pageObjects.homepage.HomePageObject;

public class CheckboxTest extends BaseTest {
    private HomePageObject homePage;
    private CheckboxPageObject checkboxPage;
    SoftAssert softAssert;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePageObject(driver);
        checkboxPage =  new CheckboxPageObject(driver);
        softAssert = new SoftAssert();
        driver.get(pageUrl);
    }

    @Test()
    public void verifySelectedCheckboxSuccessfully() {
        homePage.clickToElement(driver, homePage.checkbox);
        checkboxPage.clickToElement(driver, checkboxPage.checkbox1);
        Assert.assertTrue(checkboxPage.isElementDisplayed(driver, checkboxPage.checkbox1));
        checkboxPage.clickToElement(driver, checkboxPage.checkbox2);
        Assert.assertTrue(checkboxPage.isElementDisplayed(driver, checkboxPage.checkbox2));
        checkboxPage.clickToElement(driver, checkboxPage.checkbox3);
        Assert.assertTrue(checkboxPage.isElementDisplayed(driver, checkboxPage.checkbox3));
    }
}
