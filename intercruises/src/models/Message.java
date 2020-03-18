package models;

public class Message {
	
	private int id;
	private String userName;
	private String Messae;

	public Message(int id, String userName, String messae) {
		super();
		this.id = id;
		this.userName = userName;
		Messae = messae;
	}
	
	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getMessae() {
		return Messae;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", userName=" + userName + ", Messae=" + Messae + "]";
	}

}
