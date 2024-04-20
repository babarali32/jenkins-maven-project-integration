package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedAPIExample {
      String baseuri= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
     String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTIyODYxNTEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcxMjMyOTM1MSwidXNlcklkIjoiNjU5MCJ9.yeQmIIQZpqUKp3ZQak2GgPWZ-2o3zGbsiXoQhpPXmtk";
      public static String empID;
      @Test
    public void bGetEmployee() {
          //baseuri is not directly linked with response and request specification but internally linked with both
          System.out.println(empID);
          RequestSpecification preparedRequest = given().header("Content-Type", "application/json")
                  .header("Authorization", token)
                  .queryParam("employee_id", empID);
          Response response = preparedRequest.when().get("/getOneEmployee.php");
          //System.out.println(response.asString());
          response.prettyPrint();

          response.then().assertThat().statusCode(200);
          String actual = response.jsonPath().getString("employee.employee_id");
          System.out.println(actual);
          if (actual != null) {
              response.then().assertThat().body("employee.employee_id", equalTo(empID));
              boolean confirm = actual.contentEquals(empID);
              Assert.assertTrue(confirm);
          }  else {Assert.fail("Expected employee ID not found in the response");}

      }
    @Test
    public void aCreateEmployee(){
        RequestSpecification prepare=given().header("Content-Type","application/json").header("Authorization",token)
                .body("{\n" +
                        "  \"emp_firstname\": \"russian\",\n" +
                        "  \"emp_lastname\": \"ukraine\",\n" +
                        "  \"emp_middle_name\": \"america\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2020-04-04\",\n" +
                        "  \"emp_status\": \"fresh\",\n" +
                        "  \"emp_job_title\": \"CEO\"\n" +
                        "}");
        Response res=prepare.when().post("/createEmployee.php");
        res.prettyPrint();
        // thi will store employee id in the form of string
        // String empID =res.jsonPath().getString("Employee.employee_id");

        empID =res.jsonPath().getString("Employee.employee_id");
        System.out.println(empID);

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body("Employee.emp_lastname",equalTo("ukraine"));
        res.then().assertThat().body("Message",equalTo("Employee Created"));
        res.then().assertThat().header("Server",equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));
    }
    @Test
    public void cUpdateEmployee(){
          RequestSpecification prepareRequest=given().header("Content-Type","application/json")
                  .header("Authorization",token).body("{\n" +
                          "  \"employee_id\": \""+empID+"\",\n" +
                          "  \"emp_firstname\": \"hello\",\n" +
                          "  \"emp_lastname\": \"inmii\",\n" +
                          "  \"emp_middle_name\": \"how\",\n" +
                          "  \"emp_gender\": \"F\",\n" +
                          "  \"emp_birthday\": \"2009-04-02\",\n" +
                          "  \"emp_status\": \"loser\",\n" +
                          "  \"emp_job_title\": \"CEO\"\n" +
                          "}");
          Response response=prepareRequest.when().put("/updateEmployee.php");
          response.prettyPrint();
          response.then().assertThat().statusCode(200);
          response.then().assertThat().body("Message",equalTo("Employee record Updated"));
    }
    @Test
    public void dGetupdatedEmployee(){
        RequestSpecification prepareRequest=given().header("Content-Type","application/json")
                .header("Authorization",token).queryParam("employee_id",empID);
        Response response=prepareRequest.when().get("/getOneEmployee.php");

        response.then().assertThat().statusCode(200);

        String middle=response.jsonPath().getString("employee.emp_middle_name");
        Assert.assertTrue(middle.contentEquals("how"));
        response.prettyPrint();
    }
    @Test
        public void eGetAllEmployees(){
            RequestSpecification prepareRequest=given().header("Content-Type","application/json")
                    .header("Authorization",token);
            Response response=prepareRequest.when().get("/getAllEmployees.php");
           String allemployee= response.prettyPrint();

            JsonPath js=new JsonPath(allemployee);
           int count= js.getInt("Employees.size()");
            System.out.println(count);

        for (int i = 0; i < count; i++) {
            String employeesID=js.getString("Employees["+i+"].employee_id");
            System.out.println(employeesID);
        }


        }
}
