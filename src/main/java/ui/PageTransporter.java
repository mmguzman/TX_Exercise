package ui;

import framework.selenium.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ui.pages.MyStoreHomePage;

public class PageTransporter {
    private Logger log = Logger.getLogger(getClass());
    private WebDriver driver = DriverManager.getInstance().getWebDriver();

    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
        log.info("Initialize Page Transporter");
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public MyStoreHomePage navigateToMyStoreHomePage()  {
        goToURL("http://automationpractice.com/index.php");
        return new MyStoreHomePage();
    }
}
