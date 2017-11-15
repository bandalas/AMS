package model;

import java.util.Date;

/**
 * Call made to remind a family member of a medicine running out.
 */
public class Call {
	
	private int callid;
	private String username;
	private int stockid;
	private int relativeid;
	private Date date;
	private Boolean success;
	
	/**
	 * @param callid Auto generated id.
	 * @param username The user that is registering the call.
	 * @param stockid The id of the medicine stock that is running out.
	 * @param relativeid The id of the relative to who the call was made.
	 * @param date The date when the call was made.
	 * @param success Whether the call was successful or not.
	 */
	public Call(int callid, String username, int stockid, int relativeid, Date date, Boolean success) {
		this.setCallid(callid);
		this.setUsername(username);
		this.setStockid(stockid);
		this.setRelativeid(relativeid);
		this.setDate(date);
		this.setSuccess(success);
	}

	public int getCallid() {
		return callid;
	}

	public void setCallid(int callid) {
		this.callid = callid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public int getRelativeid() {
		return relativeid;
	}

	public void setRelativeid(int relativeid) {
		this.relativeid = relativeid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
}
