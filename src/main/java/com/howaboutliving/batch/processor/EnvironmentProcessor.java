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
			publicDataEnvironmentList.add(publicDataEnvironment);
		}
		
	}
	
}
