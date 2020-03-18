package models;

public class Event {
	
	private String _id;
	private int schedule;
	private String location;
	private String description;
	private int available_staff;
	private boolean active;

	public Event(String _id, int schedule, String location, String description, int available_staff, boolean active) {
		super();
		this._id = _id;
		this.schedule = schedule;
		this.location = location;
		this.description = description;
		this.available_staff = available_staff;
		this.active = active;
	}

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public String get_id() {
		return _id;
	}

	public int getschedule() {
		return schedule;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}


	public boolean isActive() {
		return active;
	}
	
	@Override
	public String toString() {
		return "Event [_id=" + _id + ", schedule=" + schedule + ", location=" + location + ", description="
				+ description + ", available_staff=" + available_staff + ", active=" + active + "]";
	}

	public void setschedule(int schedule) {
		this.schedule = schedule;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	public int getAvailable_staff() {
		return available_staff;
	}

	public void setAvailable_staff(int available_staff) {
		this.available_staff = available_staff;
	}

	public void set_id(String _id) {
		this._id = _id;
	}


}
