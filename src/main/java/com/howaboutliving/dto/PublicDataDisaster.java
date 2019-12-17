package com.howaboutliving.dto;

public class PublicDataDisaster {
	String dsstrRiskLc;
	String dsstrRiskAddr;
	String dsstrRiskType;
	String dsstrRiskGrad;
	String appnDate;
	String infoModDate;
	String relisDate;

	public PublicDataDisaster(String dsstrRiskLc, String dsstrRiskAddr, String dsstrRiskType,
			String dsstrRiskGrad, String appnDate, String infoModDate, String relisDate) {
		this.dsstrRiskLc = dsstrRiskLc;
		this.dsstrRiskAddr = dsstrRiskAddr;
		this.dsstrRiskType = dsstrRiskType;
		this.dsstrRiskGrad = dsstrRiskGrad;
		this.appnDate = appnDate;
		this.infoModDate = infoModDate;
		this.relisDate = relisDate;
	}
	public String getDsstrRiskLc() {
		return dsstrRiskLc;
	}
	public void setDsstrRiskLc(String dsstrRiskLc) {
		this.dsstrRiskLc = dsstrRiskLc;
	}
	public String getDsstrRiskAddr() {
		return dsstrRiskAddr;
	}
	public void setDsstrRiskAddr(String dsstrRiskAddr) {
		this.dsstrRiskAddr = dsstrRiskAddr;
	}
	public String getDsstrRiskType() {
		return dsstrRiskType;
	}
	public void setDsstrRiskType(String dsstrRiskType) {
		this.dsstrRiskType = dsstrRiskType;
	}
	public String getDsstrRiskGrad() {
		return dsstrRiskGrad;
	}
	public void setDsstrRiskGrad(String dsstrRiskGrad) {
		this.dsstrRiskGrad = dsstrRiskGrad;
	}
	public String getAppnDate() {
		return appnDate;
	}
	public void setAppnDate(String appnDate) {
		this.appnDate = appnDate;
	}
	public String getInfoModDate() {
		return infoModDate;
	}
	public void setInfoModDate(String infoModDate) {
		this.infoModDate = infoModDate;
	}
	public String getRelisDate() {
		return relisDate;
	}
	public void setRelisDate(String relisDate) {
		this.relisDate = relisDate;
	}
	
}
