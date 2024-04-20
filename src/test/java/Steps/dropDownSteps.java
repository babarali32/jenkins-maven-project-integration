package Steps;

import io.cucumber.java.en.When;
import utils.commonMethods;

public class dropDownSteps extends commonMethods {

    @When("user clicks on Edit Button")
    public void user_clicks_on_edit_button() {
        click(addemp.editButton);
    }
    @When("user select the one option from martial status")
    public void user_select_the_one_option_from_martial_status() {
       selectDropDown(addemp.martialStatusDropdown,"Other");
    }
    @When("user select the one option from nationality options")
    public void user_select_the_one_option_from_nationality_options() {
       selectDropDown(addemp.nationalityDropdown,"Pakistani");
    }
    @When("user click on save button")
    public void user_click_on_save_button() {
        click(addemp.secondSaveButton);
    }

}
