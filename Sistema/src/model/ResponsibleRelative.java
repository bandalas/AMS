package model;

public class ResponsibleRelative {
	private int relativeid;
	private int residentid;
	
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
