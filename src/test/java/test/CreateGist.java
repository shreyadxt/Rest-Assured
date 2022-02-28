package test;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import base.CommonMethods;
import io.restassured.path.json.JsonPath;
import pojo.Files;
import pojo.Root;
import pojo.Shreya;

public class CreateGist {

	String response;
	/*
	 * Root body = new Root(); Files n = new Files(); Shreya s = new Shreya();
	 */
	public static String id;
	String body;
	

	@Test(priority = 1)
	public void createGists() throws IOException {

		/*
		 * s.setContent("test"); s.setDescription("testing"); s.setPublic("true");
		 * n.setShreya(s); body.setFiles(n);
		 */
		body = CommonMethods.GenerateStringFromResource("C:\\Users\\shreydixit\\eclipse-workspace\\restassured\\src\\main\\java\\payload\\payload.json");

		response = CommonMethods.GetResponse(body, "POST", "/gists", 201);
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String filename = js.getString("files.mAN.filename");
		id = js.getString("id");
		System.out.println(filename);
		System.out.println(id);
	}
}
