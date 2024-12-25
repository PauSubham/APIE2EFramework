package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.request.SignUpRequest;
import com.api.services.AuthenticationService;

import io.restassured.response.Response;

public class SignUpTest {

	@Test
	public void testSignUp() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.username("Scdhau_233dfs")
				.password("acgd53")
				.mobileNumber("9465735420")
				.email("hfd3hcds@sd.com")
				.firstName("dsjdbsmdds")
				.lastName("khdfndfd")
				.build();
		
		AuthenticationService authService = new AuthenticationService();
		Response response = authService.signup(signUpRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getBody().asPrettyString(), "User registered successfully!");
	}

}
