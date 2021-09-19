Feature: xfinity internet speed and deals Scenarios

  Background:
    Given a user is on the Home Page


  @internet_speed_options
  Scenario: User is shown recommended internet speed upon selecting device and usage options
    When User navigates to internet page
    And Selects the device and usage options
    Then User should see recommended internet speed


  @internet_deals_options
  Scenario: user can compare internet deals for specified location
    When User navigates to all deals page
    And Provides location and selects two deals
    |address                                    |street         |unit |zipcode|
    |740 CLOPPER ROAD, GAITHERSBURG, MD 20878   |740 Clopper RD |11   |20878  |
    Then User can compare deals

