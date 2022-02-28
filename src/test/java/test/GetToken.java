package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;

public class GetToken {
	
	@Test (priority =1)
	public void auth() {
		String response = given().header("Cache-Control", "no-cache")
				.header("Postman-Token", "17fb39bf-6b8b-4478-aad4-13c82fc6e5b4").header("Host", "api.github.com")
				.header("User-Agent", "PostmanRuntime/7.28.4").header("Accept", "*/*")
				.header("Accept-Encoding", "gzip, deflate, br").header("Connection", "keep-alive")
				.header("Accept", "application/vnd.github.v3+json")

				.when().get("https://api.github.com/gists")

				.then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(response);
		String token = js.getString("public[1]");
		System.out.println(token);
		// return token;
	}

	
	
}
