package day5;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updateuser
{
	@Test
	void testupdateuser(ITestContext context)
	{
		//Creating random user details
				Faker faker= new Faker();
				JSONObject data=new JSONObject();
				data.put("name",faker.name().fullName());
				data.put("gender","male");
				data.put("email",faker.internet().emailAddress());
				data.put("status","active");
		int id =(int) context.getAttribute("user_id");
		String bearer_Token="9a9ac92d13761fefdca51ad53ca94f571dfa837090c22d770539852fe6642e85";

	given()
			.headers("Authorization","Bearer "+bearer_Token)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id",id)
			
	.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
	.then()
		.statusCode(200)
		.log().all();
	}

}
