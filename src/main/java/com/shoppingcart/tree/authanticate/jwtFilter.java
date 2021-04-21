package com.shoppingcart.tree.authanticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component
public class jwtFilter extends OncePerRequestFilter{
	
	@Autowired
	public my_userDetails _MyUserDetailsService;
	
	@Autowired
	public jwt _jwt;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 System.out.println("hit0-0-0-0-000--0-0-");

		  Enumeration<String> headerNames = request.getHeaderNames();

		    if (headerNames != null) {
		        while (headerNames.hasMoreElements()) {
		            String name = headerNames.nextElement();
		            System.out.println("Header: " + name + " value:" + request.getHeader(name));
		        }
		    }
	        
			final String autharizationheader = request.getHeader("authorization");	
			System.out.println("autharizationheader-->"+autharizationheader);
			String username = null;
			String jwt = null;
			if(autharizationheader != null && autharizationheader.startsWith("Bearer ")) {
				jwt = autharizationheader.substring(7);
				System.out.println("jwt---->"+jwt);
				username = _jwt.extractUsername(jwt);
			}
			if(username != null && SecurityContextHolder.getContext().getAuthentication() ==  null) {
				UserDetails _Details = this._MyUserDetailsService.loadUserByUsername(username);
				
				if(_jwt.validateToken(jwt, _Details)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							_Details, null, _Details.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods","*");
	        response.setHeader("Access-Control-Allow-Headers","*");
			filterChain.doFilter(request, response);

	}
}
