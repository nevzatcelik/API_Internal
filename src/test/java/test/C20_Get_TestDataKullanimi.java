package test;

import baseUrl.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;

public class C20_Get_TestDataKullanimi extends DummyBaseUrl{

    /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un status code’unun 200,
        content Type’inin application/json ve body’sinin asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data": {
                "id": 3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
         */
    @Test
    public void test01() {
        // 1=Request url ve body hazirlama
        dummySpec.pathParams("pp1", "employee", "pp2", 3);

        // 2= Expected body hazirlama

        TestDataDummy testDataDummy = new TestDataDummy();
        JSONObject expData = testDataDummy.expectedDataOlustur();

        //3= Response u kaydetme

        Response response = given().spec(dummySpec).when().get("/{pp1}/{pp2}");

        //4= Assertion
        JsonPath resJS = response.jsonPath();
        Assert.assertEquals(testDataDummy.statusCode, response.getStatusCode());
        Assert.assertEquals(testDataDummy.contentType, response.getContentType());
        Assert.assertEquals(expData.get("status"), resJS.get("status"));
        Assert.assertEquals(expData.get("message"), resJS.get("message"));
        Assert.assertEquals(expData.getJSONObject("data").get("id"), resJS.get("data.id"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_name"), resJS.get("data.employee_name"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_salary"), resJS.get("data.employee_salary"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_age"), resJS.get("data.employee_age"));
        Assert.assertEquals(expData.getJSONObject("data").get("profile_image"), resJS.get("data.profile_image"));

    }
}
