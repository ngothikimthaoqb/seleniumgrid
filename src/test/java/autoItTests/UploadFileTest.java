package autoItTests;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.homepage.HomePageObject;

import java.io.IOException;

public class UploadFileTest extends BaseTest {

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePageObject(driver);
        driver.get(pageUrl);
    }

    @Test()
    public void uploadFileTest() throws IOException {
        homePage.clickToElement(driver, homePage.fileUpload);
        homePage.clickToElement(driver, By.xpath("//button[text()='Choose']"));
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\java\\autoItTests\\upload.exe");
        homePage.staticWait(20);
        Assert.assertEquals(".gitconfig", homePage.getElementText(driver, By.id("file-upload-field")));
    }

}
