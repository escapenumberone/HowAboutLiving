package com.howaboutliving.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.howaboutliving.dto.PublicDataEnvironment;
import com.howaboutliving.dto.PublicDataEnvironmentDailyAvg;

@Service
public interface PublicDataEnvironmentService {
	List<PublicDataEnvironmentDailyAvg> selectSevenDaysDailyAvgEnvironmentByStationName(String stationName);
	
	void insertOneDailyAvgEnvironment();

	List<PublicDataEnvironment> selectRealtimeEnvironmentByStationName(String stationName);

	void insertPublicDataEnvironmentAvg();

}
