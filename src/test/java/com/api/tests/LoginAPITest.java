package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.services.AuthenticationService;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {

	@Test
	public void testLogin() {
		LoginRequest loginRequest = new LoginRequest("username", "password");
		AuthenticationService authService = new AuthenticationService();
		Response response = authService.login(loginRequest); // Jackson is doing serialization internally
		LoginResponse loginResponse = response.as(LoginResponse.class); // De-serialiation
		System.out.println(loginResponse.toString());
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getType(), "Bearer");
		Assert.assertEquals(loginResponse.getId(), 86);
	}

}
