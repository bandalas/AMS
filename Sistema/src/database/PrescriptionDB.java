package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.Condition;
import model.Database;
import model.Medicine;
import model.Prescription;

public class PrescriptionDB extends Database{
	private Connection con;
	private int presID;
	private String resID;
	
	public PrescriptionDB() {
		try {
			connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.con = getCon();
	}

	public void addPrescription(Prescription p) throws SQLException {

		String insertQuery = "INSERT INTO Prescriptions (ResidentID, DoctorName, Date, Symptoms, Description) "
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);

		String doctor = p.getDoctorName();
		String residentID = p.getResidentid();
		this.resID = residentID;
		java.sql.Date sqlDate = new java.sql.Date(p.getDate().getTime());
		String symptoms = p.getSymptoms();
		String description = p.getDescription();

		int col = 1;
		insertStmt.setString(col++, residentID);
		insertStmt.setString(col++, doctor);
		insertStmt.setDate(col++, sqlDate);
		insertStmt.setString(col++, symptoms);
		insertStmt.setString(col++, description);

		insertStmt.executeUpdate();

	}
	
	public void addMedicine(Medicine m) throws SQLException {
		String insertQuery = "INSERT INTO Medicines (PrescriptionID, name, DurationDays, DailyDose) "
				+ "VALUES (?, ?, ?, ?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);

		int prescriptionID = getLastInserted();
		this.presID = prescriptionID;
		String name = m.getName();
		int duration = m.getDuration();
		Double dose = m.getDose();
	

		int col = 1;
		insertStmt.setInt(col++, prescriptionID);
		insertStmt.setString(col++, name);
		insertStmt.setInt(col++, duration);
		insertStmt.setDouble(col++, dose);
		

		insertStmt.executeUpdate();
	}
	
	private int getLastInserted() throws SQLException {
		int maxID = 0;
		Statement s2 = con.createStatement();
		s2.execute("SELECT MAX(PrescriptionID) FROM Prescriptions");    
		ResultSet rs2 = s2.getResultSet(); 
		if (rs2.next()){
		  maxID = rs2.getInt(1);
		}
		return maxID;
	}

	public Prescription getPrescription(String residentID) throws SQLException {
		String sql = "SELECT * FROM Prescriptions WHERE ResidentID='" + residentID + "'";
		Statement selectSt = con.createStatement();

		ResultSet rs = selectSt.executeQuery(sql);
		Prescription p = new Prescription();
		while (rs.next()) {
			int id = rs.getInt("PrescriptionID");
			String name = rs.getString("DoctorName");
			Date date = rs.getDate("Date");
			String sym = rs.getString("Symptoms");
			String desc = rs.getString("Description");
			Prescription aux = new Prescription(id,resID, name, date, sym,desc);
			p = aux;
		}
		return p;
	}
	
	public Medicine getMedicine(int prescriptionID) throws SQLException {
		String sql = "SELECT * FROM Medicines WHERE PrescriptionID="+prescriptionID;
		Statement selectSt = con.createStatement();

		ResultSet rs = selectSt.executeQuery(sql);
		Medicine c = new Medicine();
		while (rs.next()) {

			String name = rs.getString("name");
			int duration = rs.getInt("DurationDays");
			Double dosis = rs.getDouble("DailyDose");
			Medicine aux = new Medicine(name, duration, dosis);
			c = aux;
		}
		return c;
	}
}
