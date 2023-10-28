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
	
	private static final String baseURL = "https://226357.uat-10.finxact.io/";
	
	private static final String client_id = "bbfa15adf5ef1c6f7de95a89bddd0a549944ba770612ddc3431500132d0a0e";
	private static final String secret = "31ec8b813a27631eccb84e17";
	private static final String content_type = "application/json";
	private static final String fnx_header = "{\"identity\":{\"userRoles\":[\"developer\"]}}";
	
	public static String finxactGET(String path1,String path2)
	{
		String URL = baseURL + path1 + "/v1/" + path2;
	try
		{
		String res = RestAssured.given()
				.header("client_id", client_id)
				.header("secret", secret)
				.header("Content-Type", content_type)
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
	
	public static String finxactPOST(String path1,String path2, String jsonObj)
	{
		String URL = baseURL + path1 + "/v1/" + path2;
		
	try
		{
		String res = RestAssured.given()
				.header("client_id", client_id)
				.header("secret", secret)
				.header("Content-Type", content_type)
				.header("Fnx-Header", fnx_header)
				.body(jsonObj)
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
