package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = { "com.example.service","com.example.controller" ,"com.example.vo"  })
//@SpringBootApplication
public class RestapiArtApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiArtApplication.class, args);
	}

}
