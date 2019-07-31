package org.lti.com.org.ramya.com;

import org.testng.annotations.Test;

public class DeleteIssuedependsOnGET extends BaseRequest_Common{
	
	@Test(dependsOnMethods="org.lti.com.org.ramya.com.GETissueextendsBaseReq.getIssueID")
	public void del () {
		requestSpecs.delete("/"+issueId);
		
	}
	

}
