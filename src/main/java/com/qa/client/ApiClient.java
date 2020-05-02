package com.qa.client;

import java.io.IOException;

import com.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiClient extends TestBase{

	public ApiClient() throws IOException {
		
		
	}

	public Response getCallWithoutHeaders(String url) 
	{
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET);
		return response;
	}

}
