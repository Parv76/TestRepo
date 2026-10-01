package com.herokuapp.restfulbooker;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class HealthCheckTest {
	@Test
	public void healthCheckTest()
	{
		Response resp = RestAssured.get("https://restful-booker.herokuapp.com/booking");
		resp.print();
		Assert.assertEquals(resp.getStatusCode(),200, "Status code is 200");
		List<Integer> ls = resp.jsonPath().getList("bookingid");
		Assert.assertFalse(ls.isEmpty(), "Not empty");
		/*
		given().
		when().get("").
		then().assertThat().statusCode(201);*/
		
	}

}
