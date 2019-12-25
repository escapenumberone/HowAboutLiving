package com.howaboutliving.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.dto.PublicDataDisaster;
import com.howaboutliving.dto.PublicDataEnvironment;

public class DisasterProcessor implements ItemProcessor<String, List<PublicDataDisaster>> {
	
	private List<PublicDataDisaster> publicDataDisasterList;
	
	@Override
	public List<PublicDataDisaster> process(String readData) throws Exception {
		publiaDataDisasterParse(readData);
		
		return publicDataDisasterList;
	}
	
	private void publiaDataDisasterParse(String readData) {
		publicDataDisasterList = new ArrayList<>(); // 리스트 초기화
		
		JsonObject obj = JsonParser.parseString(readData).getAsJsonObject();
		JsonObject parse_response = (JsonObject) obj.get("response");
		JsonObject parse_body = (JsonObject) parse_response.get("body");
		JsonArray parse_items = (JsonArray) parse_body.get("items");
		
		// 파싱한 데이터 DTO List로 만듦
		for (int i = 0; i < parse_items.size(); i++) {
			JsonObject item = (JsonObject) parse_items.get(i);
			
			publicDataDisasterList.add(new PublicDataDisaster(item.get("insttNm").getAsString(),
					item.get("dsstrRiskAddr").getAsString(), item.get("dsstrRiskType").getAsString(),
					item.get("dsstrRiskGrad").getAsString(), item.get("appnDate").getAsString(),
					item.get("infoModDate").getAsString(), item.get("relisDate").getAsString()));
			
		}
	}
	
}
