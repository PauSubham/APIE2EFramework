package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserDetailsResponse;
import com.api.services.AuthenticationService;
import com.api.services.UserManagementServices;

import io.restassured.response.Response;

public class GetUserTest {

	@Test
	public void getUserDetailsTest() {
		// first log in & then fetch the user details. 
		//To get the user details we need the token provided at the time of login
		LoginRequest loginRequest = new LoginRequest("username", "password");
		AuthenticationService authService = new AuthenticationService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		UserManagementServices userManagementServices = new UserManagementServices();
		userManagementServices.setAuthToken(loginResponse.getToken());
		response = userManagementServices.getUserDetails();
		System.out.println(response.asPrettyString());
		UserDetailsResponse userDetailsResponse = response.as(UserDetailsResponse.class);
		Assert.assertEquals(userDetailsResponse.getId(), 86);
		Assert.assertEquals(userDetailsResponse.getUsername(), "username");
		Assert.assertEquals(userDetailsResponse.getFirstName(), "Haidar");
	}
}
