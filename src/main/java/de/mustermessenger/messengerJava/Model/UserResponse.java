package de.mustermessenger.messengerJava.Model;

public class UserResponse {
	private String vorName, name, id;

	public UserResponse(String vorName, String name, String id) {
		this.vorName = vorName;
		this.name = name;
		this.id = id;
	}

	public String getVorName() {
		return vorName;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
}
