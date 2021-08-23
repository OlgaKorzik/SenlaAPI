package eu.senla.utilsAPI;

import com.google.gson.*;
import io.restassured.response.Response;
import static com.google.gson.JsonParser.parseString;

public class MethodsParse {
        public static JsonArray getJsonArrayFromResponse(Response res){
        return parseString(res.getBody().asString()).getAsJsonArray();
    }
}
