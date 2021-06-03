package StepDefinitions;

import java.util.ArrayList;
import java.util.List;

import com.google.errorprone.annotations.Var;

import io.restassured.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;

public class FinxactAPIMethods {
	
	private static final String baseURL = "https://226357.uat-10.finxact.io/model/v1/";
	
	public static String finxactGET(String path)
	{
		String URL = baseURL + path;
		
	try
		{
		String res = RestAssured.given()
				.header("client_id", "bbfa15adf5ef1c6f7de95a89bddd0a549944ba770612ddc3431500132d0a0e")
				.header("secret", "31ec8b813a27631eccb84e17")
				.header("Content-Type", "application/json")
				.header("Fnx-Header", "{\"identity\":{\"userRoles\":[\"developer\"]}}")
				.when()
                .get(URL).asPrettyString();
               
               // .prettyPrint();   
		System.out.println("Response .... " + res);
		return res.toString();
		}
		catch(Exception e) {
		System.out.println("There is exception..." + e.getMessage());
		return e.getMessage();
		}
	
	}
	
	public static String finxactPOST(String path)
	{
		String URL = baseURL + path;
		
	try
		{
		String res = RestAssured.given()
				.header("client_id", "bbfa15adf5ef1c6f7de95a89bddd0a549944ba770612ddc3431500132d0a0e")
				.header("secret", "31ec8b813a27631eccb84e17")
				.header("Content-Type", "application/json")
				.header("Fnx-Header", "{\"identity\":{\"userRoles\":[\"developer\"]}}")
				.when()
                .post(URL).asPrettyString();
               
               // .prettyPrint();   
		System.out.println("Response .... " + res);
		return res.toString();
		}
		catch(Exception e) {
		System.out.println("There is exception..." + e.getMessage());
		return e.getMessage();
		}
	
	}
	
	
	
}
