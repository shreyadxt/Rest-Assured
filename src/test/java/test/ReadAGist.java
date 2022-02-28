package test;

import org.testng.annotations.Test;

import base.CommonMethods;
import io.restassured.path.json.JsonPath;
import pojo.Root;

public class ReadAGist {

	String response; 
	CommonMethods cm = new CommonMethods();
	//Root body = new Root();
	String body = new String();
	String id = "/gists/e9f28770b404584f36f63eeafc6421d8";
	
	@Test(priority = 1)
	public void rateLimit() {
			
		response = cm.GetResponse(body, "GET", id, 200);
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String filename = js.getString("files.shreya.filename");
		System.out.println(filename);
	}
}
