package com.howaboutliving.batch.reader;

import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.howaboutliving.batch.exception.MyResourceAccessException;
import com.howaboutliving.batch.exception.MyTimeoutException;

public class EnvironmentReader implements ItemReader<String> {
	private static final int NUMOFROWS = 10000;
	private String sidoStr = "서울,부산,대구,인천,광주,대전,울산,경기,강원,충북,충남,전북,전남,경북,경남,제주,세종";
	private int idx = 0;
	private String[] sidoList = sidoStr.split(",");
	@Autowired
	RestTemplate restTemplate;
	
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
		
		idx++; // Response 제대로 받았으면 idx 올려줌
		
//		try {
//			
////			Thread.sleep(1000); // open api 서버 블락 방지
//		} catch (URISyntaxException e) {
//			System.out.println("URI 문법 에러");
//			e.printStackTrace();
//		} catch (ResourceAccessException e) {
//			System.out.println("1");
//			throw new MyResourceAccessException();
//		} catch (SocketTimeoutException e) {
//			System.out.println("2");
//			throw new MyTimeoutException();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			System.out.println("3");
//			e.printStackTrace();
//		}
		
		return responseString;
	}
	
	private String makeUrl(String sidoName) throws Exception {
		System.out.println("도시이름 : " + sidoName);
		String sidoEnvironmentURL = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?"
				+ "ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D"
				+ "&numOfRows=" + NUMOFROWS + "&pageNo=1" + "&sidoName=" + sidoName + "&_returnType=json";
		StringBuilder urlBuilder = new StringBuilder(sidoEnvironmentURL); /* URL */
		return urlBuilder.toString();
	}

}
