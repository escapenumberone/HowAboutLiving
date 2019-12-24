package com.howaboutliving.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.dto.PublicDataEnvironmentDailyAvg;
import com.howaboutliving.dto.PublicDataEnvironment;
import com.howaboutliving.service.PublicDataEnvironmentService;

@RestController
@RequestMapping("/environment")
public class PublicDataEnvironmentController {
	
	@Autowired
	PublicDataEnvironmentService eService;
	
	// 현재 실시간 데이터를 넘겨준다.
	@GetMapping("/realtime/{stationName}")
	@ResponseBody
	public ResponseEntity<ModelMap> getRealtimeEnvironment(@PathVariable String stationName) {
		ModelMap mm = new ModelMap();
		List<PublicDataEnvironment> list = eService.selectRealtimeEnvironmentByStationName(stationName);
		if(list.size() > 0) {
			mm.put("realtimeList", list);
			mm.put("resultCode", "200");
			return new ResponseEntity<ModelMap>(mm, HttpStatus.OK);
		}
		mm.put("resultCode", "204");
		return new ResponseEntity<ModelMap>(mm, HttpStatus.NO_CONTENT); // 성공은 했지만 내용이 없는 204 NO CONTENT 에러
	}
	
	// 현재 지역을 기준으로 7일 이전의 데이터를 넘겨준다.
	@GetMapping("/sevendays/{stationName}")
	@ResponseBody
	public ResponseEntity<ModelMap> getSevenDaysDailyAvgEnvironment(@PathVariable String stationName) {
		ModelMap mm = new ModelMap();
		List<PublicDataEnvironmentDailyAvg> list = eService.selectSevenDaysDailyAvgEnvironmentByStationName(stationName);
		if(list.size() > 0) {
			mm.put("sevendaysList", list);
			mm.put("resultCode", "200");
			return new ResponseEntity<ModelMap>(mm, HttpStatus.OK);
		}
		mm.put("resultCode", "204");
		return new ResponseEntity<ModelMap>(mm, HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping("/nowdays")
	public String nowDays() {
		eService.insertPublicDataEnvironmentAvg();
		return "현재시간";
	}
}
