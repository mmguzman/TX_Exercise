package ui.pages;

import framework.selenium.UIMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SummerDressesPage extends BasePageObject{
    @FindBy(xpath = "//h1/span[contains(text(),'Summer Dresses')]")
    WebElement summerDressesPageHead;

    @FindBy(id = "selectProductSort")
    private WebElement sortByDropDown;

    @FindBy(xpath = "//a[@rel='layered_id_attribute_group_3']")
    private WebElement dressLsize;

    @FindBy(xpath = "//a[@rel='layered_id_attribute_group_16']")
    private WebElement yellowDress;

    public String DRESS_PRICE = "//ul/li[%1s]//div[2]/h5/a[@class='product-name' and @title='%2s']/following::span[@class='price product-price']";
    public String DRESS_LIST = "//ul/li[%1s]//div[2]/h5/a[@class='product-name']/following::span[@class='price product-price']";

    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(summerDressesPageHead));
    }

    /**
     * Selects the dress size
     * @param dressSize
     */
    public void selectDressSize(String dressSize) {
        By dressSizeWebElement = By.xpath("//input[@type='checkbox']/following::a[contains(text(),'" + dressSize + "')]");
        UIMethods.selectCheckBox(dressSizeWebElement);
        By enabledFilter = By.xpath("//div[@id='enabled_filters']/ul/li");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(enabledFilter, dressSize));
    }

    /**
     * Selects the color filter
     * @param colorFilter
     */
    public void selectColorFilter(String colorFilter) {
        By colorWebElement = By.xpath("//input[contains(@class,'color')]/following::a[contains(text(),'" + colorFilter + "')]");
        UIMethods.selectCheckBox(colorWebElement);
        By enabledFilter = By.xpath("//div[@id='enabled_filters']/ul/li[2]");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(enabledFilter, colorFilter));
    }

    /**
     * Selects Sorty By option according text
     * @param option
     */
    public void selectSortByOption(String option) {
        sortByDropDown.click();
        UIMethods.selectOptionDropDown(sortByDropDown, option);
    }

    /**
     * Gets the dress price according its name
     * @param dressName
     * @return
     */
    public String getDressPrice(String dressName, String position) {
        return driver.findElement(By.xpath(String.format(DRESS_PRICE, position, dressName))).getText();
    }

    /**
     * Gets a list with the Dress prices
     * @return
     */
    public List<String> getDressPriceList() {
        List<WebElement> dressList = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
        List dressPriceList = new ArrayList();
        for (int i = 1; i <= dressList.size(); i++) {
            String price = driver.findElement(By.xpath(String.format(DRESS_LIST, i))).getText().replace("$", "");
            dressPriceList.add(price);
        }
        return dressPriceList;
    }
}
