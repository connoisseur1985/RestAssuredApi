package com.qa.test;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.ApiClient;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class apiTestGetCall extends TestBase{

	String url;
	ApiClient apiClient;
	Response response;
	
	public apiTestGetCall() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws IOException 
	{
		url = prop.getProperty("baseUrl")+prop.getProperty("serviceUrl");
		apiClient = new ApiClient();
		response = apiClient.getCallWithoutHeaders(url);
	}
	@Test(groups= {"sanity,regression"})
	public void verifyGetCallStatus() 
	{
		//response = apiClient.getCallWithoutHeaders(url);
		System.out.println("Status is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void verifyGetCallBody() 
	{
		String responseString = response.getBody().asString();
	
		System.out.println(responseString);
		
		System.out.println(response.jsonPath().get("WeatherDescription"));
		
		Assert.assertEquals(response.jsonPath().get("WindDirectionDegree"), "230 Degree", "Response is incorrect ");
	
	}
	
	@Test
	public void verifyHeadersGetCall() 
	{
		System.out.println(response.headers());
		System.out.println(response.header("Content-Type"));
	}
	

}
