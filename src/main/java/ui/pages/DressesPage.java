package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DressesPage extends BasePageObject{

    @FindBy(xpath = "//h1/span[contains(text(),'Dresses')]")
    WebElement dressesPageHead;

    public String OPTION_LINK = "//*[@id='categories_block_left']//a[contains(text(),'%s')]";

    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(dressesPageHead));
    }

    /**
     * Clicks any dress according dressType
     * @param dressType
     */
    private void clickDressTypeLink(String dressType) {
        driver.findElement(By.xpath(String.format(OPTION_LINK, dressType))).click();
    }

    /**
     * Clicks the Summer Dresses link
     * @return
     */
    public SummerDressesPage clickSummerDressesLink(String dressType) {
        clickDressTypeLink(dressType);
        return new SummerDressesPage();
    }
}
