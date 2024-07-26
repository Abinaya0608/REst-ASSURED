package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

//https://reqres.in/api/users?page=2&id=7

public class pathnqueryparams {
	
	@Test
	void testpathandqueryparams()
	{
		given()
			.pathParam("mypath","users")
			.queryParam("page",2)
			.queryParam("id", 7)
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	
}
