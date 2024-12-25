package com.api.services;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	// Base URI
	// Create Request
	// Handle Response

	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecs;

	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		requestSpecs = given().baseUri(BASE_URL);
	}

	public void setAuthToken(String token) {
		requestSpecs.header("Authorization", "Bearer " + token);
	}

	protected Response getRequest(String endpoint) {
		return requestSpecs.get(endpoint);
	}

	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecs.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecs.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

}
