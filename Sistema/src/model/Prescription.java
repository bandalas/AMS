package model;

import java.util.Date;

/**
 * A resident's medicine prescriptions.
 */
public class Prescription {

	private int prescriptionid;
	private int residentid;
	private String doctorName;
	private Date date;
	private String symptoms;
	private String description;
	
	/**
	 * @param prescriptionid Auto generated id.
	 * @param residentid The id of the resident.
	 * @param doctorName The name of the doctor.
	 * @param date The date in which the prescription was made.
	 * @param symptoms The symptoms of the resident.
	 * @param description A description.
	 */
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
