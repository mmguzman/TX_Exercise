package ui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePageObject;
import ui.pages.WomenPage;

public class TopMenu extends BasePageObject {
    public String OPTION_LINK = "//a[contains(text(),'%s')]";

    @Override
    public void waitUntilPageIsLoaded() {

    }

    /**
     * Clicks any tab according tabName
     * @param tabName
     */
    private void clickTab(String tabName) {
        driver.findElement(By.xpath(String.format(OPTION_LINK, tabName))).click();
    }

    /**
     * Clicks the Women tab
     * @param tabName
     * @return
     */
    public WomenPage clickWomenTab(String tabName) {
        clickTab(tabName);
        return new WomenPage();
    }
}
