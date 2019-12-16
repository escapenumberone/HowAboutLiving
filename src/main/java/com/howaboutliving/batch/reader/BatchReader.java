package com.howaboutliving.batch.reader;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Configuration
public class BatchReader implements ItemReader<String> {
	private static final int NUMOFROWS = 10000;
	private String sidoStr = "서울,부산,대구,인천,광주,대전,울산,경기,강원,충북,충남,전북,전남,경북,경남,제주,세종";
	private int idx = 0;
	private String[] sidoList = sidoStr.split(",");

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		// reader : 데이터를 일단 17개 시도에 있는것들 다 읽어와서 파싱해

		// processor : 파싱한 데이터들 중 업데이트할 데이터만 추려내

		// writer : 추려낸 데이터를 디비에 적재
		if(idx < sidoList.length)
			return getSidoEnvironmentStr(sidoList[idx++]);
		else
			idx = 0;
		
		return null;
	}

	public String getSidoEnvironmentStr(String sidoName) throws InterruptedException {

		RestTemplate restTemplate = new RestTemplate();
		String sidoEnvironmentURL = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D"
				+ "&numOfRows=" + NUMOFROWS + "&pageNo=1" + "&sidoName=" + sidoName + "&_returnType=json";
		URI uri;
		String responseString = "";
		try {
			uri = new URI(sidoEnvironmentURL);
			System.out.println("url : " + sidoEnvironmentURL);
			System.out.println(sidoName + " 정보");
			responseString = restTemplate.getForObject(uri, String.class);
			Thread.sleep(1000);
		} catch (URISyntaxException e) {
			System.out.println("open api 서버 연결 에러");
			e.printStackTrace();
		}
		return responseString;
	}

}