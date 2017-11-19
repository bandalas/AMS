package model;

/**
 * A resident's medicines.
 */
public class Medicine {

	private String name;
	private int duration;
	private Double dose;

	
	/**
	 * @param medicineid  Auto generated id.
	 * @param prescriptionid  The id of the prescription in which this medicine was prescribed.
	 * @param name The name of the medicine.
	 * @param duration The duration in days of the medicine.
	 * @param dose The dose of the medicine.
	 * @param frequence How often (in days) should the resident take the dose.
	 * @param indications General indications.
	 */
	public Medicine(String name, int duration, Double dose) {
		this.name = name;
		this.setDuration(duration);
		this.setDose(dose);
	}



	public Medicine() {
		// TODO Auto-generated constructor stub
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


}
