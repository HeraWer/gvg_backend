package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Event {
	
	private String _id;
	private int number;
	private NewUser publisher;
	private String titulo;
	private String description;
	private String date_published;
	private boolean active;
	private ArrayList<NewUser> staffs;
	private int seats;
	private HashMap<String, String> location;
	private ArrayList<Schedule> schedule;
	
	public Event(String _id, int number, NewUser publisher, String titulo, String description, String date_published,
			boolean active, ArrayList<NewUser> staffs, int seats, HashMap<String, String> location,
			ArrayList<Schedule> schedule) {
		super();
		this._id = _id;
		this.number = number;
		this.publisher = publisher;
		this.titulo = titulo;
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

	public NewUser getPublisher() {
		return publisher;
	}

	public void setPublisher(NewUser publisher) {
		this.publisher = publisher;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public ArrayList<NewUser> getStaffs() {
		return staffs;
	}

	public void setStaffs(ArrayList<NewUser> staffs) {
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
