package homepage;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.checkbox.CheckboxPageObject;
import pageObjects.datepicker.DatepickerPageObject;
import pageObjects.homepage.HomePageObject;
import utilities.DateAndTimeUtil;

public class DatePickerTest extends BaseTest {
    private HomePageObject homePage;
    private DatepickerPageObject datepickerPage;
    SoftAssert softAssert;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePageObject(driver);
        datepickerPage =  new DatepickerPageObject(driver);
        softAssert = new SoftAssert();
        driver.get(pageUrl);
    }

    @Test()
    public void verifySelectedDatepickerSuccessfully() {
        homePage.clickToElement(driver, homePage.datepicker);
        datepickerPage.waitForElementUntilClickable(driver, datepickerPage.datepicker);
        datepickerPage.clickToElement(driver, datepickerPage.datepicker);
        datepickerPage.clickToElement(driver, datepickerPage.currentDay);
        Assert.assertEquals(datepickerPage.getElementValue(driver, datepickerPage.datepicker), DateAndTimeUtil.getCurrentDate());
    }
}
