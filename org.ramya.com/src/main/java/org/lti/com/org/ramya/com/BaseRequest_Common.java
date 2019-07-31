package org.lti.com.org.ramya.com;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest_Common {
	public static RequestSpecification requestSpecs;
	public static String issueId;
	@BeforeSuite
	public void reqSpecs()
	{
		RestAssured.baseURI="https://ramyawebservicestesting.atlassian.net/rest/api/3/search?jql=project=Webservices_testing1";
		RestAssured.authentication=RestAssured.preemptive().basic("krramya95@gmail.com","Krramya95@");
		
		requestSpecs= RestAssured.given().log().all().contentType(ContentType.JSON);
	}
}
