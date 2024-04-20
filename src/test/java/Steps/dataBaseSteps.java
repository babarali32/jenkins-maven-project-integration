 package Steps;

 import Pages.AddNewEmployeePageLocators;
 import io.cucumber.java.en.When;
 import org.junit.Assert;
 import utils.commonMethods;
 import utils.globalVariables;

 public class dataBaseSteps extends commonMethods {

    @When("capture the employee id")
    public void capture_the_employee_id() {
        AddNewEmployeePageLocators ads=new AddNewEmployeePageLocators();
        globalVariables.dataBaseEmpID=ads.captureId.getAttribute("value");
        globalVariables.firstName=ads.firstnameField.getAttribute("value");
        System.out.println("the Captured id is " + globalVariables.dataBaseEmpID);
    }

    @When("verify the results from ui and back end")
    public void verify_the_results_from_ui_and_back_end() {
        String firstnameformDB=globalVariables.tableDaTA.get(0).get("emp_firstname");
        System.out.println("first name from db "+firstnameformDB);
        System.out.println("first name from GUI "+globalVariables.firstName);

        Assert.assertEquals(firstnameformDB,globalVariables.firstName);
    }
}
