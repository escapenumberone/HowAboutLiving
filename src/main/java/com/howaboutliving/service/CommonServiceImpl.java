package com.howaboutliving.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.howaboutliving.dao.PublicDataDisasterDao;

@Service
public class CommonServiceImpl implements CommonService{
	@Autowired
	PublicDataDisasterDao dDao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
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
}
