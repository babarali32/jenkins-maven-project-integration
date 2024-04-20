Feature: login feature
    Background:
    Given user navigate to the HRM application

  @smoke @regression @fail
  Scenario: valid admin logins
  #  Given user navigate to the HRM application    --this will use by hook, no need for this
    When user enters valid username and password
    And user clicks on login button
    Then admin user is successfully logged in
    And user close the browser
  @loginNormaluser
  # now login as a norma user or as a guest
  Scenario: login as a normal user
  #  Given user navigate to the HRM application
    When user enters valid normal username and password
    And user clicks on login button
    Then normal user is successfully logged in as a guest
    And user close the browser
  @negative
  Scenario Outline: login with negative data
    When user enter different "<usernameValue>" and "<passwordValue>" and verify "<errorValue>" message
    Examples:
      | usernameValue | passwordValue | errorValue               |
      | Admin         | xyz           | Invalid credentials      |
      | abc           | Hum@nhrm123   | Invalid credentials      |
      | Admin         |               | Password is Empty |
      |               | Hum@nhrm123   | Username cannot be empty |