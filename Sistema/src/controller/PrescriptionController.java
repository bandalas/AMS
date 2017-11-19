package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.PrescriptionDB;
import model.Condition;
import model.Medicine;
import model.Prescription;

public class PrescriptionController {
private PrescriptionDB pdb = new PrescriptionDB();
	
	public void connect() throws Exception {
		 pdb.connect();
	}
	
	public void disconnect() {
		pdb.disconnect();
	}
		
	public void addPrescription(String residentID, String doctorName, String date, 
			String symptoms, String description) throws SQLException {
		
		String residentid = residentID;
		String doctor = doctorName;
		Date dat = stringToDate(date);
		String symp = symptoms;
		String desc = description;
		Prescription prescription = new Prescription(residentid, doctor, dat, symp, desc);
		pdb.addPrescription(prescription);
		
	}

	public void addMedicine(String name, int duration, Double dose) throws SQLException {
		Medicine m = new Medicine(name, duration, dose);
		pdb.addMedicine(m);
	}
	
	public Date stringToDate(String date) {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
		Date myDate;
		try {
			myDate = format.parse(date);
			return myDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
