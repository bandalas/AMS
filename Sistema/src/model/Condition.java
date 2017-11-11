package model;

public class Condition {
	private int conditionid;
	private int residentid;
	private String name;
	private String type;
	private String severity;
	
	public Condition(int conditionid, int residentid, String name, String type, String severity) {
		this.conditionid = conditionid;
		this.residentid = residentid;
		this.name = name;
		this.type = type;
		this.severity = severity;
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

	public int getConditionid() {
		return conditionid;
	}

	public void setConditionid(int conditionid) {
		this.conditionid = conditionid;
	}

	public int getResidentid() {
		return residentid;
	}

	public void setResidentid(int residentid) {
		this.residentid = residentid;
	}
	
}
