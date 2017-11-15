package model;

import java.util.Date;

/**
 * Absence of a resident.
 */
public class Absence {
	
	private int absenceid;
	private int residentid;
	private Date startDate;
	private Date endDate;
	private String reason;
	
	/**
	 * @param absenceid Auto generated id.
	 * @param residentid  The id of the resident.
	 * @param startDate The start date of the absence.
	 * @param endDate The end date of the absence.
	 * @param reason The reason for the absence.
	 */
	public Absence(int absenceid, int residentid, Date startDate, Date endDate, String reason) {
		this.setAbsenceid(absenceid);
		this.setResidentid(residentid);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setReason(reason);
	}

	public int getAbsenceid() {
		return absenceid;
	}

	public void setAbsenceid(int absenceid) {
		this.absenceid = absenceid;
	}

	public int getResidentid() {
		return residentid;
	}

	public void setResidentid(int residentid) {
		this.residentid = residentid;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
