package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private MyAuthenticationProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin();//Form based authentication
		http.httpBasic();  //Basic Authentication
		http.authorizeRequests().anyRequest().authenticated();
	}

	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
