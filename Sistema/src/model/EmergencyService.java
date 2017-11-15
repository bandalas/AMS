package model;

/**
 * Emergency service of residents.
 */
public class EmergencyService {
	
	private int serviceid;
	private String name;
	private String phone;
	private String includedServices;
	
	/**
	 * @param serviceid Auto generated id.
	 * @param name Name of the emergency service company.
	 * @param phone Phone number.
	 * @param includedServices  Description of the included services.
	 */
	public EmergencyService(int serviceid, String name, String phone, String includedServices) {
		this.setServiceid(serviceid);
		this.setName(name);
		this.setPhone(phone);
		this.setIncludedServices(includedServices);
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIncludedServices() {
		return includedServices;
	}

	public void setIncludedServices(String includedServices) {
		this.includedServices = includedServices;
	}
}
