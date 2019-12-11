package com.howaboutliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.howaboutliving.dto.PublicDataDisaster;
import com.howaboutliving.dto.Test;

@Repository
public interface TestDao {
	List<Test> getList();
	void insert(Test test);
	void insertList(List<Test> list);
	void save(List<PublicDataDisaster> list);
}
