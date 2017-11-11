package model;

import java.util.Date;

public class SpecialCare {
	private int careid;
	private int eventid;
	private Date startDate;
	private Date endDate;
	
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
