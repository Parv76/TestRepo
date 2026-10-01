package Trello;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class BoardApi {
	@Test
	//create board in trello
	public void AddBoard()
	{
		RestAssured.baseURI = "https://api.trello.com";
		//RequestSpecification reqspec = RestAssured.given();
		String response = given().log().all().queryParam("name","BoardCreatedAutomation Latest")
		.queryParam("key", "b8ea900a9384fd24e47b6f7301eeb34e")
		.queryParam("token", "ATTA93109b1dc36fb8710b9eb314ce362ba2143a1d7648104765328a243a1c996f7c29351BAA")
		.when().post("/1/boards/")
		.then().assertThat().statusCode(200).extract().response().asString();
		//log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response + "Board added successfully");
		JsonPath js = new JsonPath(response);
		 String BoardId = js.getString("id");
		 System.out.println("Newly added board "+BoardId);
		
	
	//get newly created board
		 //RequestSpecification reqspec = RestAssured.given();
		String response2= given().log().all()
		.queryParam("key", "b8ea900a9384fd24e47b6f7301eeb34e")
		.queryParam("token", "ATTA93109b1dc36fb8710b9eb314ce362ba2143a1d7648104765328a243a1c996f7c29351BAA")
		.pathParam("id",BoardId)
		.when().get("/1/boards/{id}")
		.then().assertThat().statusCode(200).extract().response().asString();
		//.log().all().extract().response().asString();
		JsonPath js1 = new JsonPath(response2);
		 String BoardId2 = js1.getString("id");
		 System.out.println("Getting board id " + BoardId2);
		 
		 //Delete created board
		 String response3 = given()
			.queryParam("key", "b8ea900a9384fd24e47b6f7301eeb34e")
			.queryParam("token", "ATTA93109b1dc36fb8710b9eb314ce362ba2143a1d7648104765328a243a1c996f7c29351BAA")
			.pathParam("id",BoardId2)
			.when().delete("1/boards/{id}")
			.then().assertThat().statusCode(200).extract().response().asString();
		 
		 JsonPath js2 = new JsonPath(response3);
		 String s = js2.getString("id");
		 System.out.println("Deleted board id " + s);

		
		 

}}
