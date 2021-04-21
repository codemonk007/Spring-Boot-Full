package com.shoppingcart.tree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.tree.authanticate.jwt;
import com.shoppingcart.tree.authanticate.my_userDetails;
import com.shoppingcart.tree.authanticate.Entity.request;
import com.shoppingcart.tree.authanticate.Entity.response;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class authController {
	
	@Autowired
	public AuthenticationManager _AuthenticationManager;

	@Autowired
	public my_userDetails _MyUserDetailsService;

	@Autowired
	private jwt _jwt;

	@RequestMapping(value = "/auth" ,method = RequestMethod.POST)	
	public ResponseEntity<?> auth(@RequestBody request _AuthRequest){
		System.out.println("hi hello there ");
		_AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken( _AuthRequest.getUsername(),_AuthRequest.getPassword()));
		
		final UserDetails _UserDetails = _MyUserDetailsService.loadUserByUsername(_AuthRequest.getUsername());
		final String jwt = _jwt.generateToken(_UserDetails);
		return ResponseEntity.ok(new response(jwt));
	}
}
