package com.howaboutliving.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.dao.PublicDataEnvironmentDao;
import com.howaboutliving.dto.PublicDataEnvironment;

@Service
public class PublicDataEnvironmentServiceImpl implements PublicDataEnvironmentService{
	private static final int NUMOFROWS = 10000;
	private String sidoStr = "서울,부산,대구,인천,광주,대전,울산,경기,강원,충북,충남,전북,전남,경북,경남,제주,세종";
	private String[] sidoList = sidoStr.split(",");

	@Autowired
	public PublicDataEnvironmentDao eDao;

	@Override
	public String setSidoEnvironment(String sidoName) throws IOException {

		PublicDataEnvironment publicDataEnvironment = null;

		JsonObject parse_Json = JsonParser.parseString(getSidoEnvironmentStr(sidoName)).getAsJsonObject();
		JsonArray parse_list = parse_Json.get("list").getAsJsonArray();
		
		for (int j = 0; j < parse_list.size(); j++) {
			JsonObject parse_obj = (JsonObject) parse_list.get(j);

			publicDataEnvironment = new PublicDataEnvironment(
				0,
				parse_obj.get("stationName").getAsString(),
				parse_obj.get("dataTime").getAsString(),
				parse_obj.get("khaiValue").getAsString(),
				parse_obj.get("so2Value").getAsString(),
				parse_obj.get("coValue").getAsString(),
				parse_obj.get("o3Value").getAsString(),
				parse_obj.get("no2Value").getAsString(),
				parse_obj.get("pm10Value").getAsString(),
				parse_obj.get("pm25Value").getAsString(),
				parse_obj.get("khaiGrade").getAsString(),
				parse_obj.get("so2Grade").getAsString(),
				parse_obj.get("coGrade").getAsString(),
				parse_obj.get("o3Grade").getAsString(),
				parse_obj.get("no2Grade").getAsString(),
				parse_obj.get("pm10Grade").getAsString(),
				parse_obj.get("pm25Grade").getAsString()
			);
			
			eDao.insertPublicDataEnvironment(publicDataEnvironment);
			
		}
		
		JsonObject parse_parm = (JsonObject) parse_Json.get("parm");
		
		return parse_parm.get("resultCode").getAsString();
	}

	@Override
	public String getSidoEnvironmentStr(String sidoName) throws IOException {
		
		RestTemplate restTemplate = new RestTemplate();
		String sidoEnvironmentURL = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D"
				+ "&numOfRows=" + NUMOFROWS + "&pageNo=1" + "&sidoName=" + sidoName + "&_returnType=json";
		URI uri;
		String responseString = "";
		try {
			uri = new URI(sidoEnvironmentURL);
			System.out.println("url : " + sidoEnvironmentURL);
			responseString = restTemplate.getForObject(uri, String.class);
			return responseString;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseString;
	}

	@Override
	public void insertPublicDataEnvironmentService() throws ClientProtocolException, IOException, InterruptedException {
		for (int i = 0; i < sidoList.length; i++) {
			if(setSidoEnvironment(sidoList[i]).equals("")) {
				System.out.println(i + "번 째 데이터가 성공적으로 전달되었습니다!");
				System.out.println();
			}else {
				System.out.println(i + "번 째 데이터가 제대로 전달되지 못했습니다.");
			}
			Thread.sleep(1000);
		}
	}
}
