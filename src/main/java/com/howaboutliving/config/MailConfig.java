package com.howaboutliving.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	@Value("${mailsender.user.email}")
	private String myEmail;
	
	@Value("${mailsender.user.password}")
	private String myPw;
	
	@Bean
	public static JavaMailSender mailSender(MailConfig mc) {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable","true"); //설정하지 않으면 에러 발생 (아래 참조)
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.quitwait","false");
		props.put("mail.debug","false"); // 디버그 모드 : 개발이 완료되면 false
		mailSender.setJavaMailProperties(props);
		
		mailSender.setProtocol("smtp");
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername(mc.myEmail);
		mailSender.setPassword(mc.myPw);

		return mailSender;
	}
}
