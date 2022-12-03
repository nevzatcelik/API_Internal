package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class  C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {
    /*
 https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunutest ediniz
   Response body :
{
"userId":3,
"id":22,
"title":"dolor sint quo a velit explicabo quia nam",
"body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */

    @Test
    public void get01() {
        // 1 REQUEST olusturma
        specJsonPlace.pathParams("pp1","posts","pp2",22);

        // 2 expected data mizi olusturalim

        TestDataJsonPlaceHolder testDataJson=new TestDataJsonPlaceHolder();
      JSONObject expectedData=testDataJson.expectedDataOlusturMethodu();

        // 3 Response kaydet

        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4 assertion
        JsonPath resJS = response.jsonPath();
        Assert.assertEquals(expectedData.get("userId"),resJS.get("userId"));
        Assert.assertEquals(expectedData.get("id"),resJS.get("id"));
        Assert.assertEquals(expectedData.get("title"),resJS.get("title"));
        Assert.assertEquals(expectedData.get("body"),resJS.get("body"));



    }
}
