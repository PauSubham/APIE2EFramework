package com.api.services;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthenticationService extends BaseService {

	private static final String BASE_PATH = "/api/auth/";

	public Response login(LoginRequest payload) {

		return postRequest(payload, BASE_PATH + "login");

	}
	
	public Response signup(SignUpRequest payload) {
		return postRequest(payload, BASE_PATH + "signup");
	}
	
	public Response forgotPassword(String emailAddress) {
		HashMap<String, String> payload = new HashMap<String, String>(); // We are not creating any POJO class as we need to pass only 1 node
		payload.put("email", emailAddress);
		return postRequest(payload, BASE_PATH + "forgot-password");
	}

}
