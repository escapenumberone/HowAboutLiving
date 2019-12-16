package com.howaboutliving.batch.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.howaboutliving.batch.processor.BatchProcessor;
import com.howaboutliving.batch.reader.BatchReader;
import com.howaboutliving.batch.writer.BatchWriter;
import com.howaboutliving.dto.PublicDataEnvironment;

@Configuration
@EnableBatchProcessing
public class JYBatchConfig {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Primary
	@Bean
	public Job jYBatchJob() {
		return jobBuilderFactory.get("simpleJobOk")
				.start(simpleStepOk()).build();
	}
	
	@Bean
	public Step simpleStepOk() {
		return stepBuilderFactory.get("simple-step")
				.<String, List<PublicDataEnvironment>> chunk(1)
				.reader(new BatchReader())
				.processor(new BatchProcessor())
				.writer(new BatchWriter())
				.build();
	}
	
}