package day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class httprequest 
{
	int id;
	@Test(priority = 1)
	void getusers()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	
	@Test(priority = 2)
	void createUser()
	{
		HashMap data = new HashMap();
		data.put("name", "abi");
		data.put("job", "Training");
		
	  id=given()
		   .contentType("application/json")
		   .body(data)
		   
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		//.then()
	}
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser()
	{
		HashMap data = new HashMap();
		data.put("name", "abinaya");
		data.put("job", "Quality Control");
		
	     given()
		   .contentType("application/json")
		   .body(data)
		   
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority = 4)
	void deleteUser()
	{
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	}
}
