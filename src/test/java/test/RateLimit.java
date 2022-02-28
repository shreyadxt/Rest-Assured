package test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.CommonMethods;
import io.restassured.path.json.JsonPath;
import pojo.Root;

public class RateLimit {

	String response; 
	String body = new String();
	//Root body = new Root();
	
	@Test(priority = 1)
	public void rateLimit() {
			
		response = CommonMethods.GetResponse(body, "GET", "/rate_limit", 200);
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String limit = js.getString("resources.core.limit");
		System.out.println(limit);
	}

}
