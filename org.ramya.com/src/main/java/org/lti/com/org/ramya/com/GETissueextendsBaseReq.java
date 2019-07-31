package org.lti.com.org.ramya.com;


import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GETissueextendsBaseReq extends BaseRequest_Common {
	@Test
	public void getIssueID()
			{
/*Map<String,String> metersMap = new HashMap<String,String>();
	metersMap.put("urgency", "1");
	metersMap.put("priority", "1");*/
	
	Response res=requestSpecs.get();
	
	JsonPath jsp=res.jsonPath();

	List<String> a=jsp.getList("issues.id");

	issueId=a.get(a.size()-1);
	System.out.println(issueId);	
	
	
	
	
	
			}
}
