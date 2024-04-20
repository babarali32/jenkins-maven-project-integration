

  Feature: dash board tabs showing to the admin user

    @dashboard
    Scenario: verify dash board functionality
      Given user navigate to the HRM application
      When user enters valid username and password
      And user clicks on login button
      Then admin user is successfully logged in
      And verify all the tabs are visible to the user
      |Admin|PIM|Configuration|Employee List|Add Employee|Reports|Leave|Time|Recruitment|Performance|Dashboard|Directory|

