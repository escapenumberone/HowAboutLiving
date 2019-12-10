package com.howaboutliving.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.dao.PublicDataEnvironmentDao;
import com.howaboutliving.dto.PublicDataEnvironment;

@Service
public class PublicDataEnvironmentServiceImpl implements PublicDataEnvironmentService {

	private PublicDataEnvironmentDao publicDataEnvironmentDao;
	private static final int NUMBEROFROWS = 10;

	@Autowired
	public void setPublicDataEnvironmentDao(PublicDataEnvironmentDao publicDataEnvironmentDao) {
		this.publicDataEnvironmentDao = publicDataEnvironmentDao;
	}

	@Override
	public String getEmptyMsrstnListStr() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(
				"http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getMsrstnList?ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D&_returnType=json&pageNo=0&numberOfRows=0");

		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

		BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}

		reader.close();

		String str = response.toString();
		httpClient.close();

		return str;
	}

	@Override
	public int getTotalCountOfMsrstnList() throws IOException {

		String TotalCountMsrstnListStr = getEmptyMsrstnListStr();
		JsonObject parse_obj = JsonParser.parseString(TotalCountMsrstnListStr).getAsJsonObject();

		return parse_obj.get("totalCount").getAsInt();
	}

	@Override
	public String getPublicDataEnvironment() throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(
				"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D&numOfRows=10&pageNo=1&stationName=백암면&dataTerm=DAILY&_returnType=json");

		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

		System.out.println("http response ::");

		System.out.println("status code : " + httpResponse.getStatusLine().getStatusCode());

		BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}

		reader.close();

		String str = response.toString();
		httpClient.close();

		return str;

	}
	
	@Override
	public String getMsrstnListStr(CloseableHttpClient httpClient, String MsrstnListURL) throws ClientProtocolException, IOException {
		
		HttpGet httpGet = new HttpGet(MsrstnListURL);
		
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
		
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		
		reader.close();
		
		String str = response.toString();
		
		return str;
	}
	
	@Override
	public PublicDataEnvironment setFirstEnvironment(String stationName, String addr) throws IOException {
		
		String FirstEnvironmentStr = getFirstEnvironmentStr(stationName);
		
		JsonObject parse_obj = JsonParser.parseString(FirstEnvironmentStr).getAsJsonObject();
		JsonArray parse_list = parse_obj.get("list").getAsJsonArray();
		
		PublicDataEnvironment publicDataEnvironment = null;
		
		if(parse_list.size() > 0) {
			JsonObject parse_environment = (JsonObject) parse_list.get(0);
			publicDataEnvironment = new PublicDataEnvironment(
				addr.split(" ")[2],
				stationName,
				parse_environment.get("dataTime").getAsString(),
				parse_environment.get("khaiValue").getAsString(),
				parse_environment.get("so2Value").getAsString(),
				parse_environment.get("coValue").getAsString(),
				parse_environment.get("o3Value").getAsString(),
				parse_environment.get("no2Value").getAsString(),
				parse_environment.get("pm10Value").getAsString(),
				parse_environment.get("pm25Value").getAsString(),
				parse_environment.get("khaiGrade").getAsString(),
				parse_environment.get("so2Grade").getAsString(),
				parse_environment.get("coGrade").getAsString(),
				parse_environment.get("o3Grade").getAsString(),
				parse_environment.get("no2Grade").getAsString(),
				parse_environment.get("pm10Grade").getAsString(),
				parse_environment.get("pm25Grade").getAsString()
				);
			
			publicDataEnvironment.setId(0);
		}
		
//		System.out.println(publicDataEnvironment);
		
		return publicDataEnvironment;
	}
	
	@Override
	public String getFirstEnvironmentStr(String stationName) throws IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String FirstEnvironmentURL = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?"
				+ "ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D"
				+ "&_returnType=json"
				+ "&pageNo=1"
				+ "&numberOfRows=10"
				+ "&dataTerm=DAILY"
				+ "&stationName=" + stationName;
		
		HttpGet httpGet = new HttpGet(FirstEnvironmentURL);

		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

		BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}

		reader.close();

		String str = response.toString();
		httpClient.close();

		return str;
	}

	@Override
	public void insertPublicDataEnvironmentService() throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();

		
		int maxTotalCountOfMsrstnList = (getTotalCountOfMsrstnList() / NUMBEROFROWS) + 1;

		// 측정소 총 갯수 465개, 한 페이지당 10개씩, 즉, 47번 반복
		for (int i = 1; i <= maxTotalCountOfMsrstnList; i++) {
			
			String msrstnListURL = "http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getMsrstnList?ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D&_returnType=json"
					+ "&pageNo=" + i
					+ "&numberOfRows=" + NUMBEROFROWS;
			
			// 측정소 리스트의 json String 가져오기
			String msrstnListStr = getMsrstnListStr(httpClient, msrstnListURL);
			
			// 측정소 리스트의 json String을 파싱해서 객체로 만들기
			JsonObject parse_obj = JsonParser.parseString(msrstnListStr).getAsJsonObject();
			JsonArray parse_list = parse_obj.get("list").getAsJsonArray();
			
			System.out.println( i + "번 째 : " + "parse_list.size() : " + parse_list.size());
			
			// 측정소 리스트의 사이즈만큼 돌기
			for(int j = 0 ; j < parse_list.size() ; j++) {
				
				// 하나의 엘리먼트에서 addr과 stationName을 가져와 객체에 넣기
				JsonObject parse_element = (JsonObject) parse_list.get(j);
				String addr = parse_element.get("addr").getAsString();
				String stationName = parse_element.get("stationName").getAsString();
				
				System.out.println("addr : " + addr + " " + "stationName : " + stationName);
				
				PublicDataEnvironment publicDataEnvironment = setFirstEnvironment(stationName, addr);
				
				// 그 객체를 DB에 저장
				publicDataEnvironmentDao.insertPublicDataEnvironment(publicDataEnvironment);
				
			}
			
		}
		httpClient.close();

	}

}
