package com.example.demo.security;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		if(username.equals("gyeldi") && password.equals("mypassword")) {
			new UsernamePasswordAuthenticationToken(username, password,Arrays.asList());
		}else {
			throw new BadCredentialsException("Invalid credentials.");
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
