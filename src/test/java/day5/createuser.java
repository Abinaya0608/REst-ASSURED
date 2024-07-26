package day5;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class createuser {
	
	@Test 
	void testcreateuser(ITestContext context)
	{
		//Creating random user details
		Faker faker= new Faker();
		JSONObject data=new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","active");
		
		String bearer_Token="9a9ac92d13761fefdca51ad53ca94f571dfa837090c22d770539852fe6642e85";
		
	int id=given()
				.headers("Authorization","Bearer "+bearer_Token)
				.contentType("application/json")
				.body(data.toString())
		.when()
				.post("https://gorest.co.in/public/v2/users")
				.jsonPath().getInt("id");
	
	context.setAttribute("user_id", id);
	System.out.println("Generated id :" +id);
		
	}

}
