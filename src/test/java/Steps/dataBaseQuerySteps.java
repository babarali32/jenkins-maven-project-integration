package Steps;

import io.cucumber.java.en.When;
import utils.dbUtils;
import utils.globalVariables;

public class dataBaseQuerySteps {
    @When("query the information from bakc end")
    public void query_the_information_from_bakc_end() {

        String query="select * from hs_hr_employees where employee_id='"+ globalVariables.dataBaseEmpID+"'";
         globalVariables.tableDaTA=dbUtils.gettabledata(query);

    }
}
