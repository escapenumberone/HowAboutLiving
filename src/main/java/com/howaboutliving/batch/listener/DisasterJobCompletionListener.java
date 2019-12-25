package com.howaboutliving.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.howaboutliving.service.CommonService;
import com.howaboutliving.service.PublicDataEnvironmentService;

public class DisasterJobCompletionListener extends JobExecutionListenerSupport {
	
	@Autowired
	CommonService cService;
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("재해 데이터 배치 잡 완료");
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			
			// 메일 보내는 로직
			cService.alarmToDev("재해 데이터 읽어오기 실패");
			
			System.out.println("재해 데이터 배치 잡 실패");
		}
	}
}
