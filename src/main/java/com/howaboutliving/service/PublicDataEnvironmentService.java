package com.howaboutliving.service;

import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.apache.http.client.ClientProtocolException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public interface PublicDataEnvironmentService {
	String setSidoEnvironment(String sidoName) throws IOException;

	String getSidoEnvironmentStr(String sidoName) throws IOException;

	void insertPublicDataEnvironmentService() throws ClientProtocolException, IOException, InterruptedException;
	
	void insertPublicDataEnvironmentAvg();
	
	void errAlarmToDev(String str);
}
