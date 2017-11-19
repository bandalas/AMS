package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import database.ConditionDB;
import database.PrescriptionDB;
import database.RelativeDB;
import database.ResidentDB;
import model.Condition;
import model.Medicine;
import model.Prescription;
import model.Resident;
import view.ViewData;

public class ViewDataController {
	private String residentID;
	public ArrayList<String> data;
	private ResidentDB residentdb;
	private RelativeDB relativedb;
	private PrescriptionDB prescriptiondb;
	private ConditionDB conditiondb;
	
	private int presid;
	
	public ViewDataController(String id) {
		this.residentID = id;
		data = new ArrayList<String>();
		try {
			startEverything();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void startEverything() throws SQLException {
		residentdb = new ResidentDB();
		relativedb = new RelativeDB();
		prescriptiondb = new PrescriptionDB();
		conditiondb = new ConditionDB();
		getResident();
		getCondition();
		getPrescription();
		getMedication();
	}
	
	private void getResident() throws SQLException {
		Resident r = residentdb.getResident(residentID);
		data.add(r.getRoom());
		data.add(r.getBed());
		data.add(r.getFirstName());
		data.add(r.getLastName());
		data.add(r.getBirthDate().toString());
		data.add(r.getStatus());
	}
	
	private void getCondition() throws SQLException {
		Condition c = conditiondb.getCondition(residentID);
		data.add(c.getName());
		data.add(c.getType());
		data.add(c.getSeverity());
		System.out.println(data.size());
	}
	private void getPrescription() throws SQLException {
		Prescription p = prescriptiondb.getPrescription(residentID);
		this.presid = p.getID();
		data.add(p.getDoctorName());
		data.add(p.getDate().toString());
		data.add(p.getSymptoms());
		data.add(p.getDescription());
	}
	
	private void getMedication() throws SQLException{
		Medicine m = prescriptiondb.getMedicine( presid);
		data.add(m.getName());
		data.add(Integer.toString(m.getDuration()));
		data.add(Double.toString(m.getDose()));
	}
	
	public ArrayList<String> getData() {
		return data;
	}
	
	
	
}
