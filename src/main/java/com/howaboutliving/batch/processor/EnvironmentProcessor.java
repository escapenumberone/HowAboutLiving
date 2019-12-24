package com.howaboutliving.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.dto.PublicDataEnvironment;

public class EnvironmentProcessor implements ItemProcessor<String, List<PublicDataEnvironment>> {
	
	private List<PublicDataEnvironment> publicDataEnvironmentList;
	
	@Override
	public List<PublicDataEnvironment> process(String readData) throws Exception {
		publiaDataEnvironmentParse(readData);
		
		return publicDataEnvironmentList;
	}
	
	private void publiaDataEnvironmentParse(String readData) {
		publicDataEnvironmentList = new ArrayList<>(); // 리스트 초기화
		
		JsonObject parse_Json = JsonParser.parseString(readData).getAsJsonObject();
		JsonArray parse_list = parse_Json.get("list").getAsJsonArray();
		
		/** 파싱한 데이터 DTO List로 만듦 */
		for (int j = 0; j < parse_list.size(); j++) {
			JsonObject parse_obj = (JsonObject) parse_list.get(j);

			PublicDataEnvironment publicDataEnvironment = new PublicDataEnvironment(
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
//			checkpublicDataEnvironment(publicDataEnvironment);
			publicDataEnvironmentList.add(publicDataEnvironment);
		}
		
		JsonObject parse_parm = (JsonObject) parse_Json.get("parm");
		if(!parse_parm.get("resultCode").getAsString().equals("")) {
			System.out.println("환경 open api 서버 에러");
		}
	}
	
	// mysql 상에서 지울 수 있는 방법이 있을텐데...
	private void checkpublicDataEnvironment(PublicDataEnvironment publicDataEnvironment) {
		if(publicDataEnvironment.getAll_value().equals("") || publicDataEnvironment.getAll_value().equals("-")) {
			publicDataEnvironment.setAll_value("0");
		}
		if(publicDataEnvironment.getSo2_value().equals("") || publicDataEnvironment.getSo2_value().equals("-")) {
			publicDataEnvironment.setSo2_value("0");
		}
		if(publicDataEnvironment.getCo_value().equals("") || publicDataEnvironment.getCo_value().equals("-")) {
			publicDataEnvironment.setCo_value("0");
		}
		if(publicDataEnvironment.getO3_value().equals("") || publicDataEnvironment.getO3_value().equals("-")) {
			publicDataEnvironment.setO3_value("0");
		}
		if(publicDataEnvironment.getNo2_value().equals("") || publicDataEnvironment.getNo2_value().equals("-")) {
			publicDataEnvironment.setNo2_value("0");
		}
		if(publicDataEnvironment.getFinedust_value().equals("") || publicDataEnvironment.getFinedust_value().equals("-")) {
			publicDataEnvironment.setFinedust_value("0");
		}
		if(publicDataEnvironment.getUltra_finedust_value().equals("") || publicDataEnvironment.getUltra_finedust_value().equals("-")) {
			publicDataEnvironment.setUltra_finedust_value("0");
		}
		if(publicDataEnvironment.getAll_grade().equals("") || publicDataEnvironment.getAll_grade().equals("-")) {
			publicDataEnvironment.setAll_grade("0");
		}
		if(publicDataEnvironment.getSo2_grade().equals("") || publicDataEnvironment.getSo2_grade().equals("-")) {
			publicDataEnvironment.setSo2_grade("0");
		}
		if(publicDataEnvironment.getCo_grade().equals("") || publicDataEnvironment.getCo_grade().equals("-")) {
			publicDataEnvironment.setCo_grade("0");
		}
		if(publicDataEnvironment.getO3_grade().equals("") || publicDataEnvironment.getO3_grade().equals("-")) {
			publicDataEnvironment.setO3_grade("0");
		}
		if(publicDataEnvironment.getNo2_grade().equals("") || publicDataEnvironment.getNo2_grade().equals("-")) {
			publicDataEnvironment.setNo2_grade("0");
		}
		if(publicDataEnvironment.getFinedust_grade().equals("") || publicDataEnvironment.getFinedust_grade().equals("-")) {
			publicDataEnvironment.setFinedust_grade("0");
		}
		if(publicDataEnvironment.getUltra_finedust_grade().equals("") || publicDataEnvironment.getUltra_finedust_grade().equals("-")) {
			publicDataEnvironment.setUltra_finedust_grade("0");
		}
		
	}
	
}
