package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;

/*1.create json schema from json response 2.add json schema in project 
 *3.add json schema validator in pom 4.check the response*/

public class JsonSchemaValidator {

	@Test
	public void schemaValidator() {
		
		baseURI = "https://reqres.in/api";
			
			given().get("/users?page=2")
			.then()
			 .assertThat().body(matchesJsonSchemaInClasspath("data.json"))
			.statusCode(200)
			.body("data[4].first_name", equalTo("George"))
			.body("data.first_name", hasItems("George", "Rachel"));
		}
		
		

	
	
}

