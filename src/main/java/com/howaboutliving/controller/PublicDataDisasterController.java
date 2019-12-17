package com.howaboutliving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.service.PublicDataDisasterService;

/**
 * 
 * 삭제 예정
 *
 */

@RestController
public class PublicDataDisasterController {
	
	@Autowired
	PublicDataDisasterService dService;

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/save")
	String save() {
		dService.save();
		return "im save";
	}
}
