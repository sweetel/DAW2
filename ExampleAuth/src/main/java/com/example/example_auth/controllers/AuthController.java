package com.example.example_auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.example_auth.services.IAuthServices;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private IAuthServices authServices;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		try {
			String result = authServices.login(loginDto.getName(), loginDto.getPassword());
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body("Error en el login");
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody LoginDto loginDto) {
		try {
			String result = authServices.register(loginDto.getName(), loginDto.getPassword());
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body("Error en el login");
		}
	}
}

class LoginDto {
	private String name;
	private String password;
	
	public LoginDto() {	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
