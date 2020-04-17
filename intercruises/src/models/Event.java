package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Event {

	private String _id;
	private int number;
	private String publisher;
	private String title;
	private String description;
	private String date_published;
	private boolean active;
	private ArrayList<String> staffs;
	private int seats;
	private HashMap<String, String> location;
	private ArrayList<Schedule> schedule;
	
	

	public Event(String publisher, String title, String description, boolean active, ArrayList<String> staffs,
			int seats, HashMap<String, String> location, ArrayList<Schedule> schedule) {
		super();
		this.publisher = publisher;
		this.title = title;
		this.description = description;
		this.active = active;
		this.staffs = staffs;
		this.seats = seats;
		this.location = location;
		this.schedule = schedule;
	}

	public Event(String _id, int number, String publisher, String title, String description, String date_published,
			boolean active, ArrayList<String> staffs, int seats, HashMap<String, String> location,
			ArrayList<Schedule> schedule) {
		super();
		this._id = _id;
		this.number = number;
		this.publisher = publisher;
		this.title = title;
		this.description = description;
		this.date_published = date_published;
		this.active = active;
		this.staffs = staffs;
		this.seats = seats;
		this.location = location;
		this.schedule = schedule;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_published() {
		return date_published;
	}

	public void setDate_published(String date_published) {
		this.date_published = date_published;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ArrayList<String> getStaffs() {
		return staffs;
	}

	public void setStaffs(ArrayList<String> staffs) {
		this.staffs = staffs;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public HashMap<String, String> getLocation() {
		return location;
	}

	public void setLocation(HashMap<String, String> location) {
		this.location = location;
	}

	public ArrayList<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Schedule> schedule) {
		this.schedule = schedule;
	}

}
