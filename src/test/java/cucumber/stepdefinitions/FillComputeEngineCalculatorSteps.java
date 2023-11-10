package cucumber.stepdefinitions;

import driverSingletone.DriverManagement;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ComputeEnginePricingCalculatorPage;
import tests.TestSetup;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static utils.ReadCalculationResult.readResult;
import static utils.SwitchToNestedFrame.switchToNestedFrame;

public class FillComputeEngineCalculatorSteps extends TestSetup {
    String browser;
    ComputeEnginePricingCalculatorPage computeEngineCalculatorPage;

    @Given("^I start the (chrome|edge|firefox) browser$")
    public void i_start_the_browser(String browser) {
        this.browser = browser;
        driver = DriverManagement.getDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("*********Background");
    }

    @Given("I open Google Cloud Calculator page")
    public void i_open_google_cloud_calculator_page() {
        driver.get("https://cloud.google.com/products/calculator");
    }

    @Given("I open Compute Engine Calculator tab")
    public void i_open_compute_engine_calculator_tab() {
        computeEngineCalculatorPage = new ComputeEnginePricingCalculatorPage(driver);
        switchToNestedFrame(driver);
        computeEngineCalculatorPage.selectTab(1);
    }

    @Given("I enter numberOfInstances as {int}")
    public void i_enter_number_of_instances_as(int numberOfInstances) {
        this.computeEngineCalculatorPage.setNumberOfInstances(numberOfInstances);
    }

    @Given("I enter operatingSystemAndSoftware as {string}")
    public void i_enter_operating_system_and_software_as(String operatingSystemAndSoftware) {
        this.computeEngineCalculatorPage.setOperatingSystemAndSoftware(operatingSystemAndSoftware);
    }

    @Given("I enter provisioningModel as {string}")
    public void i_enter_provisioning_model_as(String provisioningModel) {
        this.computeEngineCalculatorPage.setProvisioningModel(provisioningModel);
    }

    @Given("I enter series as {string}")
    public void i_enter_series_as(String series) {
        this.computeEngineCalculatorPage.setSeries(series);
    }

    @Given("I enter machineType as {string}")
    public void i_enter_machine_type_as(String machineType) {
        this.computeEngineCalculatorPage.setMachineType(machineType);
    }

    @Given("I enter addGPUs as {string}")
    public void i_enter_add_gp_us_as(String addGPUs) {
        this.computeEngineCalculatorPage.setAddGPUs(Boolean.parseBoolean(addGPUs));
    }

    @Given("I enter CPUType as {string}")
    public void i_enter_cpu_type_as(String CPUType) {
        this.computeEngineCalculatorPage.setGPUType(CPUType);
    }

    @Given("I enter numberOfGPUs as {int}")
    public void i_enter_number_of_gp_us_as(int numberOfGPUs) {
        this.computeEngineCalculatorPage.setNumberOfGPUs(numberOfGPUs);
    }

    @Given("I enter localSSD as {string}")
    public void i_enter_local_ssd_as(String localSSD) {
        this.computeEngineCalculatorPage.setLocalSSD(localSSD);
    }

    @Given("I enter datacenterLocation as {string}")
    public void i_enter_datacenter_location_as(String datacenterLocation) {
        this.computeEngineCalculatorPage.setDatacenterLocation(datacenterLocation);
    }

    @Given("I enter committedUsage as {string}")
    public void i_enter_committed_usage_as(String committedUsage) {
        this.computeEngineCalculatorPage.setCommittedUsage(committedUsage);
    }

    @When("I submit Compute Engine Calculator form")
    public void i_submit_compute_engine_calculator_form() {
        this.computeEngineCalculatorPage.clickAddToEstimate();
    }

    @Then("Estimated Monthly Cost is {double}")
    public void estimated_monthly_cost_is(double estimatedMonthlyCost) {
        double resultFromCalculatorForm = readResult(driver, "calculatorForm");
        logger.info("result from Calculator form = " + resultFromCalculatorForm);
        assertEquals(resultFromCalculatorForm, estimatedMonthlyCost);
    }

    @After()
    public void tearDown() {
        DriverManagement.closeDriver();
        System.out.println("**********************After in steps ");
    }
}
