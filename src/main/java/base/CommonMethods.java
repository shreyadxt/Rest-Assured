package base;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Root;

public class CommonMethods {

	static String response;
	
	public static String GetResponse(String body, String method, String endpoint, int code) {
	 RequestSpecification reqspec =new RequestSpecBuilder().setBaseUri("https://api.github.com")
			 .addHeader("Cache-Control", "no-cache")
				.addHeader("Postman-Token", "17fb39bf-6b8b-4478-aad4-13c82fc6e5b4").addHeader("Host", "api.github.com")
				.addHeader("User-Agent", "PostmanRuntime/7.28.4").addHeader("Accept", "*/*")
				.addHeader("Accept-Encoding", "gzip, deflate, br").addHeader("Connection", "keep-alive")
				.addHeader("Accept", "application/vnd.github.v3+json")
				.addHeader("Authorization", "Bearer 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")
				.addHeader("Content-Type", "application/json").build();
			
			 ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(code).build();
			 
			 RequestSpecification res=given().spec(reqspec)
			 .body(body);
			 //.expectContentType(ContentType.JSON)
			 
			 
			 if(method.equalsIgnoreCase("GET"))
			 {
				 response =res.when().get(endpoint).
						 then().spec(resspec).extract().response().asString();
			 }
			 else if(method.equalsIgnoreCase("POST"))
			 {
				 response =res.when().post(endpoint).
						 then().spec(resspec).extract().response().asString();
			 }
			 
			 else if(method.equalsIgnoreCase("DELETE"))
			 {
				 response =res.when().delete(endpoint).
						 then().spec(resspec).extract().response().asString();
			 }
	
			 return response;
			
}
	
	public static String GetResponseParam(String body, String method, String endpoint, int code, HashMap<String, String> map) {
		 RequestSpecification reqspec =new RequestSpecBuilder().setBaseUri("https://api.github.com")
				 .addHeader("Cache-Control", "no-cache")
					.addHeader("Postman-Token", "17fb39bf-6b8b-4478-aad4-13c82fc6e5b4").addHeader("Host", "api.github.com")
					.addHeader("User-Agent", "PostmanRuntime/7.28.4").addHeader("Accept", "*/*")
					.addHeader("Accept-Encoding", "gzip, deflate, br").addHeader("Connection", "keep-alive")
					.addHeader("Accept", "application/vnd.github.v3+json")
					.addHeader("Content-Type", "application/json")
					 .addQueryParam("since", "2022-02-19T12:40:30Z")
					 .addQueryParam("per_page", "100")
					 .addQueryParam("page", "1").build();
				
				 ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(code).expectContentType(ContentType.JSON).build();
				 
				 RequestSpecification res=given().spec(reqspec).auth().preemptive().basic("shreyadxt", "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")
				 .body(body);
				 
				 if(method.equalsIgnoreCase("GET"))
				 {
					 response =res.when().get(endpoint).
							 then().spec(resspec).extract().response().asString();
				 }
				 return response;
				
}
	
	public static String GenerateStringFromResource(String path) throws IOException {



	    return new String(Files.readAllBytes(Paths.get(path)));



	}
}
