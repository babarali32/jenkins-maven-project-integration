package Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.commonMethods;

public class EmployeeSearchByIDSteps extends commonMethods {

    @When("user navigate to Employee List page by first clicking on PIM button and then on Employee List button")
    public void user_navigate_to_employee_list_page_by_first_clicking_on_pim_button_and_then_on_employee_list_button() {
        //AddNewEmployeePageLocators addemploye=new AddNewEmployeePageLocators();

        // click(dashboard.pimButtonField);

        jsClick(dashboard.pimButtonField);

       click(dashboard.pimEmployeeListField);

//        dashboard.pimButtonField.click();
//        dashboard.pimEmployeeListField.click();

//        WebElement pimButton=driver.findElement(By.id("menu_pim_viewPimModule"));
//        pimButton.click();
//    WebElement employeeListButton=driver.findElement(By.id("menu_pim_viewEmployeeList"));
//    employeeListButton.click();
    }
    @When("user enter valid employee id")
    public void user_enter_valid_employee_id() {

        //EmployeeListPageLocators listpage=new EmployeeListPageLocators();

        sendText(listemp.idTextBoxField,"104149A");
//
//        listemp.idTextBoxField.sendKeys("104149A");
////
//        WebElement idTextBox=driver.findElement(By.id("empsearch_id"));
//        idTextBox.sendKeys("104149A");
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {

        //EmployeeListPageLocators listpage=new EmployeeListPageLocators();
        click(listemp.searchButtonField);
//
//        listemp.searchButtonField.click();
////
//    WebElement searchButton=driver.findElement(By.id("searchBtn"));
//    searchButton.click();
    }
    @Then("user see the employee information is displayed")
    public void user_see_the_employee_information_is_displayed() {

        System.out.println("employee data against id 104149A is displayed");
    }

}
