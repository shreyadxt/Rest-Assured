package test;

import java.util.HashMap;

import org.testng.annotations.Test;

import base.CommonMethods;
import io.restassured.path.json.JsonPath;
import pojo.Root;

public class ListGistsForAUser {

	
	String response; 
//	Root body = new Root();
	String body = new String();
	String endpoint = "/users/shreyadxt/gists";
	HashMap<String, String> map = new HashMap<String, String>();
	
	
	@Test(priority = 1)
	public void listAuth() {
			
		map.put("since", "2022-02-19T12:40:30Z");
		map.put("per_page", "100");
		map.put("page", "1");
		
		response = CommonMethods.GetResponseParam(body, "GET", endpoint, 200, map);
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String id = js.getString("id");
		System.out.println(id);
			
		}
}
