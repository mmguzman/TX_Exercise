package framework.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private DriverConfig driverConfig = DriverConfig.getInstance();
    private WebDriver driver;
    private WebDriverWait wait;

    private static DriverManager instance = null;

    protected DriverManager() {
        initialize();
    }

    public static DriverManager getInstance() {
        if (instance == null || instance.driver == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Initializes the WebDriver, WebDriver wait and opens the browser.
     */
    private void initialize() {
        if (driverConfig.getBrowser().equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (driverConfig.getBrowser().equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (driverConfig.getBrowser().equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(driverConfig.getExplicitWait(), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, driverConfig.getExplicitWait(), driverConfig.getWaitSleep());
    }

    /**
     * Gets the WebDriver
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Gets the WebDriver wait
     */
    public WebDriverWait getWait() {
        return wait;
    }

    public int getImplicitWait() {
        return driverConfig.getImplicitWait();
    }

    /**
     * Close the browser
     */
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
