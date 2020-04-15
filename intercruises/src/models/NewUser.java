package models;

import java.util.HashMap;

public class NewUser {
	
	private String username;
	private String usernameOld;
	private String password;
	private String name;
	private String lastname;
	private String DNI;
	private String birthdate;
	private HashMap<String, String> location;
	private HashMap<String, String> role;
	private boolean active;
	private boolean unavailability;
	
	public NewUser(String username, String password, String name, String lastname, String DNI, String birthdate,
			HashMap<String, String> location, HashMap<String, String> role, boolean active, boolean unavailability) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.DNI = DNI;
		this.birthdate = birthdate;
		this.location = location;
		this.role = role;
		this.active = active;
		this.unavailability = unavailability;
	}
	public NewUser(String username,String usernameOld, String password, String name, String lastname, String DNI, String birthdate,
			HashMap<String, String> location, HashMap<String, String> role, boolean active, boolean unavailability) {
		super();
		this.username = username;
		this.usernameOld = usernameOld;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.DNI = DNI;
		this.birthdate = birthdate;
		this.location = location;
		this.role = role;
		this.active = active;
		this.unavailability = unavailability;
	}

	public NewUser() {
		// TODO Auto-generated constructor stub
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
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

	public HashMap<String, String> getRole() {
		return role;
	}

	public void setRole(HashMap<String, String> role) {
		this.role = role;
	}
	public void setRoleString(String role) {
		HashMap<String, String> hm = new HashMap<>();
		System.out.println("ROLE: "+role);
		hm.put("role_name",role);
		this.role = hm;
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

	public void setUsernameOld(String usernameOld) {
		this.usernameOld = usernameOld;
		
	}
	
}
