package com.howaboutliving.dao;

import org.springframework.stereotype.Repository;

import com.howaboutliving.dto.PublicDataEnvironment;

@Repository
public interface PublicDataEnvironmentDao {
//	void insertPublicDataEnvironment(PublicDataEnvironment publicDataEnvironment);
	void insertPublicDataEnvironment(String str);
	void insertPublicDataEnvironmentAvg(String str);
	void hehe(String str);
//	void deletePublicDataEnvironment();
//	void autoIncrementReset();
}
