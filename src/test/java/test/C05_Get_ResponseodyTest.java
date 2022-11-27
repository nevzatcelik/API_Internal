package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Get_ResponseodyTest {

    @Test
    public void get01(){
        // Request icin gerekli URL ve body hazirla

        String url="https://jsonplaceholder.typicode.com/posts/44";

        // Soruda verilmisse Expected datayi hazirla

        // Response u kaydet
        Response response=given().when().get(url);
       // response.prettyPrint();

        // Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", Matchers.equalTo(5)).
                body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}
