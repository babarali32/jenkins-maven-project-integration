package Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.commonMethods;

public class EmployeeSearchByNameSteps extends commonMethods {

    @When("user enter valid employee name")
    public void user_enter_valid_employee_name() {
       // EmployeeListPageLocators listpage=new EmployeeListPageLocators();
        sendText(listemp.nameSearchField,"Captain ms");

       // listemp.nameSearchField.sendKeys("Captain ms");

//        WebElement nameTextBox=driver.findElement(By.id("empsearch_employee_name_empName"));
//        nameTextBox.sendKeys("Captain ms");
    }
    @Then("user close the browser")
    public void user_close_the_browser() {
        closeBrowser();
    }

}
