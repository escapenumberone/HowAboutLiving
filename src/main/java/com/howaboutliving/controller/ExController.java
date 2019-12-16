package com.howaboutliving.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExController {
	
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job simpleJobOk;
	
	@GetMapping("/invokejob")
	public void handle() {
		System.out.println("배치 실행 됨");
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
		.toJobParameters();
		try {
			jobLauncher.run(simpleJobOk, jobParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
