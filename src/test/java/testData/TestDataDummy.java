package testData;

import org.json.JSONObject;

public class TestDataDummy {

    public int statusCode=200;
    public String contentType="application/json";

    public JSONObject innerDataBody(){
        JSONObject innerDataBodyJson=new JSONObject();
        innerDataBodyJson.put("id",3);
        innerDataBodyJson.put("employee_name","Ashton Cox");
        innerDataBodyJson.put("employee_salary",86000);
        innerDataBodyJson.put("employee_age",66);
        innerDataBodyJson.put("profile_image","");

        return innerDataBodyJson;
    }

    public JSONObject expectedDataOlustur(){
        JSONObject expectedDataJson=new JSONObject();
        expectedDataJson.put("status","success");
        expectedDataJson.put("data",innerDataBody());
        expectedDataJson.put("message","Successfully! Record has been fetched.");

        return expectedDataJson;
    }
}
