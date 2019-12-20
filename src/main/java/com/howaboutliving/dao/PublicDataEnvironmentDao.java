package com.howaboutliving.dao;

import org.springframework.stereotype.Repository;

import com.howaboutliving.dto.PublicDataEnvironment;

@Repository
public interface PublicDataEnvironmentDao {
	void insertPublicDataEnvironment(PublicDataEnvironment publicDataEnvironment);
//	void deletePublicDataEnvironment();
//	void autoIncrementReset();
}
