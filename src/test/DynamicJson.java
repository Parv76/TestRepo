package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
//import test.ReusableMethods;

public class DynamicJson {
	@Test(dataProvider = "book details")
	public void AddBook(String isbn, String aisle)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().header("Content-Type","application/json")
		.body(Payload.Addbook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReusableMethods.rawToJson(response);
		System.out.println(response);
		//JsonPath js1 = new JsonPath(response);
		String id  = js.getString("ID");
		System.out.println(id);
		
	}
	@DataProvider(name = "book details")
	public Object[][] getData()
	{
		return new Object [][]  {{"bcd","3444"},{"uie","8933"},{"iu3","923"}};
	}
}
