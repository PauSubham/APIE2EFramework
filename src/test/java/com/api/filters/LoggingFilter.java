package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	public static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// Request is Being made from the test class
		logRequest(requestSpec); // Intercepting the request and getting all the logs
		Response response = ctx.next(requestSpec, responseSpec); // Sending the request to the server
		logResponse(response); // Intercepting the response and getting all the logs
		return response; // Returning the response back to the test method
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI " + requestSpec.getBaseUri());
		logger.info("Request Header " + requestSpec.getHeaders());
		logger.info("Request Payload " + requestSpec.getBody());
	}

	public void logResponse(Response response) {
		logger.info("Status Line " + response.statusLine());
		logger.info("Response Body " + response.getBody().asPrettyString());
		logger.info("Response Header " + response.getHeaders());
	}

}
