package com.shoppingcart.tree.authanticate.Entity;

public class response {
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public response(String jwt) {
		super();
		this.jwt = jwt;
	}	
}
