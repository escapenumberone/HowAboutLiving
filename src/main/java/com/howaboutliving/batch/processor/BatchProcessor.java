package com.howaboutliving.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.dao.PublicDataEnvironmentDao;
import com.howaboutliving.dto.PublicDataEnvironment;
import com.howaboutliving.service.PublicDataEnvironmentService;

@Configuration
public class BatchProcessor implements ItemProcessor<String, List<PublicDataEnvironment>> {
	
	@Autowired
	PublicDataEnvironmentDao pded;
	
	@Autowired
	PublicDataEnvironmentService eService;
	
	@Override
	public List<PublicDataEnvironment> process(String readData) throws Exception {
		
		List<PublicDataEnvironment> publicDataEnvironmentList = new ArrayList<>();
		PublicDataEnvironment publicDataEnvironment = null;

		JsonObject parse_Json = JsonParser.parseString(readData).getAsJsonObject();
		JsonArray parse_list = parse_Json.get("list").getAsJsonArray();
		
		for (int j = 0; j < parse_list.size(); j++) {
			JsonObject parse_obj = (JsonObject) parse_list.get(j);

			publicDataEnvironment = new PublicDataEnvironment(
				0,
				"서울",
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
			System.out.println("배치측 출력(processor) : " + publicDataEnvironment.toString());
			publicDataEnvironmentList.add(publicDataEnvironment);
//			pded.insertPublicDataEnvironment(publicDataEnvironment);
		}
		
		return publicDataEnvironmentList;
	}
	
}
