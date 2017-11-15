package model;

/**
 * A resident's medicines.
 */
public class Medicine {
	private int medicineid;
	private int prescriptionid;
	private String name;
	private int duration;
	private Double dose;
	private int frequence;
	private String indications;
	
	/**
	 * @param medicineid  Auto generated id.
	 * @param prescriptionid  The id of the prescription in which this medicine was prescribed.
	 * @param name The name of the medicine.
	 * @param duration The duration in days of the medicine.
	 * @param dose The dose of the medicine.
	 * @param frequence How often (in days) should the resident take the dose.
	 * @param indications General indications.
	 */
	public Medicine(int medicineid, int prescriptionid, String name, int duration, Double dose, int frequence, String indications ) {
		this.setMedicineid(medicineid);
		this.setPrescriptionid(prescriptionid);
		this.setDuration(duration);
		this.setDose(dose);
		this.setFrequence(frequence);
		this.setIndications(indications);
	}

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

	public int getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(int prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Double getDose() {
		return dose;
	}

	public void setDose(Double dose) {
		this.dose = dose;
	}

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	public String getIndications() {
		return indications;
	}

	public void setIndications(String indications) {
		this.indications = indications;
	}
}
