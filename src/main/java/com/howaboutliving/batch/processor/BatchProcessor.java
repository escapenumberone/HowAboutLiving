package com.howaboutliving.batch.processor;

import org.springframework.batch.item.ItemProcessor;

public class BatchProcessor implements ItemProcessor<String, String> {
	@Override
	public String process(String item) throws Exception {
		return item.toUpperCase();
	}
	
}
