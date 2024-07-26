package day5;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteuser {
	
	@Test
	void tesdeleteuser(ITestContext context)
	{
		int id =(int) context.getAttribute("user_id");
		String bearer_Token="9a9ac92d13761fefdca51ad53ca94f571dfa837090c22d770539852fe6642e85";
	
		given()
				.headers("Authorization","Bearer "+bearer_Token)
				.pathParam("id",id)					
		.when()
				.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
	}

}