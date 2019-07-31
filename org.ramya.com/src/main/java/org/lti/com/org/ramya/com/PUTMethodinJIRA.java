package org.lti.com.org.ramya.com;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import io.restassured.response.Response;

public class PUTMethodinJIRA extends BaseRequest_Common {
		@Test
		public void putMethod ()
		{
			String body="{\r\n" + 
					"    \"fields\": {\r\n" + 
					"       \"summary\": \"Blank Space\"\r\n" + 
					"   }\r\n" + 
					"}";
			
			Response put = requestSpecs.accept(ContentType.XML)
										.body(body)
					.put("10003");
			
			//XmlPath xml=put.xmlPath();
			put.prettyPrint();
			
			int statusCode=put.getStatusCode();
			System.out.println(statusCode);
				
			
	}
}
