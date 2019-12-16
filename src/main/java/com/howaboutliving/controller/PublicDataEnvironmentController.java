package com.howaboutliving.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.dto.PublicDataEnvironment;
import com.howaboutliving.service.PublicDataEnvironmentService;

@RequestMapping("/environment")
@RestController
public class PublicDataEnvironmentController {

	private PublicDataEnvironmentService publicDataEnvironmentService;
	
	@Autowired
	public void setPublicDataEnvironmentService(PublicDataEnvironmentService publicDataEnvironmentService) {
		this.publicDataEnvironmentService = publicDataEnvironmentService;
	}
	
	@GetMapping("/add")
	public void addPublicDataEnvironment() throws ClientProtocolException, IOException, InterruptedException {
		publicDataEnvironmentService.insertPublicDataEnvironmentService();
	}
	
	@GetMapping("/add2")
	public void addPublicDataEnvironmentTwo(@RequestBody PublicDataEnvironment envo) {
		System.out.println(envo);
	}
	
}
