package configs.browserOptions;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SauceLabOption {
    public Map<String, Object> getOptions(String username, String accessKey) {
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", username);
        sauceOptions.put("accessKey", accessKey);

        return sauceOptions;
    }
}
