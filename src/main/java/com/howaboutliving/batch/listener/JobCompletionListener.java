package com.howaboutliving.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.howaboutliving.service.PublicDataEnvironmentService;

public class JobCompletionListener extends JobExecutionListenerSupport {
	
	@Autowired
	PublicDataEnvironmentService eService;
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("배치 잡 완료");
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {

			// 평균 저장하는 로직
			eService.insertPublicDataEnvironmentAvg();
			
			// 메일 보내는 로직
			eService.errAlarmToDev("아무개");
			
			System.out.println("배치 잡 실패");
		}
	}
}
