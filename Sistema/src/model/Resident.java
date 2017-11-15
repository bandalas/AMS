package model;

import java.util.Date;

/**
 * Resident.
 */
public class Resident {

	private String id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String status;
	private String room;
	private String bed;
	
	/**
	 * @param id Auto generated id.
	 * @param firstName First name.
	 * @param lastName Last name.
	 * @param birthDate Birth date.
	 * @param status Status (death or alive).
	 * @param room Room in which the resident stays.
	 * @param bed Bed in which the resident sleeps.
	 */
	public Resident(String id, String firstName, String lastName, Date birthDate, 
			String status, String room, String bed) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.status = status;
		this.room = room;
		this.bed = bed;
		
	}
	public Resident() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
