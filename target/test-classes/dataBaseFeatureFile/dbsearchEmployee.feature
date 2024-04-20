Feature: data base testing via feature file

  @database
  Scenario: front-end and back-end testing
    Given user navigate to the HRM application
    When user enters valid username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user navigate to Add Employee page by first clicking on PIM button and then on Add employee button
    And user enter direct data "FIRSTbabar" and "MIDDLEbabar" and "LASTbabar"
    And capture the employee id
    And user clicks on save button
    And employee added successfully
    And query the information from bakc end
    And verify the results from ui and back end
   # And user close the browser