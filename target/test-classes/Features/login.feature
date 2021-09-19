Feature: Login Scenarios

  Background:
    Given a user is on the Home Page


  @login_negative_test_with_invalid_credentials
  Scenario Outline: Login is unsuccessful with invalid credentials
    When User navigates to login page and enters username "<userName>" and password "<password>"
    And Click on the Sign In button
    Then User should get an error message

    Examples:
      | userName | password |
      | me       | 1234     |

  @login_negative_test_with_username
  Scenario: Login is unsuccessful with invalid user and blank password
    When User navigates to login page and enters username "they" only
    And Click on the Sign In button
    Then User is shown password field error and failed to login

  @login_negative_test_with_password
  Scenario: Login is unsuccessful with blank user and invalid password
    When User navigates to login page and enters password "they" only
    And Click on the Sign In button
    Then User is shown user field error and failed to login

  @login_negative_test_with_blank_username_and_blank_password
  Scenario: Login is unsuccessful with blank user and blank password
    When User navigates to login page
    And Click on the Sign In button
    Then User is shown user field error and password field error and failed to login


