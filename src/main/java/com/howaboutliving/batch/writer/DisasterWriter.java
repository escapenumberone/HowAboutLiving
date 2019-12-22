package com.howaboutliving.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.howaboutliving.dao.PublicDataDisasterDao;
import com.howaboutliving.dto.PublicDataDisaster;

public class DisasterWriter implements ItemWriter<List<PublicDataDisaster>>{

	@Autowired
	PublicDataDisasterDao dDao;
	
	@Override
	public void write(List<? extends List<PublicDataDisaster>> items) throws Exception {
		System.out.println("라이터 시작");
		for (List<PublicDataDisaster> list : items) {
			dDao.insertPublicDataDisaster(list);
		}
		System.out.println("재해 데이터 업데이트 완료");
	}
}
