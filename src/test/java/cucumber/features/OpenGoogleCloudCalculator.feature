Feature: Open Google Cloud Calculator

  Background: Setup browser
    Given I start the edge browser

  Scenario: Open Google Cloud Calculator Page
    Given I open Google Cloud page
    And I enter "Google Cloud Platform Pricing Calculator" in the search field
    When I see a link with text "Google Cloud Pricing Calculator" in the search results and click it
    Then The Google Cloud Calculator page opens