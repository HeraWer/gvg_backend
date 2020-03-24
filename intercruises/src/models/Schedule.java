package models;

public class Schedule {
	
	private String date;
	private String hour_start;
	private String hour_end;
	
	public Schedule(String date, String hour_start, String hour_end) {
		super();
		this.date = date;
		this.hour_start = hour_start;
		this.hour_end = hour_end;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour_start() {
		return hour_start;
	}
	public void setHour_start(String hour_start) {
		this.hour_start = hour_start;
	}
	public String getHour_end() {
		return hour_end;
	}
	public void setHour_end(String hour_end) {
		this.hour_end = hour_end;
	}
	
}
