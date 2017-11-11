package model;

import java.util.Date;

public class Prescription {
	private int prescriptionid;
	private int residentid;
	private String doctorName;
	private Date date;
	private String symptoms;
	private String description;
	
	public Prescription (int prescriptionid, int residentid, String doctorName, Date date, String symptoms, String description) {
		this.setPrescriptionid(prescriptionid);
		this.setResidentid(residentid);
		this.setDoctorName(doctorName);
		this.setDate(date);
		this.setSymptoms(symptoms);
		this.setDescription(description);
	}

	public int getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(int prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public int getResidentid() {
		return residentid;
	}

	public void setResidentid(int residentid) {
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

	public void setDate(Date date) {
		this.date = date;
	}
}
