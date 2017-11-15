package model;

import java.util.Date;

/**
 * When a resident is in special care.
 */
public class SpecialCare {

	private int careid;
	private int eventid;
	private Date startDate;
	private Date endDate;
	
	/**
	 * @param careid Auto generated id.
	 * @param eventid The id of the eventuality that caused the special care.
	 * @param startDate Star date.
	 * @param endDate End date.
	 */
	public SpecialCare(int careid, int eventid, Date startDate, Date endDate) {
		this.setCareid(careid);
		this.setEventid(eventid);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
	}

	public int getCareid() {
		return careid;
	}

	public void setCareid(int careid) {
		this.careid = careid;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
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
}
