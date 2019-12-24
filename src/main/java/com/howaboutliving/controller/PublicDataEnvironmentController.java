package com.howaboutliving.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.service.PublicDataEnvironmentService;

/**
 * 
 * 삭제 예정
 *
 */

@RestController
public class PublicDataEnvironmentController {
	
	@Autowired
	PublicDataEnvironmentService eService;
	
	@RequestMapping("/resttemplatetest")
	public String restTemplate() throws ClientProtocolException, IOException, InterruptedException {
		eService.insertPublicDataEnvironmentService();
		return "레스트 템플릿 테스트";
	}
	
	@RequestMapping("/nowdays")
	public String nowDays() {
		eService.insertPublicDataEnvironmentAvg();
		return "현재시간";
	}
}
