package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C09_Post_JsonPathileBodyTesti {
    /*
            https://restful-booker.herokuapp.com/booking
             url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                            },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

    @Test
    public void JsonPath(){
        //

        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody=new JSONObject();
        JSONObject reqBody=new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerBody);
        reqBody.put("additionalneeds","wi-fi");

        //2- Expected Data Hazirla

        //3 - Response i kaydet

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();

       // Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("booking.firstname", Matchers.equalTo("Ali"),
                        "booking.lastname",Matchers.equalTo("Bak"),
                        "booking.totalprice",Matchers.equalTo(500),
                        "booking.depositpaid",Matchers.equalTo(false),
                        "booking.bookingdates.checkin",Matchers.equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",Matchers.equalTo("2021-06-10"),
                        "booking.additionalneeds",Matchers.equalTo("wi-fi"));



    }
}
