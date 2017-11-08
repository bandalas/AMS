package model;

public class User {
	private String name;
	private String username;
	private String password;
	private String phone;
	
	public User(String name, String username, String password, String phone) {
		this.setName(name);
		this.setUsername(username);
		this.setPassword(password);
		this.setPhone(phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}		
}
