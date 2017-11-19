package model;

import java.util.Date;

/**
 * A resident's medicine prescriptions.
 */
public class Prescription {

	private String residentid;
	private String doctorName;
	private Date date;
	private String symptoms;
	private String description;
	private int id;
	
	/**
	 * @param prescriptionid Auto generated id.
	 * @param residentid The id of the resident.
	 * @param doctorName The name of the doctor.
	 * @param date The date in which the prescription was made.
	 * @param symptoms The symptoms of the resident.
	 * @param description A description.
	 */
	public Prescription (String residentid, String doctorName, Date date, String symptoms, String description) {
		this.setResidentid(residentid);
		this.setDoctorName(doctorName);
		this.setDate(date);
		this.setSymptoms(symptoms);
		this.setDescription(description);
	}
	
	public Prescription (int pid, String residentid, String doctorName, Date date, String symptoms, String description) {
		this.id = pid;
		this.setResidentid(residentid);
		this.setDoctorName(doctorName);
		this.setDate(date);
		this.setSymptoms(symptoms);
		this.setDescription(description);
	}

	public Prescription() {
		// TODO Auto-generated constructor stub
	}

	public String getResidentid() {
		return residentid;
	}

	public void setResidentid(String residentid) {
		this.residentid = residentid;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
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
	
	public int getID() {
		return id;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
