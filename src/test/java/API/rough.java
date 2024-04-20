package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class rough {
    public static void main(String[] args) {
        String baseuri= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
        String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTIyMDI0MTUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcxMjI0NTYxNSwidXNlcklkIjoiNjU5MCJ9.nKuRiCOrqUBu2RKMR10kSk8tpxFTSKmwbt_B7PCbKw8";
            //baseuri is not directly linked with response and request specification but internally linked with both
            RequestSpecification preparedRequest= given().header("Content-Type","application/json")
                    .header("Authorization",token)
                    .queryParam("employee_id","108195A");
            Response response= preparedRequest.when().get("/getOneEmployee.php");
            //System.out.println(response.asString());
            response.prettyPrint();
            response.then().assertThat().statusCode(200);
        }
    }

