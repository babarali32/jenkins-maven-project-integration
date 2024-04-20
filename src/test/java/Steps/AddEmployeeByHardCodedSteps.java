package Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.commonMethods;

public class AddEmployeeByHardCodedSteps extends commonMethods {

    @When("user navigate to Add Employee page by first clicking on PIM button and then on Add employee button")
    public void user_navigate_to_add_employee_page_by_first_clicking_on_pim_button_and_then_on_add_employee_button() {
       // DashBoardPageLocators dashboard=new DashBoardPageLocators();
       click(dashboard.pimButtonField);
       click(dashboard.pimAddEmployeeField);
//
//        dashboard.pimButtonField.click();
//        dashboard.pimAddEmployeeField.click();


//        WebElement pimButton=driver.findElement(By.id("menu_pim_viewPimModule"));
//        pimButton.click();
//        WebElement PIMAddEmployeeButton=driver.findElement(By.id("menu_pim_addEmployee"));
//        PIMAddEmployeeButton.click();
    }
    @When("user enter first name and last name")
    public void user_enter_first_name_and_last_name() {
        sendText(addemp.firstnameField,"uzbakistan");
        sendText(addemp.lastnameField,"pakistan");
//
//        addemp.firstnameField.sendKeys("punjab");

//        WebElement firstNameTextBox=driver.findElement(By.id("firstName"));
//        firstNameTextBox.sendKeys("lahore");
      //  addemp.lastnameField.sendKeys("turkamanistan");

//        WebElement lastNameTextBox=driver.findElement(By.id("lastName"));
//        lastNameTextBox.sendKeys("pakistan32");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addemp.secondSaveButton);
//
//        addemp.secondSaveButton.click();

//       WebElement saveButton=driver.findElement(By.xpath("//input[@id='btnSave']"));
//       saveButton.click();
        System.out.println("this is save button step");
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Congrats! employee has been added");
    }


}
