package model;

public class User {
	private String registrationNumber;
	private String password;
	
	public User(String registrationNumber, String password) {
		this.registrationNumber = registrationNumber;
		this.password = password;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	};	

}
