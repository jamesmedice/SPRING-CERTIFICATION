package com.medici.app.scope;

public enum BeanScopes {

	singleton("singleton"), prototype("prototype"), request("request"), session("session"), application("application"), websocket("websocket");

	public String scope;

	BeanScopes(String scope) {
		this.scope = scope;
	}

	public String getScope(BeanScopes entity) {
		return entity.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
