package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateUserRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserDetailsResponse;
import com.api.services.AuthenticationService;
import com.api.services.UserManagementServices;

import io.restassured.response.Response;

public class UpdateUserDetailsTest {
	@Test
	public void updateUserDetails() {
		
		UpdateUserRequest updateUserRequest = new UpdateUserRequest.Builder()
				.firstName("xyz1")
				.email("hsgdfs@hjbdsnmf.com")
				.lastName("assdf")
				.mobileNumber("4598756321").build();
		
		LoginRequest loginRequest = new LoginRequest("username", "password");
		AuthenticationService authService = new AuthenticationService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		UserManagementServices userManagementService = new UserManagementServices();
		userManagementService.setAuthToken(loginResponse.getToken());
		response = userManagementService.updateUserDetails(updateUserRequest);
		System.out.println(response.asPrettyString());
		UserDetailsResponse userDetailsResponse = response.as(UserDetailsResponse.class);
		Assert.assertEquals(userDetailsResponse.getId(), 86);
		Assert.assertEquals(userDetailsResponse.getFirstName(), "xyz1");
	}

}
