package com.howaboutliving.dto;

public class Test {
	private int SEQ;
	private String ITEMID;
	
	public Test(Integer sEQ, String iTEMID) {
		SEQ = sEQ;
		ITEMID = iTEMID;
	}

	public Test(int sEQ, String iTEMID) {
		SEQ = sEQ;
		ITEMID = iTEMID;
	}

	public int getSEQ() {
		return SEQ;
	}

	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}

	public String getITEMID() {
		return ITEMID;
	}

	public void setITEMID(String iTEMID) {
		ITEMID = iTEMID;
	}
	
	
}
