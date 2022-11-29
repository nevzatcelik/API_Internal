package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_GetExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
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
    public void getExpected(){
         //1= Request
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2= EXPECTED DATA hazirla

        JSONObject expectedBody=new JSONObject();

        expectedBody.put("userId",3);
        expectedBody.put("id",22);
        expectedBody.put("title","dolor sint quo a velit explicabo quia nam");
        expectedBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        Response response=given().when().get(url);

        response.prettyPrint();

        //4 Assertion

        JsonPath responseJpath=response.jsonPath(); // noktalar ile isin icersine girebilmeyi

        assertEquals(expectedBody.get("userId"),responseJpath.getInt("userId"));
        Assert.assertEquals(expectedBody.get("id"),responseJpath.getInt("id"));
        Assert.assertEquals(expectedBody.get("title"),responseJpath.getString("title"));
        Assert.assertEquals(expectedBody.get("body"),responseJpath.getString("body"));

    }
}
