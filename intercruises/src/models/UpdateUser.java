package models;

public class UpdateUser {

	private String oldUsername;
	private String newUsername;
	private String newPassword;

	public UpdateUser(String oldUsername, String newUsername, String newPassword) {
		super();
		this.oldUsername = oldUsername;
		this.newUsername = newUsername;
		this.newPassword = newPassword;
	}

	public String getOldUsername() {
		return oldUsername;
	}

	public void setOldUsername(String oldUsername) {
		this.oldUsername = oldUsername;
	}

	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
