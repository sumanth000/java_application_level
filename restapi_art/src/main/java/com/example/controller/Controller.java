package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/get")
	public String method() {
		return "status of health is good,application is running";
	}

}
