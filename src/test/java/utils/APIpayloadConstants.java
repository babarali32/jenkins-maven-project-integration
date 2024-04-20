package utils;

import org.json.JSONObject;

public class APIpayloadConstants {

    // this is variable to store body , following is method to store body you can use any one
        public static final String CREATE_PAYLOAD = "{\n" +
                "  \"emp_firstname\": \"karachi\",\n" +
                "  \"emp_lastname\": \"hyderabad\",\n" +
                "  \"emp_middle_name\": \"india\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2020-04-05\",\n" +
                "  \"emp_status\": \"bill gate\",\n" +
                "  \"emp_job_title\": \"zucker berg\"\n" +
                "}";
    public static String createEmployeeBody(){
        String createPayload="{\n" +
                "  \"emp_firstname\": \"solo\",\n" +
                "  \"emp_lastname\": \"bolo\",\n" +
                "  \"emp_middle_name\": \"lolo\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2020-04-05\",\n" +
                "  \"emp_status\": \"sono\",\n" +
                "  \"emp_job_title\": \"xozo\"\n" +
                "}";
        return createPayload;
    }
    public static String createEmployeByjsonObject(){
        JSONObject object=new JSONObject();
        object.put("emp_firstname","kawait");
        object.put("emp_lastname","Russia");
        object.put("emp_middle_name","ireland");
        object.put("emp_gender","M");
        object.put("emp_birthday","2020-04-05");
        object.put("emp_status","chill");
        object.put("emp_job_title","Trump");

       return object.toString();
    }
    public static String dynamicBody(String emp_firstname, String emp_lastname,
                                     String emp_middle_name,
                                     String emp_gender, String emp_birthday,
                                     String emp_status, String emp_job_title){

        JSONObject object=new JSONObject();
        object.put("emp_firstname",emp_firstname);
        object.put("emp_lastname",emp_lastname);
        object.put("emp_middle_name",emp_middle_name);
        object.put("emp_gender",emp_gender);
        object.put("emp_birthday",emp_birthday);
        object.put("emp_status",emp_status);
        object.put("emp_job_title",emp_job_title);

        return object.toString();

    }
    public static String updateEmployeeBody(){
        JSONObject object=new JSONObject();
        object.put("employee_id","108207A");

        object.put("emp_firstname","river");
        object.put("emp_lastname","ocean");
        object.put("emp_middle_name","canal");
        object.put("emp_gender","M");
        object.put("emp_birthday","2020-04-05");
        object.put("emp_status","free");
        object.put("emp_job_title","No need");

        return object.toString();
    }
}
