package com.howaboutliving.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.dto.Test;
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

	@RequestMapping("/insert")
	String insert() {
		tService.insert();
		return "im insert";
	}
	
	@RequestMapping("insertlist")
	String insertList() {
		tService.insertList();
		return "im insertList";
	}

	@RequestMapping("/test")
	String test() {
		List<Test> list = new ArrayList<>();
		list = tService.getList();

		for (int i = 0; i < list.size(); i++) {
			System.out.println("SEQ : " + list.get(i).getSEQ());
			System.out.println("ITEMID : " + list.get(i).getITEMID());
		}

		return "im testman";
	}

//	@RequestMapping("/save")
//	String save() {
//		tService.save();
//		return "im save";
//	}
}
