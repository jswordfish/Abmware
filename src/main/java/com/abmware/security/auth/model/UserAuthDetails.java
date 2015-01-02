package com.abmware.security.auth.model;

public class UserAuthDetails {

	private boolean authenticated;
	
	UserPolicy userPolicy;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public UserPolicy getUserPolicy() {
		return userPolicy;
	}

	public void setUserPolicy(UserPolicy userPolicy) {
		this.userPolicy = userPolicy;
	}
	
	
}
