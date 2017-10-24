package model;

public class Employee {
	
	private String name,secondLastName,lastName;
	private String birthdate;
	private String phoneNumber;
	private String registrationNumber;
	private String address;
	
	public Employee(String registrationNumber, String name, String lastName, String secondLastName, String birthdate, String phoneNumber,
			String address) {
		this.name = name;
		this.secondLastName = secondLastName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
		this.registrationNumber = registrationNumber;
		this.address = address;
	}
	

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	
	
	
	
}
