Feature: work flow for syntax api hrm

  Background:
    Given a JWT Bearer token is generated
   @API
   Scenario: generate the token
   # Given a JWT Bearer token is generated
   @getdata
   @createEmployee
   # Given a JWT Bearer token is generated
    Scenario: create an employee via API work flow
    Given a request is prepared for creating an employee
    When a post method is used to create an employee
    Then the status code for creating an employee is 201
     And the created employee should contain a "Message" and value "Employee Created"
     And we need employee id "Employee.employee_id" is stored as global variables

     @getdata
    Scenario: retrieving the created employee by using id
       # Given a JWT Bearer token is generated
      Given a request is made to get the data of created employee
      When a get method of HTTP is used to get created employee
      Then the status code of getting employe is 200
      And the id "employee.employee_id" of getting employee should match with global id
       And the retrieved data of object "employee" should match with created employee id "employee.employee_id"
       |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
       |kawait       |Russia      |ireland        |Male         | 2020-04-05|chill      | Trump       |

    @json
   # Given a JWT Bearer token is generated
    Scenario: create an employee via API work flow using json
    Given a request is prepared for creating an employee using json payload
    When a post method is used to create an employee
    Then the status code for creating an employee is 201
    And the created employee should contain a "Message" and value "Employee Created"
    And we need employee id "Employee.employee_id" is stored as global variables

      @dynamic
      Scenario: create highly dynamic scenario
        Given a request is prepared for creating an employee with dynamic data "babar" ,"ahemd","usman","M","2020-04-05","unemployeed","CEO"
        When a post method is used to create an employee
        Then the status code for creating an employee is 201
        And the created employee should contain a "Message" and value "Employee Created"
        And we need employee id "Employee.employee_id" is stored as global variables

        @updateBody
        Scenario:  update the employee using API call
          Given a request is made  for updating the existing empoyee
          When a put call is made to update the employee
          Then the status code for updating an employee is 200