package com.howaboutliving.batch.reader;

import java.io.FileNotFoundException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.batch.exception.MyException;

public class DisasterReader implements ItemReader<String> {
	private int pageNo = 1;
	private int cnt = 1;
	
	@Override
	public String read() throws MyException {

//		while(true) {
//			String readData =  getDisasterStr(pageNo++);
//			if(!checkData(readData)) {
//				pageNo = 1;
//				break;
//			}
//			return readData;
//		}
		System.out.println();
		System.out.println("리드 실행 됨");

		int a = 1;
		int b = 1;
		if (a == b && cnt <= 3) {
			cnt++;
			throw new MyException();
		}
//		else if(a == b && cnt >= 4) {
//			System.out.println("횟수 초과요");
//		}
		System.out.println("익셉션 지나감");
		// 데이터를 읽어야 해.
		// 근데 데이터를 못받아왔네 ? (Exception을 받았어, 타임아웃이던, 00코드던)
		// 못받아왔을때 핸들링을 해줘야 해(재시도 하게 끔)

		return null;

	}
	private boolean checkData(String readData) {
		JsonObject obj = JsonParser.parseString(readData).getAsJsonObject();
		JsonObject parse_response = (JsonObject) obj.get("response");
		JsonObject parse_header = (JsonObject) parse_response.get("header");
		if (!parse_header.get("resultCode").toString().equals("\"00\"")) { // 데이터가 없으면 00코드 반환
			return false;
		}
		return true;
	}

	public String getDisasterStr(int pageNo) {

		RestTemplate restTemplate = new RestTemplate();
		URI uri;
		String responseString = "";
		try {
			uri = new URI(makeUrl(pageNo));
			responseString = restTemplate.getForObject(uri, String.class);
		} catch (URISyntaxException e) {
			System.out.println("URI 문법 에러");
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			System.out.println("api 서버 연결 에러");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return responseString;
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
