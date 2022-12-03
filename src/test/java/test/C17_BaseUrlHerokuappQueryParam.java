package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends HerokuAppBaseUrl {
    // Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

/*
    1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
    request gonderdigimizde donen response'un status code'unun 200 oldugunu
    ve Response'ta 12 booking oldugunu test edin
 */
/*
    2- https://restful-booker.herokuapp.com/booking endpointine gerekli
    Query parametrelerini yazarak "firstname" degeri "Eric" olan rezervasyon
    oldugunu test edecek bir GET request gonderdigimizde, donen response'un
    status code'unun 200 oldugunu ve "Eric" ismine sahip en az bir booking oldugunu test edin
 */
/*
    3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
     parametrelerini yazarak "firstname" degeri "Jim" ve "lastname" degeri
     "Jackson" olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
     donen response'un status code'unun 200 oldugunu ve "Jim Jackson" ismine sahip
     en az bir booking oldugunu test edin
*/

    @Test
    public void test01(){
        /*
    1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
    request gonderdigimizde donen response'un status code'unun 200 oldugunu
    ve Response'ta 12 booking oldugunu test edin
 */


        specHerokuPlace.pathParam("pp1","booking");

        //2 expected

        //3
        Response response=given().spec(specHerokuPlace).when().get("/{pp1}");

        //4 assertion
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(46206));
    }

    @Test
    public void test02(){
        /*
    2- https://restful-booker.herokuapp.com/booking endpointine gerekli
    Query parametrelerini yazarak "firstname" degeri "Eric" olan rezervasyon
    oldugunu test edecek bir GET request gonderdigimizde, donen response'un
    status code'unun 200 oldugunu ve "Eric" ismine sahip en az bir booking oldugunu test edin
 */
        specHerokuPlace.pathParam("pp1","booking").queryParam("firstname","Eric");


        Response response=given().spec(specHerokuPlace).when().get("/{pp1}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(2));

    }

    @Test
    public void test03(){
        /*
            3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
     parametrelerini yazarak "firstname" degeri "Jim" ve "lastname" degeri
     "Jackson" olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
     donen response'un status code'unun 200 oldugunu ve "Jim Jackson" ismine sahip
     en az bir booking oldugunu test edin
         */
       // 1 request olusturma
        specHerokuPlace.pathParam("pp1","booking").queryParams("firstname","Jim","lastname","Jackson");
       // 2 expected body hazirlama

        // 3 response u kaydetme
        Response response=given().spec(specHerokuPlace).when().get("/{pp1}");
        response.prettyPrint();
        //4 assertion yap
        response.then().assertThat().statusCode(200).body(Matchers.
                equalTo("[\n" +
                        "    \n" +
                        "]"));
    }
}
