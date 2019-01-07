package runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.selenium.DriverManager;
import org.testng.annotations.AfterTest;

public class RunCukesTest extends AbstractTestNGCucumberTests {

    @AfterTest
    public void afterExecution() {
        DriverManager.getInstance().quitDriver();
    }
}
