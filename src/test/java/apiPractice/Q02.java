package apiPractice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Q02 {
/*
  https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
 */
String url="https://restful-booker.herokuapp.com/booking/19595";

    @Test
    public void createRezervation(){



        Response response=given().when().get(url);
        response.prettyPrint();

        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");


    }
    @Test
    public void updateRezervation(){
      JSONObject jsonObject=new JSONObject();
      JSONObject innerJson=new JSONObject();
        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");
       jsonObject.put("firstname","AHMET NEVZAT")
              .put("lastname","CELIKOGLU")
              .put("totalprice",2000)
              .put("depositpaid",true)
              .put("bookingdates",innerJson);

        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(jsonObject.toString()).put(url);

        response.prettyPrint();





    }
}
