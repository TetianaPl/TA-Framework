package modelBuilder;

import pages.ComputeEnginePricingCalculatorPage;

public class ComputeEnginePricingCalculatorBuilder {
    private int numberOfInstances;
    private String operatingSystemAndSoftware;
    private String provisioningModel;
    private String series;
    private String machineType;
    private boolean addGPUs;
    private String cpuType;
    private int numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEnginePricingCalculatorBuilder() {
    }

    public ComputeEnginePricingCalculatorBuilder setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setOperatingSystemAndSoftware(String operatingSystemAndSoftware) {
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setSeries(String series) {
        this.series = series;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setMachineType(String machineType) {
        this.machineType = machineType;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setAddGPUs(boolean addGPUs) {
        this.addGPUs = addGPUs;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setCPUType(String cpuType) {
        this.cpuType = cpuType;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setNumberOfGPUs(int numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
        return this;
    }

    public ComputeEnginePricingCalculatorBuilder setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
        return this;
    }

    public ComputeEnginePricingCalculator createComputeEnginePricingCalculator() {
        return new ComputeEnginePricingCalculator(numberOfInstances, operatingSystemAndSoftware, provisioningModel, series, machineType, addGPUs, cpuType, numberOfGPUs, localSSD, datacenterLocation, committedUsage);
    }
}