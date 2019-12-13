package com.howaboutliving.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.howaboutliving.batch.listener.JobCompletionListener;
import com.howaboutliving.batch.processor.BatchProcessor;
import com.howaboutliving.batch.reader.BatchReader;
import com.howaboutliving.batch.writer.BatchWriter;

@Configuration
@EnableBatchProcessing
public class BactchConfig {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("simple-job")
				.start(simpleStep1()).listener(listener()).build();
	}
	
	@Bean
	public Job processJobSecond() {
		return jobBuilderFactory.get("simple-job-second")
				.start(simpleStep1()).listener(listener()).build();
	}
	
	@Bean
	public Step simpleStep1() {
		return stepBuilderFactory.get("simple-step").<String, String> chunk(1)
				.reader(new BatchReader()).processor(new BatchProcessor())
				.writer(new BatchWriter()).build();
	}
	
	@Bean
	public Step simpleStep2() {
		return stepBuilderFactory.get("simple-step-second").<String, String> chunk(1)
				.reader(new BatchReader()).processor(new BatchProcessor())
				.writer(new BatchWriter()).build();
	}
	
	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
	
}
