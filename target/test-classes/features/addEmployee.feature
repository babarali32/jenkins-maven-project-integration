Feature: add an employee in Syntax HRM website

  @addEmployee    # passing data hard coded data
  Scenario: add employee using feature file
    Given user navigate to the HRM application
    When user enters valid username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user navigate to Add Employee page by first clicking on PIM button and then on Add employee button
    And user enter first name and last name
    And user clicks on save button
    Then employee added successfully
    And user close the browser
    # ----------------------------------------------------------------------------------
    @exampleTable         # passing data using examples table
    Scenario Outline: add employee by passing data from example table
    Given user navigate to the HRM application
    When user enters valid username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user navigate to Add Employee page by first clicking on PIM button and then on Add employee button
    And user enter "<firstName>" and "<middleName>" and "<lastName>"
    And user clicks on save button
    Then employee added successfully
    And user close the browser
  Examples:
    |firstName|middleName |lastName |
    | abc     | middle01  |orange   |
    | xyz     |middle02   | banana  |
    | lmn     | middle03  |  apple  |
    | pqr     |middle04   | grapes  |

      #-----------------------------------------------------------------------------------------
      @withoutExampleTable      # passing data using place holder
      Scenario: add an employe without example table
        Given user navigate to the HRM application
        When user enters valid username and password
        And user clicks on login button
        Then admin user is successfully logged in
        When user navigate to Add Employee page by first clicking on PIM button and then on Add employee button
        And user enter direct data "FIRSTbabar" and "MIDDLEbabar" and "LASTbabar"
        And user clicks on save button
        Then employee added successfully
        And user close the browser
        #-------------------------------------------------------------------------------------------
      @data-Table     # passing data using data table
        Scenario: add employee by passing data through data table
        Given user navigate to the HRM application
        When user enters valid username and password
        And user clicks on login button
        Then admin user is successfully logged in
        When user navigate to Add Employee page by first clicking on PIM button and then on Add employee button
       # this below data table is applicable only for this below setp, all above setps will added to background
        And user add multiple employees and verify they are added
          | FirstName | MiddleName | LastName |
          | John      | Doe        | Smith    |
          | Alice     | Johnson    | Brown    |
          | Bob       | Garcia     | Wilson   |
          | Emma      |            | Patel    |



