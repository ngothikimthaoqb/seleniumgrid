package configs.browserOptions;

import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class FirefoxOption {

    public FirefoxOptions getOptions(String OS, String OS_Version, Map<String, Object> sauceOptions) {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("OS", OS );
        options.setCapability("OS_version",OS_Version );
        options.setCapability("sauce:options", sauceOptions);

        return options;
    }
}
