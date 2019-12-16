package com.howaboutliving.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class BatchApplication {
	
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job simpleJob;
	
//	@Scheduled(cron = "0 0/1 * * * *")
	public void run() throws Exception {
		JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(simpleJob, params);
	}
}
