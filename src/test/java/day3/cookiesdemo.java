package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookiesdemo {
	
	@Test
	void testcookies()
	{
	
		
Response res=given()

			.when()
			.get("https://www.google.co.in/");
	
	//Getting single cookie value
	String single_cookie=res.getCookie("AEC");
	System.out.println(single_cookie);
	
	//Getting multiple cookie values
	Map<String,String> multiple_cookies=res.getCookies();
	for (String k:multiple_cookies.keySet())
	{
		System.out.println(k+"       "+res.getCookie(k));
	}
		
	}
	

}
