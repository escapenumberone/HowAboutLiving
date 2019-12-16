package com.howaboutliving.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.howaboutliving.tasks.MyTaskOne;
import com.howaboutliving.tasks.MyTaskTwo;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
     
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
 
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
     
    @Bean
    public Step stepOne(){
        return stepBuilderFactory.get("stepOne")
                .tasklet(new MyTaskOne())
                .build();
    }
     
    @Bean
    public Step stepTwo(){
        return stepBuilderFactory.get("stepTwo")
                .tasklet(new MyTaskTwo())
                .build();
    }   
     
    @Bean
    public Job demoJob(){
        return jobBuilderFactory.get("demoJob")
	                .start(stepOne())
	                .next(stepTwo())
	                .build();
    }
    
    
}
