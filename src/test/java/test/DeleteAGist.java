package test;

import java.io.IOException;

import org.testng.annotations.Test;

import base.CommonMethods;
import io.restassured.path.json.JsonPath;
import pojo.Files;
import pojo.Root;
import pojo.Shreya;

public class DeleteAGist {

	String response;
	/*
	 * CommonMethods cm = new CommonMethods(); Root body = new Root(); Files n = new
	 * Files(); Shreya s = new Shreya();
	 */
	String body;
	String id;

	
	@Test(priority = 1)
	public void createAGist() throws IOException {

		/*
		 * s.setContent("test"); s.setDescription("testing"); n.setShreya(s);
		 * body.setFiles(n);
		 */
		body = CommonMethods.GenerateStringFromResource("C:\\Users\\shreydixit\\eclipse-workspace\\restassured\\src\\main\\java\\payload\\payload.json");


		response = CommonMethods.GetResponse(body, "POST", "/gists", 201);
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String filename = js.getString("files.mAN.filename");
		id = js.getString("id");
		System.out.println(filename);
	}
	
	@Test(priority = 2)
	public void deleteAGist() {
	
		String endpoint = "/gists/" + id;
		System.out.println(endpoint);
		response = CommonMethods.GetResponse(body, "DELETE", endpoint, 204);

		System.out.println(response);
		JsonPath js = new JsonPath(response);

	}

}
