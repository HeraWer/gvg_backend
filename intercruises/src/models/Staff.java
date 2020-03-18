package models;

public class Staff {
	
	int id;
	String username;
	String password;
	String name;
	String lastName;
	String dni;
	String birthDate;
	String city;
	//photo
	String role;
	boolean active;
	String unavailability;
	
	public Staff() {
		
	}
	
	public Staff(int id, String username, String password, String name, String lastName, String dni, String birthDate,
			String city, String role, boolean active, String unavailability) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.birthDate = birthDate;
		this.city = city;
		this.role = role;
		this.active = active;
		this.unavailability = unavailability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getUnavailability() {
		return unavailability;
	}

	public void setUnavailability(String unavailability) {
		this.unavailability = unavailability;
	}
	
	
}
