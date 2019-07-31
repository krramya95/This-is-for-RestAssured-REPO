package org.lti.com.org.ramya.com;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PUTCall {
	@Test
	public void putRequests() {
	RestAssured.baseURI = "https://dev19986.service-now.com/api/now/table/change_request";

    AuthenticationScheme basic=RestAssured.basic("admin","ServiceNow@123");

    RestAssured.authentication=basic;

    HashMap<String,String> map=new HashMap<String,String>();

    map.put("Content-Type","application/json");

    map.put("Accept","application/json");

    JsonObject json=new JsonObject();

    json.addProperty("short_description","i am doing post");

    Response response=RestAssured

                 .given()

                 .headers(map)

                 .body(json.toString())

                 .get();

    int code=response.statusCode();

    System.out.println("The Status Code is"+code);

    Assert.assertEquals(code, 200);

	}

}
