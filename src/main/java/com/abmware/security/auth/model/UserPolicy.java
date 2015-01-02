package com.abmware.security.auth.model;

import java.util.List;

public class UserPolicy {
	
	private String gmId;
	
	private List<UserPolicyAction> policyActions;

	public String getGmId() {
		return gmId;
	}

	public void setGmId(String gmId) {
		this.gmId = gmId;
	}

	public List<UserPolicyAction> getPolicyActions() {
		return policyActions;
	}

	public void setPolicyActions(List<UserPolicyAction> policyActions) {
		this.policyActions = policyActions;
	}
	
	

}
