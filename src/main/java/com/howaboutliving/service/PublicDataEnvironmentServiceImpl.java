package com.howaboutliving.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

import javax.mail.internet.MimeMessage;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.howaboutliving.dao.PublicDataEnvironmentDao;
import com.howaboutliving.dto.EnvironmentDailyAvg;
import com.howaboutliving.dto.PublicDataEnvironment;

@Service
public class PublicDataEnvironmentServiceImpl implements PublicDataEnvironmentService {
	private static final int NUMOFROWS = 10000;
	private String sidoStr = readSidoTxt();
	private String[] sidoList = sidoStr.split(",");

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	public PublicDataEnvironmentDao eDao;

	@Override
	public String setSidoEnvironment(String sidoName) throws IOException {

		PublicDataEnvironment publicDataEnvironment = null;

		JsonObject parse_Json = JsonParser.parseString(getSidoEnvironmentStr(sidoName)).getAsJsonObject();
		JsonArray parse_list = parse_Json.get("list").getAsJsonArray();

		for (int j = 0; j < parse_list.size(); j++) {
			JsonObject parse_obj = (JsonObject) parse_list.get(j);

			publicDataEnvironment = new PublicDataEnvironment(0, parse_obj.get("stationName").getAsString(),
					parse_obj.get("dataTime").getAsString(), parse_obj.get("khaiValue").getAsString(),
					parse_obj.get("so2Value").getAsString(), parse_obj.get("coValue").getAsString(),
					parse_obj.get("o3Value").getAsString(), parse_obj.get("no2Value").getAsString(),
					parse_obj.get("pm10Value").getAsString(), parse_obj.get("pm25Value").getAsString(),
					parse_obj.get("khaiGrade").getAsString(), parse_obj.get("so2Grade").getAsString(),
					parse_obj.get("coGrade").getAsString(), parse_obj.get("o3Grade").getAsString(),
					parse_obj.get("no2Grade").getAsString(), parse_obj.get("pm10Grade").getAsString(),
					parse_obj.get("pm25Grade").getAsString());

			eDao.insertPublicDataEnvironment(publicDataEnvironment);

		}

		JsonObject parse_parm = (JsonObject) parse_Json.get("parm");

		return parse_parm.get("resultCode").getAsString();
	}

	@Override
	public String getSidoEnvironmentStr(String sidoName) throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		String sidoEnvironmentURL = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?ServiceKey=T9ukDjLAYhGMGK%2FKeH7khfgFEnCHXfYhuHx6GkQIaDpMKFQ4E6sDm%2Bb8aYtmcibG1s8Auk%2BzauoNOZN2HDnRBQ%3D%3D"
				+ "&numOfRows=" + NUMOFROWS + "&pageNo=1" + "&sidoName=" + sidoName + "&_returnType=json";
		URI uri;
		String responseString = "";
		try {
			uri = new URI(sidoEnvironmentURL);
			System.out.println("url : " + sidoEnvironmentURL);
			responseString = restTemplate.getForObject(uri, String.class);
			return responseString;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseString;
	}

	@Override
	public void insertPublicDataEnvironmentService() throws ClientProtocolException, IOException, InterruptedException {
		alarmToDev("메세지 보낼 String을 여기에 쓰세요");
		for (int i = 0; i < sidoList.length; i++) {
			if (setSidoEnvironment(sidoList[i]).equals("")) {
				System.out.println(i + "번 째 데이터가 성공적으로 전달되었습니다!");
				System.out.println();
			} else {
				System.out.println(i + "번 째 데이터가 제대로 전달되지 못했습니다.");
			}
			Thread.sleep(1000);
		}
	}

	public String readSidoTxt() {

		String sidoStr = "";
		// 경로를 한 번 지정해주고 바꾸면 안됨.
		File file = new File("C:\\Users\\niboh\\Desktop\\git\\HowAboutLiving\\src\\main\\resources\\sidoTxtFile.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				sidoStr += sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return sidoStr;
	}

	public void alarmToDev(String str) {

		String from = "naeb2627@gmail.com";
		String tomail = "aegis1920@gmail.com"; // 받는 사람 이메일
		String subject = "오류가 발생했습니다.";
		String content = "현재" + str + "과 같은 오류가 생겼습니다."; // 내용

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(from); // 보내는사람
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(subject); // 메일 제목
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<EnvironmentDailyAvg> selectDaliyAvgEnvironment() {
		return eDao.selectDaliyAvgEnvironment();
	}

	// 걍 처음에 List에 넣고 안에서 해도 상관없음.
	@Override
	public void insertDaliyAvgEnvironment(List<EnvironmentDailyAvg> environementDailyAvgList) {
		eDao.insertDailyAvgEnvironment(environementDailyAvgList);
	}

	public void addCurrentOneDailyAvgEnvironment() {
		insertDaliyAvgEnvironment(selectDaliyAvgEnvironment());
	}

}
