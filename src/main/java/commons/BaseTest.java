package commons;

import configs.drivers.DriverConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.homepage.HomePageObject;

public class BaseTest {
    protected  WebDriver driver = null;
    protected HomePageObject homePage;
    protected Logger logger;

    protected BaseTest() {
        logger = LogManager.getLogger(getClass());
    }

    protected DriverConfig driverConfig = new DriverConfig();
    @Parameters({"pageUrl", "browserName", "platform"})
    @BeforeClass
    public void setUp(String pageUrl, String browserName, String platform) {
        logger.info("Page Url: " + pageUrl + " with browser name: " + browserName);
        System.out.println(platform +"platform");
        driver = driverConfig.getDriver(browserName, platform);
        driver.get(pageUrl);
        homePage = new HomePageObject(driver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driverConfig.quiteDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
