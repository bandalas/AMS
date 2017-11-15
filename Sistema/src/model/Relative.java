package model;

/**
 * A resident's relative.
 */
public class Relative {

	private int relativeid;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	/**
	 * @param relativeid Auto generated id.
	 * @param firstName First name.
	 * @param lastName Last name.
	 * @param phone Phone number.
	 * @param address Address.
	 */
	public Relative(int relativeid, String firstName, String lastName, String phone, String address) {
		this.setRelativeid(relativeid);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
	}

	public int getRelativeid() {
		return relativeid;
	}

	public void setRelativeid(int relativeid) {
		this.relativeid = relativeid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
