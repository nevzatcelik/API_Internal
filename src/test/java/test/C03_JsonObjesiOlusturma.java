package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {
    JSONObject ilkJSONObje=new JSONObject();
    JSONObject innerJson=new JSONObject();
    @Test
    public void jsonObje(){



        ilkJSONObje.put("title","Ahmet");
        ilkJSONObje.put("body","Merhaba");
        ilkJSONObje.put("userId",1);

        System.out.println(ilkJSONObje);

    }


    @Test
    public void jsonObje2(){
       /* {
            "firstname": "Ahmet Nevzat",
                "lastname": "Celik",
                "totalprice": 4000,
                "depositpaid": false,
                "bookingdates": {
            "checkin": "2023-01-01",
                    "checkout": "2013-01-15"
        },
            "additionalneeds": "Iron"
        }
        */

        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");
        JSONObject body=new JSONObject();
        body.put("firstname","Ahmet Nevzat");
        body.put("lastname","CELIK");
        body.put("totalprice",4000);
        body.put("totalprice",true);
        body.put("bookingdates",innerJson);

        System.out.println(body);


    }
}
