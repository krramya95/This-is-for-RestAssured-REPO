package org.lti.com.org.ramya.com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	@Test
	public void getAllRequests() {
		
		RestAssured.baseURI = "https://dev28357.service-now.com/api/now/table/incident";
		AuthenticationScheme bs = RestAssured.basic("admin", "Tuna@123");
		// This is for Jira: 
		//RestAssured.preemptive().basic(userName, password)
		RestAssured.authentication = bs;
		Map<String,String> parametersMap = new HashMap<String,String>();
		parametersMap.put("urgency", "1");
		parametersMap.put("priority", "1");
//JsonObject json=new JsonObject();
		Response response = RestAssured
				.given()  //a Request specification
				//.params(parametersMap)
				.header("Content-Type","application/json")
//.body(json.toString())
				.param("urgency", "1") //a Request specification, can sent several parameters
				.get();
		
		response.prettyPrint();		
		
		int statusCode = response.statusCode();
		System.out.println(statusCode);
		
		JsonPath json = response.jsonPath();
		
		List<String> allNumbers = json.getList("result.number");
		System.out.println(allNumbers.size());
		
		/*for (String eachIncident : allNumbers) {
			System.out.println(eachIncident);
		}*/
		
		
		
		
	}

}