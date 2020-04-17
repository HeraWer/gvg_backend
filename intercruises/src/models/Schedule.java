package models;

public class Schedule {
	
	private String day;
	private String hour_start;
	private String hour_end;
	
	public Schedule(String day, String hour_start, String hour_end) {
		super();
		this.day = day;
		this.hour_start = hour_start;
		this.hour_end = hour_end;
	}
	
	@Override
	public String toString() {
		return "Schedule [day=" + day + ", hour_start=" + hour_start + ", hour_end=" + hour_end + "]";
	}

	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
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
