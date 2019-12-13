package com.howaboutliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.howaboutliving.dto.PublicDataDisaster;
import com.howaboutliving.dto.PublicDataEnvironment;

@Repository
public interface TestDao {
	void save(List<PublicDataDisaster> list);
	void insertPublicDataEnvironment(PublicDataEnvironment publicDataEnvironment);
}
