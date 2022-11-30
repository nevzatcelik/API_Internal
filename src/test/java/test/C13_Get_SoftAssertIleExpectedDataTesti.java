package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {


    @Test
    public void softAssert(){
        /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Response Body
{
"status":"success",
"data":{
"id":3,
"employee_name":"Ashton Cox",
"employee_salary":86000,
"employee_age":66,
"profile_image":""
},
"message":"Successfully! Record has been fetched."
}
     */

        //1 Request i olustur

        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        //2 expected data yi hazirla

        JSONObject  expectedBody=new JSONObject();
        JSONObject data=new JSONObject();
        expectedBody.put("status","success");
        expectedBody.put("data",data);
        expectedBody.put("message","Successfully! Record has been fetched.");
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        System.out.println(expectedBody);
        // 3 RESPONSE U KAYDET

        Response response=given().when().get(url);

        response.prettyPrint();

        //4 Assertioon u olustur

        SoftAssert softAssert=new SoftAssert();
        JsonPath resJS = response.jsonPath();
        softAssert.assertEquals(resJS.getString("status"),expectedBody.get("status"));
        softAssert.assertEquals(resJS.getInt("data.id"),expectedBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJS.getString("data.employee_name"),expectedBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJS.getInt("data.employee_salary"),expectedBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJS.getInt("data.employee_age"),expectedBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJS.getString("data.profile_image"),expectedBody.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();




    }
}
