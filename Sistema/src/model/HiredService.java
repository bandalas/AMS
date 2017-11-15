package model;

/**
 * The emergency service that a resident has hired.
 */
public class HiredService {

	private int serviceid;
	private int residentid;
	private String clientNumber;
	
	/**
	 * @param serviceid Id of the emergency service.
	 * @param residentid Id of the resident that has hired the emergency service.
	 * @param clientNumber Client number of the resident's hired service.
	 */
	public HiredService(int serviceid, int residentid, String clientNumber) {
		this.setServiceid(serviceid);
		this.setResidentid(residentid);
		this.setClientNumber(clientNumber);
	}

	public int getResidentid() {
		return residentid;
	}

	public void setResidentid(int residentid) {
		this.residentid = residentid;
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}
}
