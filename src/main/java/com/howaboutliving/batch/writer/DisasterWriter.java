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
		
		DisasterDelete();
		
		for (List<PublicDataDisaster> list : items) {
			dDao.insertPublicDataDisaster(list);
		}
	}
	
	private void DisasterDelete() {
		dDao.deleteDisaster(); // 데이터 전부 삭제
		dDao.autoIncrementResetDisaster(); // auto increment 리셋
	}
}
