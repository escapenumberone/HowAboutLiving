package com.howaboutliving.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howaboutliving.dto.PublicDataDisaster;
import com.howaboutliving.service.PublicDataDisasterService;

@RestController
@RequestMapping("/disaster")
@CrossOrigin(origins="*") // 개발 서버 간에 api콜 허락하기 위한 CORS 설정
public class PublicDataDisasterController {
	
	@Autowired
	PublicDataDisasterService dService;

	@GetMapping("/list/{dsstrRiskLc}")
	@ResponseBody
	public ResponseEntity<ModelMap> getDisasterListByDsstrRiskLc(@PathVariable String dsstrRiskLc) {
		ModelMap mm = new ModelMap();
		List<PublicDataDisaster> list = dService.selectPublicDataDisasterByDsstrRiskLc(dsstrRiskLc);
		if(list.size() > 0) {
			mm.put("disasterList", list);
			mm.put("resultCode", "200");
			return new ResponseEntity<ModelMap>(mm, HttpStatus.OK);
		}
		mm.put("resultCode", "204");
		return new ResponseEntity<ModelMap>(mm, HttpStatus.NO_CONTENT); // 성공은 했지만 내용이 없는 204 NO CONTENT 에러
	}
}
