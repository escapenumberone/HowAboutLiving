package com.howaboutliving.dto;

public class PublicDataEnvironment {
	private int id;
	private String station_name;
	private String data_time;
	private String all_value;
	private String so2_value;
	private String co_value;
	private String o3_value;
	private String no2_value;
	private String finedust_value;
	private String ultra_finedust_value;
	private String all_grade;
	private String so2_grade;
	private String co_grade;
	private String o3_grade;
	private String no2_grade;
	private String finedust_grade;
	private String ultra_finedust_grade;
	
	public PublicDataEnvironment() {}

	public PublicDataEnvironment(int id, String station_name, String data_time, String all_value, String so2_value,
			String co_value, String o3_value, String no2_value, String finedust_value, String ultra_finedust_value,
			String all_grade, String so2_grade, String co_grade, String o3_grade, String no2_grade,
			String finedust_grade, String ultra_finedust_grade) {
		super();
		this.id = id;
		this.station_name = station_name;
		this.data_time = data_time;
		this.all_value = all_value;
		this.so2_value = so2_value;
		this.co_value = co_value;
		this.o3_value = o3_value;
		this.no2_value = no2_value;
		this.finedust_value = finedust_value;
		this.ultra_finedust_value = ultra_finedust_value;
		this.all_grade = all_grade;
		this.so2_grade = so2_grade;
		this.co_grade = co_grade;
		this.o3_grade = o3_grade;
		this.no2_grade = no2_grade;
		this.finedust_grade = finedust_grade;
		this.ultra_finedust_grade = ultra_finedust_grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getData_time() {
		return data_time;
	}

	public void setData_time(String data_time) {
		this.data_time = data_time;
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

	public String getUltra_finedust_value() {
		return ultra_finedust_value;
	}

	public void setUltra_finedust_value(String ultra_finedust_value) {
		this.ultra_finedust_value = ultra_finedust_value;
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

	public String getUltra_finedust_grade() {
		return ultra_finedust_grade;
	}

	public void setUltra_finedust_grade(String ultra_finedust_grade) {
		this.ultra_finedust_grade = ultra_finedust_grade;
	}

	@Override
	public String toString() {
		return "PublicDataEnvironment [id=" + id + ", station_name=" + station_name + ", data_time=" + data_time
				+ ", all_value=" + all_value + ", so2_value=" + so2_value + ", co_value=" + co_value + ", o3_value="
				+ o3_value + ", no2_value=" + no2_value + ", finedust_value=" + finedust_value
				+ ", ultra_finedust_value=" + ultra_finedust_value + ", all_grade=" + all_grade + ", so2_grade="
				+ so2_grade + ", co_grade=" + co_grade + ", o3_grade=" + o3_grade + ", no2_grade=" + no2_grade
				+ ", finedust_grade=" + finedust_grade + ", ultra_finedust_grade=" + ultra_finedust_grade + "]";
	}

}