package org.lti.com.org.ramya.com;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class CreateAnIncident {
	@BeforeSuite
	public void authentication()
	{
		RestAssured.baseURI="https://ramyawebservicestesting.atlassian.net/rest/api/3/issue";
		RestAssured.authentication=RestAssured.preemptive().basic("krramya95@gmail.com","Krramya95@");
	}
	@Test(dataProvider="sendData")
	public void createIncident(String dat)
	{
		
		String con="{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"WT1\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \""+dat+"\",\r\n" + 
				"       \"description\": \r\n" + 
				"       { \r\n" + 
				"       	\"type\": \"doc\",\r\n" + 
				"       	\"version\": 1,\r\n" + 
				"       	\"content\": [\r\n" + 
				"       		{ \r\n" + 
				"       		\"type\": \"paragraph\", \r\n" + 
				"       		\"content\": [\r\n" + 
				"       			{ \r\n" + 
				"       			\"type\": \"text\",\r\n" + 
				"       			\"text\": \"This is the created description1\"\r\n" + 
				"       			} ] 	\r\n" + 
				"       		} ]\r\n" + 
				"       	},\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";
		Response res=RestAssured.given().contentType(ContentType.JSON).body(con).post();
		//res.prettyPrint();
		int statusCode=res.getStatusCode();
		System.out.println(statusCode);
		JsonPath json=res.jsonPath();
		String id1 = json.get("id");
		System.out.println(id1);
		RestAssured.baseURI="https://ramyawebservicestesting.atlassian.net/rest/api/3/issue/"+id1;
		Response res1=RestAssured.given().accept(ContentType.JSON).get();
		JsonPath js=res1.jsonPath();
		res1.prettyPrint();
		String s = js.get("fields.summary");	
		
		System.out.println(dat);
		System.out.println(s);
		
		if(dat.equals(s))
		{
			System.out.println("passing");
		}	
		
	}

@DataProvider(name="sendData")
public Object[][] get()
{
	String data1="It aint me";
	String data2="The End";
	Object[][] data=new Object[2][1];
	data[0][0]=data1;
	data[1][0]=data2;
	return data;
}
}