package com.howaboutliving.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.howaboutliving.dao.PublicDataEnvironmentDao;
import com.howaboutliving.dto.PublicDataEnvironment;

public class EnvironmentWriter implements ItemWriter<List<PublicDataEnvironment>>{

	@Autowired
	PublicDataEnvironmentDao eDao;
	
	@Override
	public void write(List<? extends List<PublicDataEnvironment>> items) throws Exception {
//		publicDataEnvironmentDelete();
		for (List<PublicDataEnvironment> list : items) {
			for (int i = 0; i < list.size(); i++) {
//				eDao.insertPublicDataEnvironment(list.get(i));
			}
		}
		System.out.println("환경 데이터 업데이트 완료");
	}
	
	private void publicDataEnvironmentDelete() {
//		eDao.deletePublicDataEnvironment(); // 데이터 전부 삭제
//		eDao.autoIncrementReset(); // auto increment 리셋
	}
}
