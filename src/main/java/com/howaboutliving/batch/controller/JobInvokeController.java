package com.howaboutliving.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@RestController
public class JobInvokeController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job environmentJob;
	
	@Autowired
	Job disasterJob;
	
//	@Scheduled(cron = "0 0 */1 * * *")  // 매시 0분 0초에 실행(1시간 주기로 업데이트)
	@RequestMapping("/test1")
	public void publicDataEnvironmentBatch() {
		System.out.println("배치 잡 시작");
		System.out.println("환경 데이터 업데이트 시작");
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
		.toJobParameters();
		try {
			jobLauncher.run(environmentJob, jobParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Scheduled(cron = "0 0 0 */1 * *")  // 매일 0시 0분 0초에 실행(1일 주기로 업데이트)
	public void publicDataDisasterBatch() {
		System.out.println("배치 잡 시작");
		System.out.println("재해 데이터 업데이트 시작");
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
		.toJobParameters();
		try {
			jobLauncher.run(disasterJob, jobParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
