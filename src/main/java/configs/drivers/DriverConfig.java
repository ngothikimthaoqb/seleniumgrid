package configs.drivers;

import commons.GlobalConstants;
import configs.browserOptions.ChromeOption;
import configs.browserOptions.FirefoxOption;
import configs.browserOptions.SauceLabOption;
import configs.browsers.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverConfig {

    protected static WebDriver driver;

    public DriverConfig() {}


    public static WebDriver getDriver(String browserName, String platformName) {
        BrowserName browserNameEnum = BrowserName.valueOf(browserName.toUpperCase());
        PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);
        boolean isWindowPlatform = platformName.equals(GlobalConstants.WINDOW_PLATFORM.toString());
        String node = isWindowPlatform ? propertyReader.getValue(GlobalConstants.LOCAL_NODE) + "/wd/hub" :
                propertyReader.getValue(GlobalConstants.SAUCELAB_NODE) + "/wd/hub";

        if (driver == null) {
            String username = propertyReader.getValue(GlobalConstants.USERNAME);
            String accessKey = propertyReader.getValue(GlobalConstants.ACCESSKEY);
            String os = propertyReader.getValue(GlobalConstants.OS);
            String os_version = propertyReader.getValue(GlobalConstants.OS_VERSION);
            Map<String, Object> getOptions = new SauceLabOption().getOptions(username, accessKey);

            switch (browserNameEnum) {
                case CHROME:
                    try {
                        driver = new RemoteWebDriver(new URL(node),
                                isWindowPlatform ? DesiredCapabilities.chrome():
                                        new ChromeOption().getOptions(os, os_version, getOptions));

                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case FIREFOX:
                    try {
                        driver = new RemoteWebDriver(new URL(node),
                                isWindowPlatform ? DesiredCapabilities.firefox():
                                        new FirefoxOption().getOptions(os, os_version, getOptions));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Please check the browser name again!");
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(propertyReader.getValue(GlobalConstants.SHORT_TIMEOUT_KEY)), TimeUnit.SECONDS);

        return driver;
    }

    public  void quiteDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }
}