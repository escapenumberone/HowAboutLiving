package com.howaboutliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.howaboutliving.dto.EnvironmentDailyAvg;
import com.howaboutliving.dto.PublicDataEnvironment;

@Repository
public interface PublicDataEnvironmentDao {
	void insertPublicDataEnvironment(PublicDataEnvironment publicDataEnvironment);
//	void deletePublicDataEnvironment();
//	void autoIncrementReset();
	List<EnvironmentDailyAvg> selectDaliyAvgEnvironment();
	void insertOneDailyAvgEnvironment(String oneDaysAgo);
	void hehe(String str);
}
