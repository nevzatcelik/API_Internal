package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

 /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request yolladigimizda donen response’in
  status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
 Request Body
{
"title":"Ali",
"body":"Merhaba",
"userId":10,
"id":70
}
Expected Data
{
"title":"Ali",
"body":"Merhaba",
"userId":10,
"id":70
}

  */

    @Test
    public void put01() {

        //1 Request olusturma
      specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        JSONObject reqBody= testDataJsonPlaceHolder.requestBodyOlustur();

      // 2 expected Data

        JSONObject expectedData= testDataJsonPlaceHolder.requestBodyOlustur();

        // 3 response u kaydet

        Response response = given().spec(specJsonPlace).
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                put("/{pp1}/{pp2}");


        //4
        JsonPath resJS = response.jsonPath();
        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(testDataJsonPlaceHolder.contentType,response.contentType());
        Assert.assertEquals(testDataJsonPlaceHolder.connectionHeaderDegeri,response.header("Connection"));
        Assert.assertEquals(expectedData.get("title"), resJS.get("title"));
        Assert.assertEquals(expectedData.get("body"), resJS.get("body"));
        Assert.assertEquals(expectedData.get("userId"), resJS.get("userId"));
        Assert.assertEquals(expectedData.get("id"), resJS.get("id"));

    }
}
