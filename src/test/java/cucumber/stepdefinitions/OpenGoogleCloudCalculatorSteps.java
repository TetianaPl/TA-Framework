package cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CloudGooglePage;
import tests.TestSetup;

import static org.testng.Assert.assertEquals;

public class OpenGoogleCloudCalculatorSteps extends TestSetup {
    CloudGooglePage cloudGooglePage;

    @Given("I open Google Cloud page")
    public void i_open_google_cloud_page() {
        driver.get("https://cloud.google.com/");
        cloudGooglePage = new CloudGooglePage(driver);
    }

    @Given("I enter {string} in the search field")
    public void i_enter_in_the_search_field(String searchString) {
        cloudGooglePage.clickSearch();
        cloudGooglePage.enterSearchQuery("Google Cloud Platform Pricing Calculator");

    }

    @When("I see a link with text {string} in the search results and click it")
    public void i_see_a_link_with_text_in_the_search_results_and_click_it(String string) {
        cloudGooglePage.findInSearchResults("Google Cloud Pricing Calculator");
    }

    @Then("The Google Cloud Calculator page opens")
    public void the_google_cloud_calculator_page_opens() {
        String expectedURL = "https://cloud.google.com/products/calculator";
        assertEquals(driver.getCurrentUrl(), expectedURL);
    }


}
