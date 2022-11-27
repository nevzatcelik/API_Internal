package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_GetBodyTekrarlardanKurtulma {
    /*
                https://restful-booker.herokuapp.com/booking/14018 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"James",
                    ve "lastname“in, "Brown",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin

         */
    JSONObject body=new JSONObject();
    @Test
    public void get01(){
        String url="https://restful-booker.herokuapp.com/booking/14018";

        Response response=given().when().get(url);

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).

                body("firstname",Matchers.equalTo("James")).
                body("lastname",Matchers.equalTo("Brown")).
                body("totalprice",Matchers.equalTo(111)).
                body("depositpaid",Matchers.equalTo(true)).
                body("additionalneeds",Matchers.equalTo("Breakfast"));

    }
}
