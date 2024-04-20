package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class generateTokenSteps {
        public String baseuri=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
        public static String token;
     @Test
    @Given("a JWT Bearer token is generated")
    public void a_jwt_bearer_token_is_generated() {
        RequestSpecification prepareRequestToGeneratToken= RestAssured.given().header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"email\":\"asgharnazir@gmail.com\",\n" +
                        "    \"password\":\"pakistaN32\"\n" +
                        "}");
        Response response=prepareRequestToGeneratToken.when().post("/generateToken.php");
        token="Bearer "  +  response.jsonPath().getString("token");
        System.out.println(token);
    }
}
