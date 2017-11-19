package model;

/**
 * A condition of a resident.
 */
public class Condition {
	private String residentid;
	private String name;
	private String type;
	private String severity;
	
	/**
	 * @param conditionid Auto generated id.
	 * @param residentid The id of the resident.
	 * @param name The name of the condition.
	 * @param type The type of condition.
	 * @param severity The severity of the condition. 
	 */
	public Condition(String residentid, String name, String type, String severity) {
		this.residentid = residentid;
		this.name = name;
		this.type = type;
		this.severity = severity;
	}
	
	public Condition() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getResidentid() {
		return residentid;
	}

	public void setResidentid(String residentid) {
		this.residentid = residentid;
	}
	
}
