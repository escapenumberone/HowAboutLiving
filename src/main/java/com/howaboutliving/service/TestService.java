package com.howaboutliving.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.howaboutliving.dto.Test;

@Service
public interface TestService {
	
	List<Test> getList();
	void insert();
	void insertList();
	void save();
	
}
