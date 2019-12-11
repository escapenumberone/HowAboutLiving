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
public class TestServiceImpl implements TestService {

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

	public void save() {
		// open api 데이터 받아오기 테스트
		try {
			int pageNo = 1;
			URL url;
			HttpURLConnection conn;
			loop: while (true) {
				String urlString = makeUrl(pageNo++); // api 콜 url 생성
				url = new URL(urlString);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				
				System.out.println("URL : " + urlString);
				System.out.println("Response code: " + conn.getResponseCode());
				
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean publicDataParseAndLoad(String line) {
		JsonObject obj = JsonParser.parseString(line).getAsJsonObject();
		JsonObject parse_response = (JsonObject) obj.get("response");
		JsonObject parse_header = (JsonObject) parse_response.get("header");
		if (!parse_header.get("resultCode").toString().equals("\"00\"")) {
			System.out.println("데이터 없음"); // 나중에 open api 서버 안될경우에 JSON파일을 읽어오는 식으로 해결해야 함.
			return false;
		}
		JsonObject parse_body = (JsonObject) parse_response.get("body");
		JsonArray parse_items = (JsonArray) parse_body.get("items");

		
		List<PublicDataDisaster> list = new ArrayList<>();
		for (int i = 0; i < parse_items.size(); i++) {
			JsonObject item = (JsonObject) parse_items.get(i);

			list.add(new PublicDataDisaster(0, item.get("insttNm").getAsString(),
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
