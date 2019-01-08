package steps;

import com.google.common.collect.Ordering;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.pages.DressesPage;
import ui.pages.MyStoreHomePage;
import ui.pages.SummerDressesPage;
import ui.pages.WomenPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApplicationSteps {

    //Pages
    private MyStoreHomePage myStoreHomePage;
    private WomenPage womenPage;
    private DressesPage dressesPage;
    private SummerDressesPage summerDressesPage;

    public ApplicationSteps() {
        myStoreHomePage = new MyStoreHomePage();
    }

    @When("^I select \"([^\"]*)\" tab$")
    public void ISelectTab(String tabName) {
        womenPage = myStoreHomePage.getTopMenu().clickWomenTab(tabName);
    }

    @And("^I select \"([^\"]*)\" in \"([^\"]*)\" category$")
    public void iSelectInCategory(String dressesOption, String womenOption) {
        dressesPage = womenPage.clickDressesLink(womenOption);
        summerDressesPage = dressesPage.clickSummerDressesLink(dressesOption);
    }

    @And("^I select \"([^\"]*)\" size$")
    public void iSelectSize(String dressSize) {
        summerDressesPage.selectDressSize(dressSize);
    }

    @And("^I select \"([^\"]*)\" color filter$")
    public void iSelectFilter(String colorFilter) {
        summerDressesPage.selectColorFilter(colorFilter);
    }

    @And("^I select \"([^\"]*)\" in Sort By option$")
    public void iSelectInSortByOption(String option) {
        summerDressesPage.selectSortByOption(option);
    }

    @Then("^Verify that \"([^\"]*)\" is displayed with a price of \"([^\"]*)\" at \"([^\"]*)\" position$")
    public void verifyThatIsDisplayedWithAPriceOf(String dressName, String dressPrice, String position)  {
        assertEquals(dressPrice, summerDressesPage.getDressPrice(dressName, position), "The " + dressName + " is not displayed with a " + dressPrice + " price.");
    }

    @And("^Verify that the listed items have ascendant ordering by the price$")
    public void verifyThatTheListedItemsHaveAscendantOrderingByThePrice() {
        boolean isListSorted = Ordering.natural().isOrdered(summerDressesPage.getDressPriceList());
        assertTrue(isListSorted, "The list items is not sorted in ascendant order.");
    }
}
