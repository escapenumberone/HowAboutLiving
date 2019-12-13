package com.howaboutliving.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.dao.TestDao;
import com.howaboutliving.dto.PublicDataDisaster;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao tDao;
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	public void save() {
		// open api 데이터 받아오기 테스트
		
		/**
		try {
			int pageNo = 1;
			String result = RestTemplateUtil.getDisasterAsJson(makeUrl(pageNo++));
			ResponseEntity<String> responseEntity = restTemplate.getForEn
			System.out.println(result);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
//		try {
//			int pageNo = 1;
//			
//			// HTTP 연결 통신하는 템플릿이 스프링에 있음
//			URL url;
//			HttpURLConnection conn;
//			loop: while (true) {
//				String urlString = makeUrl(pageNo++); // open api url 생성
//				url = new URL(urlString);
//				conn = (HttpURLConnection) url.openConnection();
//				conn.setRequestMethod("GET");
//				conn.setRequestProperty("Content-type", "application/json");
//				conn.setReadTimeout(20000); // 넉넉한 시간을 기다려보고
//				
//				System.out.println("URL : " + urlString);
//				System.out.println("Response code: " + conn.getResponseCode());
//				
//				System.out.println(conn.getInputStream());
//				
//				BufferedReader rd;
//				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				} else {
//					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//					
//				}
//
//				String line;
//				while ((line = rd.readLine()) != null) {
//					if(!publicDataParseAndLoad(line)) // 공공데이터 파싱하고 적재
//						break loop;
//				}
//				rd.close();
//				conn.disconnect();
//			}
//			
//		} catch (SocketTimeoutException e) {
//			System.out.println("open api 이용 불가능");
//			// 서버 이용 불가능 할때 어떻게 처리할지 예외처리 로직 추가 해줘야 함
//			// 기존 데이터를 쓰는방식으로 ? 아무일도 하지 않으면 디비가 업데이트 되지 않으니까 그대로 냅두면 될 듯
//			// 사용자 화면에 언제 업데이트 된 데이터인지 표시 ? ex) 19.12.10 기준
//			
//			
//			// 굳이 배치를 사용하지 않고 그냥 스케줄링만 적용 -> 시간이 정말 없을 때.
//			// reader processor writer 어떻게 교류하고 하는지 확실히 알면 구현하기 쉬울듯
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		**/
		
		try {
			int pageNo = 8;
			
			// HTTP 연결 통신하는 템플릿이 스프링에 있음
			URL url;
			HttpURLConnection conn;
			loop: while (true) {
				String urlString = makeUrl(pageNo++); // open api url 생성
				url = new URL(urlString);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				conn.setReadTimeout(20000); // 넉넉한 시간을 기다려보고
				
				System.out.println("URL : " + urlString);
				System.out.println("Response code: " + conn.getResponseCode());
				
				System.out.println(conn.getInputStream());
				
				BufferedReader rd;
				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
					
				}

				String line;
				while ((line = rd.readLine()) != null) {
					if(!publicDataParseAndLoad(line)) // 공공데이터 파싱하고 적재
						break loop;
				}
				rd.close();
				conn.disconnect();
			}
			
		} catch (SocketTimeoutException e) {
			System.out.println("open api 이용 불가능");
			// 서버 이용 불가능 할때 어떻게 처리할지 예외처리 로직 추가 해줘야 함
			// 기존 데이터를 쓰는방식으로 ? 아무일도 하지 않으면 디비가 업데이트 되지 않으니까 그대로 냅두면 될 듯
			// 사용자 화면에 언제 업데이트 된 데이터인지 표시 ? ex) 19.12.10 기준
			
			
			// 굳이 배치를 사용하지 않고 그냥 스케줄링만 적용 -> 시간이 정말 없을 때.
			// reader processor writer 어떻게 교류하고 하는지 확실히 알면 구현하기 쉬울듯
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean publicDataParseAndLoad(String line) {
		JsonObject obj = JsonParser.parseString(line).getAsJsonObject();
		JsonObject parse_response = (JsonObject) obj.get("response");
		JsonObject parse_header = (JsonObject) parse_response.get("header");
		if (!parse_header.get("resultCode").toString().equals("\"00\"")) {
			System.out.println("데이터 없음");
			return false;
		}
		JsonObject parse_body = (JsonObject) parse_response.get("body");
		JsonArray parse_items = (JsonArray) parse_body.get("items");

		
		List<PublicDataDisaster> list = new ArrayList<>();
		for (int i = 0; i < parse_items.size(); i++) {
			JsonObject item = (JsonObject) parse_items.get(i);
			
			// 제이슨 리스트를 넘겨서 거기서 바로 바인딩하게끔
			list.add(new PublicDataDisaster(item.get("insttNm").getAsString(),
					item.get("dsstrRiskAddr").getAsString(), item.get("dsstrRiskType").getAsString(),
					item.get("dsstrRiskGrad").getAsString(), item.get("appnDate").getAsString(),
					item.get("infoModDate").getAsString(), item.get("relisDate").getAsString()));
		}
		tDao.save(list);
		return true;
	}

	private String makeUrl(int pageNo) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/dsstr-risk-dstrc-std"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D"); /*
																															 * Service
																															 * Key
																															 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("200", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append(
				"&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* XML/JSON 여부 */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
				+ URLEncoder.encode(pageNo++ + "", "UTF-8")); /* 페이지 번호 */
		return urlBuilder.toString();
	}

}
