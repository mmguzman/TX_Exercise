package framework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIMethods {
    private WebDriver driver;
    private WebDriverWait wait;

    public UIMethods() {
        this.driver = DriverManager.getInstance().getWebDriver();
        this.wait = DriverManager.getInstance().getWait();
    }
    /**
     * Selects a checkbox using WebElement
     * @param checkBox
     */
    public static void selectCheckBox(WebElement checkBox) {
        WebDriverWait wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOf(checkBox));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    /**
     * Selects a checkbox using By
     * @param by
     */
    public static void selectCheckBox(By by) {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        WebElement element = driver.findElement(by);
        selectCheckBox(element);
    }

    /**
     * Selects an option from DropDown according text
     * @param element
     * @param option
     */
    public static void selectOptionDropDown(WebElement element, String option) {
        new Select(element).selectByVisibleText(option);
    }
}
