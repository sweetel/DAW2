package com.example.example_auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/hello")
	public ResponseEntity<?> hello() {
		return ResponseEntity.ok("Hello world! (example_auth)");
	}
	
	@GetMapping("/hello-private")
	public ResponseEntity<?> helloPrivate() {
		return ResponseEntity.ok("Hello world private! (example_auth)");
	}
}
