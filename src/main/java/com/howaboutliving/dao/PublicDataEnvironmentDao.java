package com.howaboutliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.howaboutliving.dto.PublicDataEnvironmentDailyAvg;
import com.howaboutliving.dto.PublicDataEnvironment;

@Repository
public interface PublicDataEnvironmentDao {
	
	void insertPublicDataEnvironment(PublicDataEnvironment publicDataEnvironment);
	
	void insertRealtimeEnvironment(PublicDataEnvironment publicDataEnvironment);
	void deleteRealtimeEnvironment();
	void autoIncrementResetRealtimeEnvironment();
	List<PublicDataEnvironment> selectRealtimeEnvironmentByStationName(String stationName);
	
	void insertOneDailyAvgEnvironment(String oneDaysAgo);
	
	List<PublicDataEnvironmentDailyAvg> selectSevenDaysDailyAvgEnvironmentByStationName(String stationName);
	
	void insertPublicDataEnvironment(String str);
	void insertPublicDataEnvironmentAvg(String str);
	void insertPublicDataRealtimeEnvironmentAvg(String str);
}
