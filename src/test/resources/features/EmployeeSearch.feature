Feature: user story us-102 Search Employee

  Background:
    Given user navigate to the HRM application
    When user enters valid username and password

    @pass   @fail
  Scenario: search employe by id
    # these lines added to background
     # Given user navigate to the HRM application
    When user enters valid username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user navigate to Employee List page by first clicking on PIM button and then on Employee List button
    And user enter valid employee id
    And user clicks on search button
    Then user see the employee information is displayed
    And user close the browser


    Scenario: search emplye be name
     # Given user navigate to the HRM application
     # When user enters valid username and password
        And user clicks on login button
        Then admin user is successfully logged in
        When user navigate to Employee List page by first clicking on PIM button and then on Employee List button
        And user enter valid employee name
        And user clicks on search button
        Then user see the employee information is displayed
        And user close the browser