package pages;

import modelBuilder.ComputeEnginePricingCalculator;
import modelBuilder.ComputeEnginePricingCalculatorBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.decorator.HighlightingDecorator;
import utils.decorator.SelectDropdownItem;

import static tests.TestSetup.logger;
import static utils.HighlightElement.highlightElement;

public class ComputeEnginePricingCalculatorPage extends PageModel {
    @FindBy(xpath = "//md-tabs-wrapper/md-tabs-canvas")
    private WebElement navigationBar;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemAndSoftware;
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement provisioningModel;
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement series;
    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineType;
    @FindBy(xpath = "(//md-checkbox[@aria-label='Add GPUs'])[1]")
    private WebElement addGPUs;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUType;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    @FindBy(xpath = "(//md-select[@placeholder='Local SSD'])[1]")
    private WebElement localSSD;
    @FindBy(xpath = "(//md-select[@placeholder='Datacenter location'])[1]")
    private WebElement datacenterLocation;
    @FindBy(xpath = "(//md-select[@placeholder='Committed usage'])[1]")
    private WebElement committedUsage;
    @FindBy(xpath = "(//button[contains(text(),'Add to Estimate')])[1]")
    private WebElement addToEstimate;
    @FindBy(id = "Email Estimate")
    private WebElement emailButton;

    public ComputeEnginePricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfInstances() {
        return Integer.parseInt(numberOfInstances.getAttribute("value"));
    }

    public String getOperatingSystemAndSoftware() {
        return operatingSystemAndSoftware.getText();
    }

    public String getProvisioningModel() {
        return provisioningModel.getText();
    }

    public String getSeries() {
        return series.getText();
    }

    public String getMachineType() {
        return machineType.getText();
    }

    public boolean getAddGPUs() {
        return Boolean.parseBoolean(addGPUs.getAttribute("aria-checked"));
    }

    public String getGPUType() {
        return GPUType.getText();
    }

    public int getNumberOfGPUs() {
        return Integer.parseInt(numberOfGPUs.getText());
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getDatacenterLocation() {
        return datacenterLocation.getText();
    }

    public String getCommittedUsage() {
        return committedUsage.getText();
    }

    public void selectTab(int tabNumber) {
        WebElement element = navigationBar.findElement(By.xpath("//md-tab-item[@id='tab-item-" + tabNumber + "']"));
        highlightElement(driver, element);
        element.click();
        logger.info("Selected tab " + element.getText() + " in the navigation bar.");
    }

    public void setNumberOfInstances(int number) {
        numberOfInstances.sendKeys("" + number);
        highlightElement(driver, numberOfInstances);
        logger.info("Number of instances: " + number + ".");
    }

    public void setOperatingSystemAndSoftware(String operatingSystem) {
        jsExec.executeScript("arguments[0].click();", operatingSystemAndSoftware);
        new HighlightingDecorator(new SelectDropdownItem()).selectItem(driver, operatingSystem);
        logger.info("Operating System / Software: " + operatingSystem + ".");
    }

    public void setProvisioningModel(String VMClass) {
        jsExec.executeScript("arguments[0].click();", provisioningModel);
        new HighlightingDecorator(new SelectDropdownItem()).selectItem(driver, VMClass);
        logger.info("Provisioning model: " + VMClass + ".");
    }

    public void setSeries(String seria) {
        jsExec.executeScript("arguments[0].click();", series);
        new HighlightingDecorator(new SelectDropdownItem()).selectItem(driver, seria);
        logger.info("Series: " + seria + ".");
    }

    public void setMachineType(String instanceType) {
        jsExec.executeScript("arguments[0].click();", machineType);
        new HighlightingDecorator(new SelectDropdownItem()).selectItem(driver, instanceType);
        logger.info("Machine type: " + instanceType + ".");
    }

    public void setAddGPUs(boolean checked) {
        if (checked && !getAddGPUs() || !checked && getAddGPUs()) {
            jsExec.executeScript("arguments[0].scrollIntoView(false);", addGPUs);
            jsExec.executeScript("window.scrollTo(0, 500)");
            jsExec.executeScript("arguments[0].click();", addGPUs);
            highlightElement(driver, addGPUs);
            logger.info("Add GPUs: " + checked + ".");
        }
    }

    public void setGPUType(String type) {
        jsExec.executeScript("arguments[0].click();", GPUType);
        new HighlightingDecorator(new SelectDropdownItem()).selectItem(driver, type);
        logger.info("GPU type: " + type + ".");
    }

    public void setNumberOfGPUs(int number) {
        jsExec.executeScript("arguments[0].click();", numberOfGPUs);
        WebElement element = numberOfGPUs.findElement(By.xpath("//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]'][@value = '" + number + "']"));
        highlightElement(driver, element);
        jsExec.executeScript("arguments[0].click();", element);
        logger.info("Number of GPUs: " + number + ".");
    }

    public void setLocalSSD(String ssd) {
        jsExec.executeScript("arguments[0].click();", localSSD);
        new HighlightingDecorator(new SelectDropdownItem()).selectItem(driver, ssd);
        logger.info("Local SSD: " + ssd + ".");
    }

    public void setDatacenterLocation(String location) {
        jsExec.executeScript("window.scrollTo(0, 500)");
        jsExec.executeScript("arguments[0].click();", datacenterLocation);
        WebElement element = driver.findElement(By.xpath("//md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']/div[contains(text(), '" + location + "')]"));
        highlightElement(driver, element);
        jsExec.executeScript("arguments[0].click();", element);
        logger.info("Datacenter location: " + location + ".");
    }

    public void setCommittedUsage(String duration) {
        jsExec.executeScript("arguments[0].scrollIntoView();", committedUsage);
        jsExec.executeScript("window.scrollTo(0, 500)");
        jsExec.executeScript("arguments[0].click();", committedUsage);
        WebElement element = driver.findElement(By.xpath("//*[@class='md-input-has-placeholder flex md-input-has-value']//div[contains(text(), '" + duration + "')]"));
//        WebElement element = driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(), '" + duration + "')]"));
        highlightElement(driver, element);
        jsExec.executeScript("arguments[0].click();", element);
        logger.info("Committed usage: " + duration + ".");
    }

    public ComputeEnginePricingCalculator clickAddToEstimate() {
        ComputeEnginePricingCalculator form = new ComputeEnginePricingCalculatorBuilder()
                .setNumberOfInstances(this.getNumberOfInstances())
                .setOperatingSystemAndSoftware(this.getOperatingSystemAndSoftware())
                .setProvisioningModel(this.getProvisioningModel())
                .setSeries(this.getSeries())
                .setMachineType(this.getMachineType())
                .setAddGPUs(this.getAddGPUs())
                .setCPUType(this.getGPUType())
                .setNumberOfGPUs(this.getNumberOfGPUs())
                .setLocalSSD(this.getLocalSSD())
                .setDatacenterLocation(this.getDatacenterLocation())
                .setCommittedUsage(this.getCommittedUsage())
                .createComputeEnginePricingCalculator();
        highlightElement(driver, addToEstimate);
        jsExec.executeScript("arguments[0].click();", addToEstimate);
        logger.info("The calculator form has been completed with the following data and submitted for estimation:\n" + form);
        return form;
    }

    public EmailYourEstimateModalForm clickEmailEstimate() {
        highlightElement(driver, emailButton);
        jsExec.executeScript("arguments[0].click();", emailButton);
        logger.info("Request to send a result by email has been submitted.");
        return new EmailYourEstimateModalForm(driver);
    }
}
