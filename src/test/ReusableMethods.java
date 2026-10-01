package test;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
    
    // Converts a raw String response into a JsonPath object
    public static JsonPath rawToJson(String response ) {
        JsonPath js1 = new JsonPath(response);
        return js1;
    }
	
}