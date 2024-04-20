Feature: check the functionality of drop Down

  @dropDown
  Scenario: by using hrm application
    Given user navigate to the HRM application
    When user enters valid username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user navigate to Add Employee page by first clicking on PIM button and then on Add employee button
    And user enter first name and last name
    And user clicks on save button
    And user clicks on Edit Button
    And user select the one option from martial status
    And user select the one option from nationality options
    And user click on save button
    Then employee added successfully
    And user close the browser
