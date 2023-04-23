package homepage;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.checkbox.CheckboxPage;
import utilities.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Java mentoring")
@Feature("HomePage")
public class CheckboxTest extends BaseTest {
    private HomePage homePage;
    private CheckboxPage checkboxPage;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePage(driver);
        checkboxPage =  new CheckboxPage(driver);
        driver.get(pageUrl);
    }

    @Description("Test description: checkbox")
    @Story("Checkbox")
    @Test()
    public void verifySelectedCheckboxSuccessfully() {
        homePage.clickCheckbox();
        checkboxPage.clickToCheckBox1();
        checkboxPage.isCheckBox1Displayed();
        checkboxPage.clickToCheckBox2();
        checkboxPage.isCheckBox2Displayed();
        checkboxPage.clickToCheckBox3();
        checkboxPage.isCheckBox3Displayed();
    }
}
