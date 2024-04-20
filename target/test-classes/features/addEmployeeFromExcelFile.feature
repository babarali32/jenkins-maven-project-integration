Feature: add employee to Hrm application

    @excelFile
    Scenario: add employee by using excel file
    Given user navigate to the HRM application
    When user enters valid username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user navigate to Add Employee page by first clicking on PIM button and then on Add employee button
    And user add multiple employees from excel file having sheet name "babar" and verify added employees
      And user close the browser
