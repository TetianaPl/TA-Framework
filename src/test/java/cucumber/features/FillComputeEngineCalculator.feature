Feature: Fill Compute Engine Calculator

  Background: Setup browser
    Given I start the edge browser

  @RegularTest
  Scenario Outline: Fill Compute Engine Calculator
    Given I open Google Cloud Calculator page
    And I open Compute Engine Calculator tab
    And I enter numberOfInstances as <numberOfInstances>
    And I enter operatingSystemAndSoftware as <operatingSystemAndSoftware>
    And I enter provisioningModel as <provisioningModel>
    And I enter series as <series>
    And I enter machineType as <machineType>
    And I enter addGPUs as <addGPUs>
    And I enter CPUType as <CPUType>
    And I enter numberOfGPUs as <numberOfGPUs>
    And I enter localSSD as <localSSD>
    And I enter datacenterLocation as <datacenterLocation>
    And I enter committedUsage as <committedUsage>
    When I submit Compute Engine Calculator form
    Then Estimated Monthly Cost is <estimatedMonthlyCost>

    Examples:
      | numberOfInstances | operatingSystemAndSoftware             | provisioningModel | series | machineType     | addGPUs | CPUType           | numberOfGPUs | localSSD | datacenterLocation | committedUsage | estimatedMonthlyCost |
      | 2                 | "Free: Debian, CentOS, CoreOS, Ubuntu" | "Regular"         | "N1"   | "n1-standard-2" | "true"  | "NVIDIA Tesla T4" | 2            | "3x375"  | "Columbus"         | "3 Years"      | 610.62               |
      | 4                 | "Free: Debian, CentOS, CoreOS, Ubuntu" | "Regular"         | "N1"   | "n1-standard-8" | "true"  | "NVIDIA Tesla T4" | 1            | "2x375"  | "Frankfurt"        | "1 Year"       | 1840.40              |