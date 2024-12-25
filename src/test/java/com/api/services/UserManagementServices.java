package com.api.services;

import com.api.models.request.UpdateUserRequest;

import io.restassured.response.Response;

public class UserManagementServices extends BaseService {

	private final static String BASE_PATH = "/api/users/";

	public Response getUserDetails() {
		return getRequest(BASE_PATH + "profile");
	}
	
	public Response updateUserDetails(UpdateUserRequest payload) {
		return putRequest(payload, BASE_PATH + "profile");
	}

}
