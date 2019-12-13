package com.howaboutliving.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.service.PublicDataEnvironmentService;

@RestController
@SpringBootApplication
@EnableScheduling
public class PublicDataEnvironmentController {
	
	@Autowired
	PublicDataEnvironmentService publicDataEnvironmentService;
	
//	@Scheduled(cron = "0 0/1 * * * *")
//	public String envSave() throws ClientProtocolException, IOException, InterruptedException {
//		publicDataEnvironmentService.insertPublicDataEnvironmentService();
//		return "환경 저장 완료";
//	}
	
	@RequestMapping("/resttemplatetest")
	public String restTemplate() throws ClientProtocolException, IOException, InterruptedException {
		publicDataEnvironmentService.insertPublicDataEnvironmentService();
		return "레스트 템플릿 테스트";
	}
}
