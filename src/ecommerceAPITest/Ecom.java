package ecommerceAPITest;

import Pojo.LoginRequest;
import Pojo.LoginResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Ecom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RequestSpecification resSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("parvathy.nair2007@gmail.com");
		loginRequest.setUserPassword("Parv*123");
		
		RequestSpecification reqLogin = given().log().all().spec(resSpec).body(loginRequest);
		LoginResponse loginResponse = reqLogin.when().post("api/ecom/auth/login")
		.then().extract().response().as(LoginResponse.class);
		String token = loginResponse.getToken();
		String userId = loginResponse.getUserId();

		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getUserId());

//Add product
		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token)
				.build();
		RequestSpecification addProductRequest=	
		given().log().all().spec(addProductBaseReq).param("productName","Laptop")
		.param("productAddedBy",userId)
		.param("productCategory","fashion")
		.param("productSubCategory","shirts")
		.param("productPrice","1150")
		.param("productDescription","Adidas Original")
		.param("productFor","women")
		.multiPart("productImage",new File ("C:\\Users\\Parvathy S Nair\\Downloads\\lady photo.jpg"));
		
		String addProductResponse = addProductRequest.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().asString();
		JsonPath js = new JsonPath(addProductResponse);
		String productid = js.getString("productId");
				
		
		
	}

}
