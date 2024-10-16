package com.cbs.proyecto1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

}