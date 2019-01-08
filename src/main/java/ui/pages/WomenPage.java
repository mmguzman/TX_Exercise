package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WomenPage extends BasePageObject{

    @FindBy(xpath = "//h1/span[contains(text(),'Women')]")
    WebElement womenPageHead;

    public String OPTION_LINK = "//*[@id='categories_block_left']//a[contains(text(),'%s')]";


    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(womenPageHead));
    }

    /**
     * Clicks any option according optionName
     * @param optionName
     */
    private void clickOptionLink(String optionName) {
        driver.findElement(By.xpath(String.format(OPTION_LINK, optionName))).click();
    }

    /**
     * Clicks the Dresses link
     * @return
     */
    public DressesPage clickDressesLink(String optionName) {
        clickOptionLink(optionName);
        return new DressesPage();
    }
}
