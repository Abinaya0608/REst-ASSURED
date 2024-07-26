package day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class postreqbodymultipleways {
	
	//@Test(priority = 1)
	void usingHashMap()
	{
	
	HashMap data = new HashMap();
	 data.put("userId","AbiWil");
	 data.put("jobTitleName","Tester");
	 data.put("firstName", "Abinaya");
	 data.put("lastName","Wilson");
	 data.put("preferredFullName","Abinaya Wilson");
	 data.put("employeeCode","E1");
	 data.put("region","CA");
	 data.put("phoneNumber","408-1234567");
	 data.put("emailAddress","abinaya.wilson@gmail.com");
	
	given()
	   .contentType("application/json")
	   .body(data)
	   
	.when()
	.post("http://localhost:3000/Employees")
	
	
	.then()
	.statusCode(201)
	.body("userId",equalTo("AbiWil"))
	.body("phoneNumber",equalTo("408-1234567"))
	.header("content-type","application/json")
	.log().all();
	
	}
	
	//@Test(priority =2)
	void usingjsonlib()
	{
	
	JSONObject jsondata = new JSONObject();
	
	jsondata.put("userId","prakash");
	jsondata.put("jobTitleName","Tester");
	jsondata.put("firstName", "Abinaya");
	jsondata.put("lastName","Wilson");
	jsondata.put("preferredFullName","Abinaya Wilson");
	jsondata.put("employeeCode","E1");
	jsondata.put("region","CA");
	jsondata.put("phoneNumber","408-1234567");
	jsondata.put("emailAddress","abinaya.wilson@gmail.com");
	
	given()
	   .contentType("application/json")
	   .body(jsondata.toString())
	   
	.when()
	.post("http://localhost:3000/Employees")
	
	
	.then()
	.statusCode(201)
	.body("userId",equalTo("prakash"))
	.body("phoneNumber",equalTo("408-1234567"))
	.header("content-type","application/json")
	.log().all();
	
	}
	
	//@Test(priority = 3)
	void usingpojo()
	{
	
		Pojo_postreq data = new Pojo_postreq();
	
	data.setUserId("prakash");
	data.setJobTitleName("Tester");
	data.setFirstName("Abinaya");
	data.setLastName("Wilson");
	data.setPreferredFullName("Abinaya Wilson");
	data.setEmployeeCode("E1");
	data.setRegion("CA");
	data.setPhoneNumber("408-1234567");
	data.setEmailAddress("abinaya.wilson@gmail.com");
	
	given()
	   .contentType("application/json")
	   .body(data)
	   
	.when()
	.post("http://localhost:3000/Employees")
	
	
	.then()
	.statusCode(201)
	.body("userId",equalTo("prakash"))
	.body("phoneNumber",equalTo("408-1234567"))
	.header("content-type","application/json")
	.log().all();
	
	}
	
	@Test
	void usingexternalfile() throws FileNotFoundException
	{
		File f= new File(".\\body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt= new JSONTokener(fr);
		JSONObject jsondata = new JSONObject(jt);

	
	given()
	   .contentType("application/json")
	   .body(jsondata.toString())
	   
	.when()
	.post("http://localhost:3000/Employees")
	
	
	.then()
	.statusCode(201)
	.body("userId",equalTo("thanks"))
	.body("phoneNumber",equalTo("408-2222222"))
	.header("content-type","application/json")
	.log().all();
	
	}
	
	@Test
	void testdelete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/Employees/55a2")
		
		.then()
		.statusCode(200);
		
	}

}
