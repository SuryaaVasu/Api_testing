package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class LocalApi {

	@Test
	public void testLocalApi(){
		baseURI = "http://localhost:3000";
		
		given().get("/banks").then().statusCode(200)
		.log().all();
	}
	
	@Test(priority=2)
	public void testCreate() {
		JSONObject req =new JSONObject();
		req.put("id", "7");
		req.put("name", "samson");
		req.put("acc type","Current");
		
		baseURI = "http://localhost:3000";
		given()
		  .contentType(ContentType.JSON).accept(ContentType.JSON)
		  .body(req.toJSONString())
		.when().post("/banks")
		 .then().statusCode(201).log().all();
	}
	
	@Test(priority=3)
	public void testUpdate() {
		JSONObject req =new JSONObject();
		req.put("id", "7");
		req.put("name", "samson");
		req.put("acc type","Current");
		req.put("branch", "Punjab bank");
		
		baseURI = "http://localhost:3000";
		given()
		  .contentType(ContentType.JSON).accept(ContentType.JSON)
		  .body(req.toJSONString())
		.when().patch("/banks/7")
		 .then().statusCode(200).log().all();
	}
	
	@Test(priority=4)
	public void testDelete() {
		
		baseURI = "http://localhost:3000";
		when().delete("/banks/7")
		 .then().statusCode(200).log().all();
	}
	
}
