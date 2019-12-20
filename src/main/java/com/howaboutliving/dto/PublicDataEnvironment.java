package com.howaboutliving.dto;

public class PublicDataEnvironment {
	private int id;
	private String stationName;
	private String dataTime;
	private String all_value;
	private String so2_value;
	private String co_value;
	private String o3_value;
	private String no2_value;
	private String finedust_value;
	private String ultrafinedust_value;
	private String all_grade;
	private String so2_grade;
	private String co_grade;
	private String o3_grade;
	private String no2_grade;
	private String finedust_grade;
	private String ultrafinedust_grade;

	public PublicDataEnvironment(int id, String stationName, String dataTime, String all_value, String so2_value,
			String co_value, String o3_value, String no2_value, String finedust_value, String ultrafinedust_value,
			String all_grade, String so2_grade, String co_grade, String o3_grade, String no2_grade,
			String finedust_grade, String ultrafinedust_grade) {
		super();
		this.id = id;
		this.stationName = stationName;
		this.dataTime = dataTime;
		this.all_value = all_value;
		this.so2_value = so2_value;
		this.co_value = co_value;
		this.o3_value = o3_value;
		this.no2_value = no2_value;
		this.finedust_value = finedust_value;
		this.ultrafinedust_value = ultrafinedust_value;
		this.all_grade = all_grade;
		this.so2_grade = so2_grade;
		this.co_grade = co_grade;
		this.o3_grade = o3_grade;
		this.no2_grade = no2_grade;
		this.finedust_grade = finedust_grade;
		this.ultrafinedust_grade = ultrafinedust_grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAll_value() {
		return all_value;
	}

	public void setAll_value(String all_value) {
		this.all_value = all_value;
	}

	public String getSo2_value() {
		return so2_value;
	}

	public void setSo2_value(String so2_value) {
		this.so2_value = so2_value;
	}

	public String getCo_value() {
		return co_value;
	}

	public void setCo_value(String co_value) {
		this.co_value = co_value;
	}

	public String getO3_value() {
		return o3_value;
	}

	public void setO3_value(String o3_value) {
		this.o3_value = o3_value;
	}

	public String getNo2_value() {
		return no2_value;
	}

	public void setNo2_value(String no2_value) {
		this.no2_value = no2_value;
	}

	public String getFinedust_value() {
		return finedust_value;
	}

	public void setFinedust_value(String finedust_value) {
		this.finedust_value = finedust_value;
	}

	public String getUltrafinedust_value() {
		return ultrafinedust_value;
	}

	public void setUltrafinedust_value(String ultrafinedust_value) {
		this.ultrafinedust_value = ultrafinedust_value;
	}

	public String getAll_grade() {
		return all_grade;
	}

	public void setAll_grade(String all_grade) {
		this.all_grade = all_grade;
	}

	public String getSo2_grade() {
		return so2_grade;
	}

	public void setSo2_grade(String so2_grade) {
		this.so2_grade = so2_grade;
	}

	public String getCo_grade() {
		return co_grade;
	}

	public void setCo_grade(String co_grade) {
		this.co_grade = co_grade;
	}

	public String getO3_grade() {
		return o3_grade;
	}

	public void setO3_grade(String o3_grade) {
		this.o3_grade = o3_grade;
	}

	public String getNo2_grade() {
		return no2_grade;
	}

	public void setNo2_grade(String no2_grade) {
		this.no2_grade = no2_grade;
	}

	public String getFinedust_grade() {
		return finedust_grade;
	}

	public void setFinedust_grade(String finedust_grade) {
		this.finedust_grade = finedust_grade;
	}

	public String getUltrafinedust_grade() {
		return ultrafinedust_grade;
	}

	public void setUltrafinedust_grade(String ultrafinedust_grade) {
		this.ultrafinedust_grade = ultrafinedust_grade;
	}

	@Override
	public String toString() {
		return "PublicDataEnvironment [id=" + id + ", stationName=" + stationName + ", dataTime=" + dataTime
				+ ", all_value=" + all_value + ", so2_value=" + so2_value + ", co_value=" + co_value + ", o3_value="
				+ o3_value + ", no2_value=" + no2_value + ", finedust_value=" + finedust_value
				+ ", ultrafinedust_value=" + ultrafinedust_value + ", all_grade=" + all_grade + ", so2_grade="
				+ so2_grade + ", co_grade=" + co_grade + ", o3_grade=" + o3_grade + ", no2_grade=" + no2_grade
				+ ", finedust_grade=" + finedust_grade + ", ultrafinedust_grade=" + ultrafinedust_grade + "]";
	}

}