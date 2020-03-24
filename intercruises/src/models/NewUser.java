package models;

import java.util.HashMap;

public class NewUser {
	
	private String username;
	private String password;
	private String name;
	private String lastname;
	private String dni;
	private String birthdate;
	private HashMap<String, String> location;
	private String role;
	private boolean active;
	private boolean unavailability;
	
	public NewUser(String username, String password, String name, String lastname, String dni, String birthdate,
			HashMap<String, String> location, String role, boolean active, boolean unavailability) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.birthdate = birthdate;
		this.location = location;
		this.role = role;
		this.active = active;
		this.unavailability = unavailability;
	}
	
	public NewUser() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public HashMap<String, String> getLocation() {
		return location;
	}

	public void setLocation(HashMap<String, String> location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isUnavailability() {
		return unavailability;
	}

	public void setUnavailability(boolean unavailability) {
		this.unavailability = unavailability;
	}
	
}
