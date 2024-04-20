package utils;
import io.restassured.RestAssured;
public class APIconstants {
    public static final String baseuri= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_EMPLOYEE_BASE_URI=baseuri  +  "/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_BASE_URI=baseuri  +  "/getOneEmployee.php";
    public static  final String UPDATE_EMPLOYEE_BASE_URI=baseuri  +  "/updateEmployee.php";
    public static final String GET_ALL_EMPLOYEE_BASE_URI=baseuri  +  "/getAllEmployees.php";
    public static final String DELETE_EMPLOYEE_BASE_URI=baseuri  +  "/deleteEmployee.php";
    public static final String  GENERATE_TOKEN_BASE_URI=baseuri  +  "/generateToken.php";
    public static final String HEADER_CONTENT_TYPE="Content-Type";
    public static final String CONTENT_VALUE="application/json";
    public static final String HEADER_AUTHORIZATION="Authorization";

}
