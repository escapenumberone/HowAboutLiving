package com.howaboutliving.batch.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.howaboutliving.batch.exception.MyException;
import com.howaboutliving.batch.listener.JobCompletionListener;
import com.howaboutliving.batch.processor.DisasterProcessor;
import com.howaboutliving.batch.processor.EnvironmentProcessor;
import com.howaboutliving.batch.reader.DisasterReader;
import com.howaboutliving.batch.reader.EnvironmentReader;
import com.howaboutliving.batch.writer.DisasterWriter;
import com.howaboutliving.batch.writer.EnvironmentWriter;
import com.howaboutliving.dto.PublicDataDisaster;
import com.howaboutliving.dto.PublicDataEnvironment;
import com.howaboutliving.service.PublicDataEnvironmentService;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public PublicDataEnvironmentService eService;

	@Bean
	public Job environmentJob() {
		return jobBuilderFactory.get("environment-job").start(environmentStep()).listener(listener()).build();
	}
	
	@Bean
	public Job disasterJob() {
		return jobBuilderFactory.get("disaster-job").start(disastertStep()).listener(listener()).build();
	}
	
	@Bean
	public Step environmentStep() {
		return stepBuilderFactory.get("environment-step").<String, List<PublicDataEnvironment>>chunk(20)
				.reader(envrionmentReader()).processor(envrionmentProcessor()).writer(envrionmentWriter()).build();
	}
	
	@Bean
	public Step disastertStep() {
		return stepBuilderFactory.get("disaster-step").<String, List<PublicDataDisaster>>chunk(20)
				.reader(disasterReader()).faultTolerant().skipLimit(3).skip(MyException.class).processor(disasterProcessor()).writer(disasterWriter()).build();
	}
	
	
	@Bean
	public Job environmentDailyAvgJob() {
		return jobBuilderFactory.get("environmentDailyAvg-Job").start(environmentDailyAvgStep()).build();
	}

	@Bean
	public Step environmentDailyAvgStep() {
		return stepBuilderFactory.get("environmentDailyAvg-Step").tasklet((contribution, chunkContext) -> {
			System.out.println("Start Avg");
			eService.insertOneDailyAvgEnvironment();
			return RepeatStatus.FINISHED;
		}).build();
	}
	
	
	@Bean
	ItemReader<String> envrionmentReader() {
		return new EnvironmentReader();
	}
	
	@Bean
	ItemReader<String> disasterReader() {
		return new DisasterReader();
	}
	
	@Bean
	ItemProcessor<String, List<PublicDataEnvironment>> envrionmentProcessor() {
		return new EnvironmentProcessor();
	}
	
	@Bean
	ItemProcessor<String, List<PublicDataDisaster>> disasterProcessor() {
		return new DisasterProcessor();
	}

	@Bean
	ItemWriter<List<PublicDataEnvironment>> envrionmentWriter() {
		return new EnvironmentWriter();
	}
	
	@Bean
	ItemWriter<List<PublicDataDisaster>> disasterWriter() {
		return new DisasterWriter();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}
