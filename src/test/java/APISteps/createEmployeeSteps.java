package APISteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIconstants;
import utils.APIpayloadConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;

public class createEmployeeSteps {
    public static RequestSpecification request;
    public static Response response;
    public static String empID;

    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {
        request = RestAssured.given().header(APIconstants.HEADER_CONTENT_TYPE, APIconstants.CONTENT_VALUE)
                .header(APIconstants.HEADER_AUTHORIZATION, generateTokenSteps.token)
                .body(APIpayloadConstants.CREATE_PAYLOAD);

    }

    @When("a post method is used to create an employee")
    public void a_post_method_is_used_to_create_an_employee() {
        response = request.when().post(APIconstants.CREATE_EMPLOYEE_BASE_URI);

    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer statuscode) {
        response.then().assertThat().statusCode(statuscode);

    }

    @Then("the created employee should contain a {string} and value {string}")
    public void the_created_employee_should_contain_a_and_value(String message, String created) {
        response.then().assertThat().body(message, equalTo(created));
        response.prettyPrint();

    }

    @Then("we need employee id {string} is stored as global variables")
    public void we_need_employee_id_is_stored_as_global_variables(String employe_id) {
        empID = response.jsonPath().getString(employe_id);
        System.out.println(empID);
    }

    //---------------------------------------------------------------------------
    @Given("a request is made to get the data of created employee")
    public void a_request_is_made_to_get_the_data_of_created_employee() {
        request = RestAssured.given().header(APIconstants.HEADER_CONTENT_TYPE, APIconstants.CONTENT_VALUE)
                .header(APIconstants.HEADER_AUTHORIZATION, generateTokenSteps.token)
                .queryParam("employee_id", empID);
    }

    @When("a get method of HTTP is used to get created employee")
    public void a_get_method_of_http_is_used_to_get_created_employee() {
        response = request.when().get(APIconstants.GET_ONE_EMPLOYEE_BASE_URI);

    }

    @Then("the status code of getting employe is {int}")
    public void the_status_code_of_getting_employe_is(int staTusCoDe) {
        response.then().assertThat().statusCode(staTusCoDe);

    }

    @Then("the id {string} of getting employee should match with global id")
    public void the_id_of_getting_employee_should_match_with_global_id(String oneemployeID) {
        String oneID = response.jsonPath().getString(oneemployeID);
        Assert.assertEquals(oneID, empID);

    }

    @Then("the retrieved data of object {string} should match with created employee id {string}")
    public void the_retrieved_data_of_object_should_match_with_created_employee_id
            (String employeeObject, String responseid, DataTable dataTable) {
        List<Map<String, String>> expectData = dataTable.asMaps(String.class, String.class);

        Map<String, String> actualData = response.body().jsonPath().get(employeeObject);

        for (Map<String, String> map : expectData
        ) {
            Set<String> keys = map.keySet();
            for (String key : keys) {
                String expectedvalue = map.get(key);
                String actualvalues = actualData.get(key);
                Assert.assertEquals(expectedvalue, actualvalues);

            }
        }
        String empid = response.body().jsonPath().getString(responseid);
        Assert.assertEquals(empid, empID);
    }
    //----------------------------------------------------------------------
    // provide boyd via json payload

    @Given("a request is prepared for creating an employee using json payload")
    public void a_request_is_prepared_for_creating_an_employee_using_json_payload() {
        request = RestAssured.given().header(APIconstants.HEADER_CONTENT_TYPE, APIconstants.CONTENT_VALUE)
                .header(APIconstants.HEADER_AUTHORIZATION, generateTokenSteps.token)
                .body(APIpayloadConstants.createEmployeByjsonObject());

    }
    //------------------------------------------------------------------------------------
    // provide values in feature file, highly dynamic data

    @Given("a request is prepared for creating an employee with dynamic data {string} ,{string},{string},{string},{string},{string},{string}")
    public void a_request_is_prepared_for_creating_an_employee_with_dynamic_data
            (String emp_firstname, String emp_lastname, String emp_middle_name,
             String emp_gender, String emp_birthday, String emp_status, String emp_job_title) {

        request = RestAssured.given().header(APIconstants.HEADER_CONTENT_TYPE, APIconstants.CONTENT_VALUE)
                .header(APIconstants.HEADER_AUTHORIZATION, generateTokenSteps.token)
                .body(APIpayloadConstants.dynamicBody(emp_firstname, emp_lastname,emp_middle_name,
                        emp_gender, emp_birthday, emp_status,emp_job_title));
    }
    //------------------------------------------------------------------------------------
    //  code for updating the employee body

    @Given("a request is made  for updating the existing empoyee")
    public void a_request_is_made_for_updating_the_existing_empoyee() {
        request = RestAssured.given().header(APIconstants.HEADER_CONTENT_TYPE, APIconstants.CONTENT_VALUE)
                .header(APIconstants.HEADER_AUTHORIZATION, generateTokenSteps.token)
                .body(APIpayloadConstants.updateEmployeeBody());
    }
    @When("a put call is made to update the employee")
    public void a_put_call_is_made_to_update_the_employee() {
        response=request.when().put(APIconstants.UPDATE_EMPLOYEE_BASE_URI);
    }
    @Then("the status code for updating an employee is {int}")
    public void the_status_code_for_updating_an_employee_is(int sTatusCoDe) {

        response.then().assertThat().statusCode(sTatusCoDe);

    }


}
