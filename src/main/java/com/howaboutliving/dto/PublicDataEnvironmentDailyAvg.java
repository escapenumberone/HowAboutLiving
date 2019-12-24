package com.howaboutliving.dto;

public class PublicDataEnvironmentDailyAvg {
	private int id;
	private String day_date;
	private String station_name;
	private int all_avg_value;
	private int all_avg_grade;

	public PublicDataEnvironmentDailyAvg() {}
	
	public PublicDataEnvironmentDailyAvg(int id, String day_date, String station_name, int all_avg_value, int all_avg_grade) {
		super();
		this.id = id;
		this.day_date = day_date;
		this.station_name = station_name;
		this.all_avg_value = all_avg_value;
		this.all_avg_grade = all_avg_grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay_date() {
		return day_date;
	}

	public void setDay_date(String day_date) {
		this.day_date = day_date;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public int getAll_avg_value() {
		return all_avg_value;
	}

	public void setAll_avg_value(int all_avg_value) {
		this.all_avg_value = all_avg_value;
	}

	public int getAll_avg_grade() {
		return all_avg_grade;
	}

	public void setAll_avg_grade(int all_avg_grade) {
		this.all_avg_grade = all_avg_grade;
	}

	@Override
	public String toString() {
		return "PublicDataEnvironmentDailyAvg [id=" + id + ", day_date=" + day_date + ", station_name=" + station_name
				+ ", all_avg_value=" + all_avg_value + ", all_avg_grade=" + all_avg_grade + "]";
	}

}
