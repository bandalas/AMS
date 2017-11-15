package model;

import java.util.Date;

/**
 * Eventuality.
 */
public class Eventuality {
	
	private int eventid;
	private int residentid;
	private String username;
	private String type;
	private String description;
	private Date date;
	
	/**
	 * @param eventid Auto generated id.
	 * @param residentid The id of the resident.
	 * @param username The id of the user registering the eventuality.
	 * @param type  The type of eventuality.
	 * @param description A description of the eventuality.
	 * @param date The date of the eventuality.
	 */
	public Eventuality(int eventid, int residentid, String username, String type, String description, Date date) {
		this.setEventid(eventid);
		this.setResidentid(residentid);
		this.setUsername(username);
		this.setType(type);
		this.setDescription(description);
		this.setDate(date);
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public int getResidentid() {
		return residentid;
	}

	public void setResidentid(int residentid) {
		this.residentid = residentid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
