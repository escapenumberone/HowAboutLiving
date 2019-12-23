package com.howaboutliving.batch.listener;

import java.net.UnknownHostException;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.web.client.ResourceAccessException;

public class EnvironmentListener implements ItemReadListener<String> {

	@Override
	public void beforeRead() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterRead(String item) {

	}

	@Override
	public void onReadError(Exception ex) {
//		if (ex instanceof SkipLimitExceededException) {
//			System.out.println("ExceededException Listener");
//		} else if (ex instanceof MyResourceAccessException) {
//			System.out.println("ResousrceAccess Exception Listener");
//			try {
//				Thread.sleep(10000);
//			} catch (Exception e) {
//				System.out.println("asdasdasdasd");
//				e.printStackTrace();
//				System.out.println("asdasdasdasd");
//			}
//
//		} else if (ex instanceof Exception) {
//			System.out.println("쩌리 일로와");
//		}
		if (ex instanceof UnknownHostException) {
			System.out.println("UnknownHostException Exception Listener");
		} else if (ex instanceof ResourceAccessException) {
			ex.printStackTrace();
			System.out.println("ResourceAccessException Exception Listener");
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//				System.out.println("asdasdasdasd");
//				e.printStackTrace();
//				System.out.println("asdasdasdasd");
//			}
		} else if (ex instanceof Exception) {
			System.out.println("쩌리 일로와");
		}
	}

}
