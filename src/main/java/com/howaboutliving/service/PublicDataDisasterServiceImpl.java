package com.howaboutliving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howaboutliving.dao.PublicDataDisasterDao;

@Service
public class PublicDataDisasterServiceImpl implements PublicDataDisasterService{
	@Autowired
	PublicDataDisasterDao dDao;
	
}
