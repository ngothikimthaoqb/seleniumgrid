package pages.checkbox;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.checkbox.CheckboxPageObject;

public class CheckboxPage extends BasePage {
    private final WebDriver driver;
    private CheckboxPageObject checkboxPageObject;

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
        this.checkboxPageObject =  new CheckboxPageObject(driver);
    }

    public void clickToCheckBox1(){
       clickToElement(driver, checkboxPageObject.checkbox1);
    }

    public void clickToCheckBox2(){
        clickToElement(driver, checkboxPageObject.checkbox2);
    }

    public void clickToCheckBox3(){
        clickToElement(driver, checkboxPageObject.checkbox3);
    }

    public boolean isCheckBox1Displayed() {
        return isElementDisplayed(driver, checkboxPageObject.checkbox1);
    }

    public boolean isCheckBox2Displayed() {
        return  isElementDisplayed(driver, checkboxPageObject.checkbox2);
    }

    public boolean isCheckBox3Displayed() {
        return  isElementDisplayed(driver, checkboxPageObject.checkbox3);
    }
}
