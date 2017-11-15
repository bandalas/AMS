package model;

/**
 * A resident's responsible relative.
 */
public class ResponsibleRelative {
	private int relativeid;
	private int residentid;
	
	/**
	 * @param relativeid The id of the relative.
	 * @param residentid The id of the resident.
	 */
	public ResponsibleRelative (int relativeid, int residentid) {
		this.setRelativeid(relativeid);
		this.setResidentid(residentid);
	}

	public int getResidentid() {
		return residentid;
	}

	public void setResidentid(int residentid) {
		this.residentid = residentid;
	}

	public int getRelativeid() {
		return relativeid;
	}

	public void setRelativeid(int relativeid) {
		this.relativeid = relativeid;
	}
}
