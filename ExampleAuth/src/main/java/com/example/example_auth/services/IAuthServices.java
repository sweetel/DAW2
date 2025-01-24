package com.example.example_auth.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface IAuthServices {

	String login(String name, String password) throws Exception;

	String register (String name, String password);
	UserDetails loadUserDetails(String name);
}
