package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class headersdemo {
	@Test
	void getheaderinfo()
	{
		Response res=given()
		.when()
		.get("https://www.google.co.in/");
		
		//Getting single header info
		String Single_header=res.getHeader("content-type");
		System.out.println(Single_header);
		
		//Getting Multiple Header info
		Headers multi_headers=res.getHeaders();	
		for(Header h:multi_headers)
		{
			System.out.println(h.getName()+"    "+h.getValue());
		}
	}

}
