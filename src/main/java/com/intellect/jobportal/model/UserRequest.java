package com.intellect.jobportal.model;

import com.intellect.jobportal.model.common.BaseRequest;

public class UserRequest extends BaseRequest{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
