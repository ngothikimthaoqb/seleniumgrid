package commons;

public class GlobalConstants {

    public static final String CONFIG_FILE_KEY = "config";
    public static final String TEST_DATA_FILE_KEY = "testdata_test_env";
    public static final String DEV_DATA_FILE_KEY = "testdata_dev_env";
    public static final String SHORT_TIMEOUT_KEY = "short.timeout";
    public static final String LONG_TIMEOUT_KEY = "long.timeout";
    public static final String LOCAL_NODE = "local_node";
    public static final String SAUCELAB_NODE = "saucelab_node";
    public static final String USERNAME = "username";
    public static final String ACCESSKEY = "accessKey";
    public static final String OS = "os";
    public static final String OS_VERSION = "os_version";
    public static final String WINDOW_PLATFORM = "Window";
    public static final String LAST_NAME = "lastname";
    public static final String FIRST_NAME = "firstname";

    public enum ENV {
        dev, test
    }
}
