package com.howaboutliving.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class BatchWriter implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> items) throws Exception {
		for (int i = 0; i < items.size(); i++) {
			System.out.println("Writing the data : " + items.get(i));
		}
	}

}
