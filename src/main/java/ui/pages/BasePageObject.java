package ui.pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Initializes the WebDriver, WebDriver wait and web elements.
     */
    public BasePageObject() {
        this.driver = DriverManager.getInstance().getWebDriver();
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public abstract void waitUntilPageIsLoaded() ;
}
