package com.howaboutliving.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.howaboutliving.dto.PublicDataEnvironmentDailyAvg;
import com.howaboutliving.dto.PublicDataEnvironment;

@Service
public interface PublicDataEnvironmentService {
	String setSidoEnvironment(String sidoName) throws IOException;

	String getSidoEnvironmentStr(String sidoName) throws IOException;

	void insertPublicDataEnvironmentService() throws ClientProtocolException, IOException, InterruptedException;

	List<PublicDataEnvironmentDailyAvg> selectSevenDaysDailyAvgEnvironmentByStationName(String stationName);
	
	void insertDailyAvgEnvironmentByOneDaysAgo();

	List<PublicDataEnvironment> selectRealtimeEnvironmentByStationName(String stationName);

	void insertPublicDataEnvironmentAvg();

	void alarmToDev(String string);
}
