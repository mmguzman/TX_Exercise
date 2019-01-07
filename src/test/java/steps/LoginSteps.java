package steps;

import cucumber.api.java.en.Given;
import ui.PageTransporter;
import ui.pages.MyStoreHomePage;

public class LoginSteps {
    private PageTransporter pageTransporter;

    //Pages
    private MyStoreHomePage myStoreHomePage;

    public LoginSteps() {
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Given("^I navigate to MyStore page$")
    public void navigateToMyStorePage() {
        myStoreHomePage = pageTransporter.navigateToMyStoreHomePage();
    }
}
