package com.api.tests;

import org.testng.annotations.Test;

import com.api.services.AuthenticationService;

import io.restassured.response.Response;

public class ForgotPassTest {

	@Test
	public void testForgotPass() {
		AuthenticationService authService = new AuthenticationService();
		Response response = authService.forgotPassword("hfdcds@sd.com");
		System.out.println(response.asPrettyString());
		//Assert.assertEquals(response.getBody().asPrettyString(), "User registered successfully!");
	}
}
