package com.howaboutliving.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.howaboutliving.dao.PublicDataEnvironmentDao;
import com.howaboutliving.dto.PublicDataEnvironment;

public class BatchWriter implements ItemWriter<List<PublicDataEnvironment>>{

	@Autowired
	PublicDataEnvironmentDao pded;
	
	@Override
	public void write(List<? extends List<PublicDataEnvironment>> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("총 아이템 크기 : " + items.size());
		for (List<PublicDataEnvironment> list : items) {
			System.out.println("리스트 크기 : " + list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println("데이터(Writer쪽) : " + list.get(i).toString());
				pded.insertPublicDataEnvironment(list.get(i));
				System.out.println();
			}
		}
	}


}