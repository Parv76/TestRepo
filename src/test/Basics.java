
package test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Basics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Validate Add Place api
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		//.body(Payload.getPayload())
				//content of json coming from external file
				//content of the file to string -> content of file into byte then byte to string
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Parvathy S Nair\\Documents//addplace.json"))))
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);//for parsing json
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		//to update address of place using Put method
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\"70 summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200)
		.body("msg",equalTo("Address successfully updated"));
		
		
		//to get updated address using Get method
		String newPlace = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(newPlace);
		String newaddress = js1.getString("address");
		System.out.println(newaddress);
		

		}

}
