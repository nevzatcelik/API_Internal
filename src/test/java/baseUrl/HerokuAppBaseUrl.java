package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;


public class HerokuAppBaseUrl {
    protected RequestSpecification specHerokuPlace;

    @Before
    public void setUp(){
        specHerokuPlace = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }
}
