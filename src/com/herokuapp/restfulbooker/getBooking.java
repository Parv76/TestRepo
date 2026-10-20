package com.herokuapp.restfulbooker;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getBooking {
	
	public void getOnebooking()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		//String resp = given().queryParam("id","1").when().get("/booking/{id}").then().body("firstname",equalTo("Sally"));
		
		System.out.println("heeelo");
		System.out.println("JJJJJDFSDFSD---ANYTHJNG");
		System.out.println("TESTUIIII for branch conflict");
	}

	private Object given() {
		// TODO Auto-generated method stub
		return null;
	}

}
