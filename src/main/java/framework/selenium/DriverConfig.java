package framework.selenium;

import utils.JsonReader;

import java.io.File;

public class DriverConfig {

    private static final String configFilePath = System.getProperty("user.dir") + File.separator  + "config.json";
    private JsonReader configReader;
    private String browser;
    private int implicitWait;
    private int explicitWait;
    private int waitSleep;

    private static DriverConfig instance;

    protected DriverConfig() {
        initialize();
    }

    public static DriverConfig getInstance() {
        if(instance == null) {
            instance = new DriverConfig();
        }
        return instance;
    }

    private void initialize() {
        configReader = new JsonReader(this.configFilePath);

        //Get the browser
        String browserSelect = System.getProperty("browserName");
        if (browserSelect == null) {
            browser = configReader.getKeyValue("web driver", "browser");
        }
        else {
            browser = browserSelect;
        }

        //Read WebDriver settings
        implicitWait = Integer.valueOf(configReader.getKeyValue("web driver", "implicit wait"));
        explicitWait = Integer.valueOf(configReader.getKeyValue("web driver", "explicit wait"));
        waitSleep = Integer.valueOf(configReader.getKeyValue("web driver", "wait sleep"));
    }

    public String getBrowser() {
        return browser;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

    public int getExplicitWait() {
        return explicitWait;
    }

    public int getWaitSleep() {
        return waitSleep;
    }
}
