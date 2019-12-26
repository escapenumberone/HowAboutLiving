package com.howaboutliving.batch.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Scanner;
import java.util.regex.Matcher;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class EnvironmentReader implements ItemReader<String> {
	@Autowired
	RestTemplate restTemplate;
	
	private static final int NUMOFROWS = 10000;
//	private String sidoStr = "서울,부산,대구,인천,광주,대전,울산,경기,강원,충북,충남,전북,전남,경북,경남,제주,세종"; // 기존 방식
	private String sidoStr = readSidoTxt(); // text 파일을 읽어오는 식으로 변경 
	private int idx = 0;
	private String[] sidoList = sidoStr.split(",");
	
	@Override
	public String read() throws Exception {
		if(idx < sidoList.length)
			return getSidoEnvironmentStr(sidoList[idx]);
		else
			idx = 0;
		
		return null;
	}

	public String getSidoEnvironmentStr(String sidoName) throws Exception {
		URI uri;
		String responseString = "";
		uri = new URI(makeUrl(sidoName));
		responseString = restTemplate.getForObject(uri, String.class);
		Thread.sleep(1000); // open api 블락 방지
		idx++; // Response 제대로 받았을 때만 idx 카운트
		return responseString;
	}
	
	private String makeUrl(String sidoName) throws Exception {
		String sidoEnvironmentURL = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?"
				+ "ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D" // Service Key
				+ "&numOfRows=" + NUMOFROWS + "&pageNo=1" + "&sidoName=" + sidoName + "&_returnType=json"; // 도시이름 및 const값 설정
		StringBuilder urlBuilder = new StringBuilder(sidoEnvironmentURL); /* URL */
		return urlBuilder.toString();
	}
	
	public String readSidoTxt() {

		String sidoStr = "";
		
		String sidoTxtFilePath = new File("").getAbsolutePath() + "\\src\\main\\resources\\sidoTxtFile.txt";
		// 자동으로 변환해주는 구분자로 윈도우와 리눅스 둘 다 해주려고 했지만 프로젝트 경로가 달라서 안됨.
		String str = sidoTxtFilePath.replaceAll(Matcher.quoteReplacement(File.separator), "/");
		File file = new File(str);
		Scanner sc;
		
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				sidoStr += sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return sidoStr;
	}

}
