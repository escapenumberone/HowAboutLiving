package com.howaboutliving.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;

import com.howaboutliving.dto.PublicDataEnvironment;

public interface PublicDataEnvironmentService {

	void insertPublicDataEnvironmentService() throws ClientProtocolException, IOException;

	String getEmptyMsrstnListStr() throws IOException;

	int getTotalCountOfMsrstnList() throws IOException;

	String getPublicDataEnvironment() throws ClientProtocolException, IOException;

	String getMsrstnListStr(CloseableHttpClient httpClient, String MsrstnListURL)
			throws ClientProtocolException, IOException;

	PublicDataEnvironment setFirstEnvironment(String stationName, String addr) throws IOException;

	String getFirstEnvironmentStr(String stationName) throws IOException;

	
}
