package com.howaboutliving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howaboutliving.dao.PublicDataDisasterDao;
import com.howaboutliving.dto.PublicDataDisaster;

@Service
public class PublicDataDisasterServiceImpl implements PublicDataDisasterService{
	
	@Autowired
	PublicDataDisasterDao dDao;

	@Override
	public List<PublicDataDisaster> selectPublicDataDisasterByDsstrRiskLc(String dsstrRiskLc) {
		return dDao.selectPublicDataDisasterByDsstrRiskLc(dsstrRiskLc);
	}
	
	
	
}
