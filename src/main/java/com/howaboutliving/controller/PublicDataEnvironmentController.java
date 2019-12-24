package com.howaboutliving.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.dto.EnvironmentDailyAvg;
import com.howaboutliving.service.PublicDataEnvironmentService;

/**
 * 
 * 삭제 예정
 *
 */

@RestController
public class PublicDataEnvironmentController {
	
	@Autowired
	PublicDataEnvironmentService eService;
	
	@RequestMapping("/resttemplatetest")
	public String restTemplate() throws ClientProtocolException, IOException, InterruptedException {
		eService.insertPublicDataEnvironmentService();
		return "레스트 템플릿 테스트";
	}
	
	@RequestMapping("/currentDailyAvgOfStationName")
	@ResponseBody
	public ModelMap getCurrentDailyAvgOfStationName(@RequestParam(value = "stationName", required=false) String stationName){
		ModelMap mm = new ModelMap();
		// 여기서 보여줄 최근 7개를 측정소명을 통해 가져오면 된다.
		List<EnvironmentDailyAvg> environmentDailyAvgList = new ArrayList<EnvironmentDailyAvg>();
		environmentDailyAvgList.add(new EnvironmentDailyAvg(1, "1", stationName, "1", "1"));
		environmentDailyAvgList.add(new EnvironmentDailyAvg(2, "2", stationName, "2", "2"));
		environmentDailyAvgList.add(new EnvironmentDailyAvg(3, "3", stationName, "3", "3"));
		mm.put("list", environmentDailyAvgList);
		return mm;
	}
	
	@RequestMapping("/oneDailyTest")
	public String oneDailyTest() {
		eService.insertOneDailyAvgEnvironment();
		return "레스트 템플릿 테스트";
	}
}
