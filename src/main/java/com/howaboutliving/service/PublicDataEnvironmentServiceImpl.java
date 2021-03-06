package com.howaboutliving.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howaboutliving.dao.PublicDataEnvironmentDao;
import com.howaboutliving.dto.PublicDataEnvironment;
import com.howaboutliving.dto.PublicDataEnvironmentDailyAvg;

@Service
public class PublicDataEnvironmentServiceImpl implements PublicDataEnvironmentService {

	@Autowired
	public PublicDataEnvironmentDao eDao;

	public void insertDailyAvgEnvironmentByOneDaysAgo() { // 일 평균 데이터 넣는 로직
		eDao.insertDailyAvgEnvironmentByOneDaysAgo(oneDaysAgoStr());
	}

	public String oneDaysAgoStr() { // 하루 전 날짜 구해오는 로직
		LocalDateTime now = LocalDateTime.now();
		return now.minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	@Override
	public List<PublicDataEnvironmentDailyAvg> selectSevenDaysDailyAvgEnvironmentByStationName(String stationName) { // 7일간의 평균 데이터 구해오는 로직
		return eDao.selectSevenDaysDailyAvgEnvironmentByStationName(stationName);
	}

	@Override
	public List<PublicDataEnvironment> selectRealtimeEnvironmentByStationName(String stationName) { // 현재위치 실시간 환경 데이터 받아오는 로직
		return eDao.selectRealtimeEnvironmentByStationName(stationName);
	}

	public void insertPublicDataEnvironmentAvg() { // 에러가 났을 때 이전데이터들의 평균 데이터를 적재하는 로직
		realtimeEnvironmentDelete();
		eDao.insertPublicDataEnvironmentAvg(nowDaysHourStr());
		eDao.insertPublicDataRealtimeEnvironmentAvg(nowDaysHourStr());
	}

	public String nowDaysHourStr() { // 현재 시간대를 구해오는 로직
		LocalDateTime now = LocalDateTime.now();
		String nowDaysHour = now.format(DateTimeFormatter.ofPattern("HH:00"));
		return nowDaysHour;
	}
	
	private void realtimeEnvironmentDelete() { // 실시간 데이터 삭제하는 로직
		eDao.deleteRealtimeEnvironment(); // 데이터 전부 삭제
		eDao.autoIncrementResetRealtimeEnvironment(); // auto increment 리셋
	}

}
