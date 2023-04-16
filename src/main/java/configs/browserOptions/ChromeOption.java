package configs.browserOptions;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class ChromeOption {

    public ChromeOptions getOptions(String OS, String OS_Version, Map<String, Object> sauceOptions) {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("OS", OS );
        options.setCapability("OS_version",OS_Version );
        options.setCapability("sauce:options", sauceOptions);

        return options;
    }
}
