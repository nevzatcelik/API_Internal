package testData;

import org.json.JSONObject;

public class TestDataJsonPlaceHolder {

    public int basariliStatusCode=200;
    public String contentType="application/json; charset=utf-8";
    public String connectionHeaderDegeri = "keep-alive";

    public JSONObject expectedDataOlusturMethodu(){
        JSONObject expDataJson=new JSONObject();

        expDataJson.put("userId",3);
        expDataJson.put("id",22);
        expDataJson.put("title","dolor sint quo a velit explicabo quia nam");
        expDataJson.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expDataJson;
    }

    public JSONObject requestBodyOlustur(){
                JSONObject expectedDataJson=new JSONObject();

                 expectedDataJson.put("title","Ali");
                 expectedDataJson.put("body","Merhaba");
                 expectedDataJson.put("userId",10);
                 expectedDataJson.put("id",70);

                 return expectedDataJson;
    }


}
