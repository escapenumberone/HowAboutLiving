package com.howaboutliving.dto;

public class PublicDataEnvironment {
	private int id;
	private String sidoName;
	private String stationName;
	private String dataTime;
	private String khaiValue;
	private String so2Value;
	private String coValue;
	private String o3Value;
	private String no2Value;
	private String pm10Value;
	private String pm25Value;
	private String khaiGrade;
	private String so2Grade;
	private String coGrade;
	private String o3Grade;
	private String no2Grade;
	private String pm10Grade;
	private String pm25Grade;

	public PublicDataEnvironment(int id, String sidoName, String stationName, String dataTime, String khaiValue,
			String so2Value, String coValue, String o3Value, String no2Value, String pm10Value, String pm25Value,
			String khaiGrade, String so2Grade, String coGrade, String o3Grade, String no2Grade, String pm10Grade,
			String pm25Grade) {
		super();
		this.id = id;
		this.sidoName = sidoName;
		this.stationName = stationName;
		this.dataTime = dataTime;
		this.khaiValue = khaiValue;
		this.so2Value = so2Value;
		this.coValue = coValue;
		this.o3Value = o3Value;
		this.no2Value = no2Value;
		this.pm10Value = pm10Value;
		this.pm25Value = pm25Value;
		this.khaiGrade = khaiGrade;
		this.so2Grade = so2Grade;
		this.coGrade = coGrade;
		this.o3Grade = o3Grade;
		this.no2Grade = no2Grade;
		this.pm10Grade = pm10Grade;
		this.pm25Grade = pm25Grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getDataTime() {
		return dataTime;
	}

	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}

	public String getKhaiValue() {
		return khaiValue;
	}

	public void setKhaiValue(String khaiValue) {
		this.khaiValue = khaiValue;
	}

	public String getSo2Value() {
		return so2Value;
	}

	public void setSo2Value(String so2Value) {
		this.so2Value = so2Value;
	}

	public String getCoValue() {
		return coValue;
	}

	public void setCoValue(String coValue) {
		this.coValue = coValue;
	}

	public String getO3Value() {
		return o3Value;
	}

	public void setO3Value(String o3Value) {
		this.o3Value = o3Value;
	}

	public String getNo2Value() {
		return no2Value;
	}

	public void setNo2Value(String no2Value) {
		this.no2Value = no2Value;
	}

	public String getPm10Value() {
		return pm10Value;
	}

	public void setPm10Value(String pm10Value) {
		this.pm10Value = pm10Value;
	}

	public String getPm25Value() {
		return pm25Value;
	}

	public void setPm25Value(String pm25Value) {
		this.pm25Value = pm25Value;
	}

	public String getKhaiGrade() {
		return khaiGrade;
	}

	public void setKhaiGrade(String khaiGrade) {
		this.khaiGrade = khaiGrade;
	}

	public String getSo2Grade() {
		return so2Grade;
	}

	public void setSo2Grade(String so2Grade) {
		this.so2Grade = so2Grade;
	}

	public String getCoGrade() {
		return coGrade;
	}

	public void setCoGrade(String coGrade) {
		this.coGrade = coGrade;
	}

	public String getO3Grade() {
		return o3Grade;
	}

	public void setO3Grade(String o3Grade) {
		this.o3Grade = o3Grade;
	}

	public String getNo2Grade() {
		return no2Grade;
	}

	public void setNo2Grade(String no2Grade) {
		this.no2Grade = no2Grade;
	}

	public String getPm10Grade() {
		return pm10Grade;
	}

	public void setPm10Grade(String pm10Grade) {
		this.pm10Grade = pm10Grade;
	}

	public String getPm25Grade() {
		return pm25Grade;
	}

	public void setPm25Grade(String pm25Grade) {
		this.pm25Grade = pm25Grade;
	}

	@Override
	public String toString() {
		return "PublicDataEnvironment [id=" + id + ", sidoName=" + sidoName + ", stationName=" + stationName
				+ ", dataTime=" + dataTime + ", khaiValue=" + khaiValue + ", so2Value=" + so2Value + ", coValue="
				+ coValue + ", o3Value=" + o3Value + ", no2Value=" + no2Value + ", pm10Value=" + pm10Value
				+ ", pm25Value=" + pm25Value + ", khaiGrade=" + khaiGrade + ", so2Grade=" + so2Grade + ", coGrade="
				+ coGrade + ", o3Grade=" + o3Grade + ", no2Grade=" + no2Grade + ", pm10Grade=" + pm10Grade
				+ ", pm25Grade=" + pm25Grade + "]";
	}

}