package com.howaboutliving.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;

import com.howaboutliving.dto.PublicDataEnvironment;

public interface PublicDataEnvironmentService {

	void insertPublicDataEnvironmentService() throws ClientProtocolException, IOException, InterruptedException;

	String getSidoEnvironmentStr(String sidoName) throws IOException;

	String setSidoEnvironment(String sidoName) throws IOException;

	
	
}
