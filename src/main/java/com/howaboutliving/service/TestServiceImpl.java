package com.howaboutliving.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.dao.TestDao;
import com.howaboutliving.dto.PublicDataDisaster;
import com.howaboutliving.dto.Test;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestDao tDao;
	
	
	public List<Test> getList() {
		return tDao.getList();
	}
	
	public void insert() {
		tDao.insert(new Test(6, "Z"));
	}
	
	public void insertList() {
		List<Test> list = new ArrayList<>();
		list.add(new Test(7, "G"));
		list.add(new Test(8, "H"));
		list.add(new Test(9, "I"));
		tDao.insertList(list);
	}
	
//	public void save() {
//		// open api 데이터 받아오기 테스트
//		try {
//			for (int j = 1; j <= 2; j++) {
//				StringBuilder urlBuilder = new StringBuilder(
//						"http://api.data.go.kr/openapi/dsstr-risk-dstrc-std"); /* URL */
//				urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
//						+ "=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D"); /*
//																																	 * Service
//																																	 * Key
//																																	 */
//				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
//						+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
//				urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "="
//						+ URLEncoder.encode("json", "UTF-8")); /* XML/JSON 여부 */
//				urlBuilder.append(
//						"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(j + "", "UTF-8")); /* 페이지 번호 */
//				URL url = new URL(urlBuilder.toString());
//				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				conn.setRequestMethod("GET");
//				conn.setRequestProperty("Content-type", "application/json");
//				System.out.println("Response code: " + conn.getResponseCode());
//				BufferedReader rd;
//				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				} else {
//					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//				}
//
//				StringBuilder sb = new StringBuilder();
//				String line;
//
//				while ((line = rd.readLine()) != null) {
//					JsonObject obj = JsonParser.parseString(line).getAsJsonObject();
//					JsonObject parse_response = (JsonObject) obj.get("response");
//					JsonObject parse_body = (JsonObject) parse_response.get("body");
//					JsonArray parse_items = (JsonArray) parse_body.get("items");
//					
////					List<PublicDataDisaster> list = new ArrayList<>();
////					tDao.save();
//					
//					for (int i = 0; i < parse_items.size(); i++) {
//						JsonObject item = (JsonObject) parse_items.get(i);
//						
//						System.out.println("재해위험 지역 : " + item.get("dsstrRiskLc"));
//						System.out.println("재해위험 지역 상세주소 : " + item.get("dsstrRiskAddr"));
//						System.out.println("재해위험 유형 : " + item.get("dsstrRiskType"));
//						System.out.println("재해위험 등급 : " + item.get("dsstrRiskGrad"));
//						System.out.println("정보수정 일자 : " + item.get("infoModDate"));
//						System.out.println("해제 일자 : " + item.get("relisDate"));
//						System.out.println();
//					}
//				}
//				rd.close();
//				conn.disconnect();
//			}
//		} catch (Exception e) {
//			
//		}
//	}
}
