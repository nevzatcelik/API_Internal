package apiPractice;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Q01 {
    JSONObject ilkJSONObje=new JSONObject();


    @Test
    public void apiTest1(){
        // 1- Request icin Url ve Body hazirla
        String url= "https://automationexercise.com/api/productsList";
        // 2- Expected datayi hazirlamak

        // 3- Response'u kaydet
        Response response= given().when().get(url);
        response.prettyPrint();
         response.statusCode();
        System.out.println(response.getStatusCode());

        response.getBody();
        response.prettyPrint();
    }
}
