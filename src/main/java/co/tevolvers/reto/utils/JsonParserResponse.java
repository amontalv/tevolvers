package co.tevolvers.reto.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserResponse {

    public static String valueResponse(String atribbute,String respuesta){
        JsonParser jsonParser = new JsonParser();
        JsonObject myJson = (JsonObject) jsonParser.parse(respuesta);
        return myJson.get(atribbute).getAsString();
    }
}
