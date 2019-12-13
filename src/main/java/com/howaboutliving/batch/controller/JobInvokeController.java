package com.howaboutliving.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class JobInvokeController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job processJob;
	
	@Autowired
	Job processJobSecond;
	
//	@Scheduled(cron = "*/5 * * * * *")
//	public void testMan() {
//		System.out.println("테스트 맨");
//	}
//	
//	@Scheduled(cron = "*/5 * * * * *")
	public void handle() {
		System.out.println("배치 실행 됨");
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
		.toJobParameters();
		try {
			jobLauncher.run(processJob, jobParameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Scheduled(cron = "*/15 * * * * *")
	public void handleSecond() {
		System.out.println("두번째 배치 실행 됨");
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
		.toJobParameters();
		try {
			jobLauncher.run(processJobSecond, jobParameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
