//package com.howaboutliving.utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class RestTemplateUtil {
//	private static RestTemplate restTemplate;
//	
//	@Autowired
//	public RestTemplateUtil(RestTemplate restTemplate) {
//		RestTemplateUtil.restTemplate = restTemplate;
//	}
//	
//	public static String getDisasterAsJson(String url) throws RestClientException, Exception {
//		System.out.println("요청 URL : " + url);
////		System.out.println("result : " + restTemplate.getForObject(url, String.class));
//		return restTemplate.getForObject(url, String.class);
//	}
//}
