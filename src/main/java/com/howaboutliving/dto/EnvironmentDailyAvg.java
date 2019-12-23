package com.howaboutliving.dto;

public class EnvironmentDailyAvg {
	private int id;
	private String day_date;
	private String station_name;
	private String all_avg_value;
	private String all_avg_grade;

	public EnvironmentDailyAvg(int id, String day_date, String station_name, String all_avg_value,
			String all_avg_grade) {
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

	public String getAll_avg_value() {
		return all_avg_value;
	}

	public void setAll_avg_value(String all_avg_value) {
		this.all_avg_value = all_avg_value;
	}

	public String getAll_avg_grade() {
		return all_avg_grade;
	}

	public void setAll_avg_grade(String all_avg_grade) {
		this.all_avg_grade = all_avg_grade;
	}

	@Override
	public String toString() {
		return "EnvironmentDailyAvg [id=" + id + ", day_date=" + day_date + ", station_name=" + station_name
				+ ", all_avg_value=" + all_avg_value + ", all_avg_grade=" + all_avg_grade + "]";
	}

}
