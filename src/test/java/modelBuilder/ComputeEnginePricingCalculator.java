package modelBuilder;

public class ComputeEnginePricingCalculator {
    private int numberOfInstances;
    private String operatingSystemAndSoftware;
    private String provisioningModel;
    private String series;
    private String machineType;
    private boolean addGPUs;
    private String CPUType;
    private int numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEnginePricingCalculator(int numberOfInstances, String operatingSystemAndSoftware, String provisioningModel, String series, String machineType,
                                          boolean addGPUs, String CPUType, int numberOfGPUs, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
        this.provisioningModel = provisioningModel;
        this.series = series;
        this.machineType = machineType;
        this.addGPUs = addGPUs;
        this.CPUType = CPUType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "ComputeEnginePricingCalculator{" +
                "\nnumberOfInstances=" + numberOfInstances +
                ", \noperatingSystemAndSoftware=" + operatingSystemAndSoftware +
                ", \nprovisioningModel=" + provisioningModel +
                ", \nseries=" + series +
                ", \nmachineType=" + machineType +
                ", \naddGPUs=" + addGPUs +
                ", \nCPUType=" + CPUType +
                ", \nnumberOfGPUs=" + numberOfGPUs +
                ", \nlocalSSD=" + localSSD +
                ", \ndatacenterLocation=" + datacenterLocation +
                ", \ncommittedUsage=" + committedUsage +
                "}";
    }
}
