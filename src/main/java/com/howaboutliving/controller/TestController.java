package com.howaboutliving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.service.TestService;

@RestController
@SpringBootApplication
public class TestController {
	@Autowired
	TestService tService;

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/save")
	String save() {
		tService.save();
		return "im save";
	}
}
