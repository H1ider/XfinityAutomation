Feature: SiteMap and nearby stores scenarios

  Background:
    Given a user is on the Home Page


  @Sitemap_visibility
  Scenario: User is shown the Sitemap and FindAStore option upon navigating to Sitemap link
    When User navigates to SiteMap
    Then User should see Site map and FindAStore option


  @Find_A_Store_near_location_dataTable
  Scenario: User is given nearby stores information upon entering location
    When User navigates to SiteMap
    And Navigates to Find A Store tab
    Then User should see nearby store information upon entering location
    |location     |storename            |
    |Rockville,MD |31 Grand Corner Ave  |


  @Find_A_Store_near_location_parameterized
  Scenario Outline: User is given nearby stores information upon entering location parameterized
    When User navigates to SiteMap
    And Navigates to Find A Store tab
    Then User can use location "<location>" to find out nearby store "<storeName>"

    Examples:
      |location        |storeName            |
      |Sterling, VA    |20453 Exchange St    |
      |Frederick, MD   |1700 Kingfisher Drive|

