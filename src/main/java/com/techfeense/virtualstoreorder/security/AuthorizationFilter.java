package com.techfeense.virtualstoreorder.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter {
	String ROLE_PREFIX = "ROLE_";
	private final Environment environment;
	
	public AuthorizationFilter(AuthenticationManager authenticationManager, Environment environment) {
		super(authenticationManager);
		this.environment = environment;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String authorizationHeader = request.getHeader(environment.getProperty("authorization.token.header.name"));
		if(authorizationHeader == null || !authorizationHeader.startsWith(environment.getProperty("authorization.token.header.prefix"))) {
			chain.doFilter(request, response);
			return;
		}
		UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
		String authorizationHeader = req.getHeader(environment.getProperty("authorization.token.header.name"));
		if(authorizationHeader == null) {
			return null;
		}
		String token = authorizationHeader.replace(environment.getProperty("authorization.token.header.prefix"), "");
		
		Claims claims = Jwts.parser()
				.setSigningKey(environment.getProperty("token.secret"))
				.parseClaimsJws(token)
				.getBody();
		
		Object userId = claims.get("subject");
		
		if(userId == null) {
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(userId.toString(), null, new ArrayList<GrantedAuthority>());
	}
	
}
