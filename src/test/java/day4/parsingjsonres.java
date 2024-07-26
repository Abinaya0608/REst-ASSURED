package day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class parsingjsonres {
	
	@Test
	void testJsonresponse()
	{
	  given()
	  	.contentType("application/json")
	  .when()
	  	.get("https://fakestoreapi.com/products")
	  .then()
	  .statusCode(200)
	  .header("content-type","application/json; charset=utf-8")
	  .body("[2].personal.physical_features.hair_color",equalTo("Khaki"))
	  .log().all();
	}

}
