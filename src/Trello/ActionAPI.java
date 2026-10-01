package Trello;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class ActionAPI {
	
	@Test
	public void ActionAPI()
	{
		RestAssured.baseURI = "https://api.trello.com";
		RequestSpecification rsp = RestAssured.given();
		String response = given().log().all().queryParam("key","b8ea900a9384fd24e47b6f7301eeb34e").queryParam("token","ATTA93109b1dc36fb8710b9eb314ce362ba2143a1d7648104765328a243a1c996f7c29351BAA")
				.header("Content-Type","application/")
				.pathParam("id","69b1e3a7eef2fd20a031b61f")
				.when().get("/1/actions/{id}")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		//System.out.println(response);

		
		
		
	}

}
