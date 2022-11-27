package test;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GET_ApiSorgulama {
    /*
        https://restful-booker.herokuapp.com/booking/247336 url’ine bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

    @Test
    public void get01(){
        // 1- Request icin Url ve Body hazirla

        String url="https://restful-booker.herokuapp.com/booking/263966";

        // 2- Expected datayi hazirlamak


        // 3- Response'u kaydet

        Response response= given().when().get(url);
        response.prettyPrint();

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Serveer Headerinin Degeri: " + response.getHeader("Server"));
        System.out.println("Status Line : " + response.getStatusLine());
        System.out.println("Status Code : " + response.getTime());

        // Assertion

        Assert.assertTrue(response.getTime()<=5000);

    }
}
