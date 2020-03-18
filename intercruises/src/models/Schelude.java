package models;

public class Schelude {
	
	String date;
	String timeInterval;
	
	public Schelude(String date, String timeInterval) {
		super();
		this.date = date;
		this.timeInterval = timeInterval;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}
	
	
	
}
