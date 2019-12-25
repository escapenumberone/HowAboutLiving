package com.howaboutliving.batch.reader;

import java.net.URI;
import java.net.URLEncoder;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.batch.exception.ResultCodeException;

public class DisasterReader implements ItemReader<String> {

	@Autowired
	RestTemplate restTemplate;

	private int pageNo = 1;

	@Override
	public String read() throws Exception {
		while (true) {
			String readData = getDisasterStr(pageNo++);
			if (!checkData(readData)) {
				pageNo = 1;
				break;
			}
			return readData;
		}
		return null;

	}

	private boolean checkData(String readData) throws Exception{
		JsonObject obj = JsonParser.parseString(readData).getAsJsonObject();
		JsonObject parse_response = (JsonObject) obj.get("response");
		JsonObject parse_header = (JsonObject) parse_response.get("header");
		if (!parse_header.get("resultCode").toString().equals("\"00\"")) { // 00코드가 아니면(resultCode에 문제가 있으면)
			if(!parse_header.get("resultCode").toString().equals("\"03\"")) // 03코드가 아니면(데이터가 없는 경우 말고는 다른 코드 에러)
				throw new ResultCodeException();
			return false;
		}
		return true;
	}

	public String getDisasterStr(int pageNo) throws Exception{
		URI uri;
		String responseString = "";
		uri = new URI(makeUrl(pageNo));
		responseString = restTemplate.getForObject(uri, String.class);

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
