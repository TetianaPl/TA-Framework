package tests;

import org.testng.annotations.Test;
import pages.ComputeEnginePricingCalculatorPage;

import static utils.SwitchToNestedFrame.switchToNestedFrame;
import static utils.TestDataReader.getTestData;

public class FillComputeEngineCalculatorFromPropertiesTest extends TestSetup {
    @Test
    public void fillCalculatorFormTestFromPropertiesTest() {
        logger.info("The 'fillCalculatorFormTestFromPropertiesTest' test started.");
        driver.get("https://cloud.google.com/products/calculator");
        ComputeEnginePricingCalculatorPage computeEngineCalculatorPage = new ComputeEnginePricingCalculatorPage(driver);
        switchToNestedFrame(driver);
        computeEngineCalculatorPage.selectTab(1);
        computeEngineCalculatorPage.setNumberOfInstances(Integer.parseInt(getTestData("numberOfInstances")));
        computeEngineCalculatorPage.setOperatingSystemAndSoftware(getTestData("operatingSystemAndSoftware"));
        computeEngineCalculatorPage.setProvisioningModel(getTestData("provisioningModel"));
        computeEngineCalculatorPage.setSeries(getTestData("series"));
        computeEngineCalculatorPage.setMachineType(getTestData("machineType"));
        if (Boolean.parseBoolean(getTestData("addGPUs"))) {
            computeEngineCalculatorPage.setAddGPUs(true);
            computeEngineCalculatorPage.setGPUType(getTestData("CPUType"));
            computeEngineCalculatorPage.setNumberOfGPUs(Integer.parseInt(getTestData("numberOfGPUs")));
        }
        computeEngineCalculatorPage.setLocalSSD(getTestData("localSSD"));
        computeEngineCalculatorPage.setDatacenterLocation(getTestData("datacenterLocation"));
        computeEngineCalculatorPage.setCommittedUsage(getTestData("committedUsage"));
        computeEngineCalculatorPage.clickAddToEstimate();
        logger.info("The 'fillCalculatorFormTestFromPropertiesTest' test completed.");
    }
}
