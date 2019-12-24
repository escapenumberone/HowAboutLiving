package com.howaboutliving.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.howaboutliving.dto.EnvironmentDailyAvg;

@Service
public interface PublicDataEnvironmentService {
	String setSidoEnvironment(String sidoName) throws IOException;

	String getSidoEnvironmentStr(String sidoName) throws IOException;

	void insertPublicDataEnvironmentService() throws ClientProtocolException, IOException, InterruptedException;

	void insertOneDailyAvgEnvironment();
}
