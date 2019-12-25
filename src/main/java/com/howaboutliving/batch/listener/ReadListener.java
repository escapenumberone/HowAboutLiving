package com.howaboutliving.batch.listener;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.web.client.ResourceAccessException;

import com.howaboutliving.batch.exception.ResultCodeException;

public class ReadListener implements ItemReadListener<String> {

	@Override
	public void beforeRead() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterRead(String item) {

	}

	@Override
	public void onReadError(Exception ex) {
		if (ex instanceof UnknownHostException) { // open api 주소를 아예 못찾았을 때
			System.out.println("UnknownHostException Exception 발생");
			waitMinute();
		} else if (ex instanceof SocketTimeoutException) { // 연결 초과 에러 
			System.out.println("SocketTimeoutException Exception 발생");
			waitMinute();
		} else if (ex instanceof ResourceAccessException) { // open api 서버 사용 불가능, blocking 걸렸을 때
			System.out.println("ResourceAccessException Exception 발생");
			waitMinute();
		} else if (ex instanceof ResultCodeException) { // resultCode가 정상적인 코드가 아닐 때
			System.out.println("ResultCodeException Exception 발생");
			waitMinute();
		} else if (ex instanceof Exception) {
			ex.printStackTrace();
			return;
		}
	}
	
	public void waitMinute() {
		try {
			Thread.sleep(60000); // 1분 기다렸다가 재요청
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
