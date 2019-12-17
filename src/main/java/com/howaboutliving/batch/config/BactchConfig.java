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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.howaboutliving.batch.listener.JobCompletionListener;
import com.howaboutliving.batch.processor.BatchProcessor;
import com.howaboutliving.batch.reader.BatchReader;
import com.howaboutliving.batch.writer.BatchWriter;
import com.howaboutliving.dto.PublicDataEnvironment;

@Configuration
@EnableBatchProcessing
public class BactchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job environmentJob() {
		return jobBuilderFactory.get("environment-job").start(environmentStep()).listener(listener()).build();
	}

	@Bean
	public Step environmentStep() {
		return stepBuilderFactory.get("environment-step").<String, List<PublicDataEnvironment>>chunk(20)
				.reader(batchReaderStep()).processor(batchProcessorStep()).writer(batchWriterStep()).build();
	}

	@Bean
	ItemReader<String> batchReaderStep() {
		return new BatchReader();
	}

	@Bean
	ItemProcessor<String, List<PublicDataEnvironment>> batchProcessorStep() {
		return new BatchProcessor();
	}

	@Bean
	ItemWriter<List<PublicDataEnvironment>> batchWriterStep() {
		return new BatchWriter();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}
