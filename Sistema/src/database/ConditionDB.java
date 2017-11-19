package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Condition;
import model.Database;
import model.Relative;
import model.Resident;

public class ConditionDB extends Database{
	private Connection con;
	
	
	public ConditionDB() {
		try {
			connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.con = getCon();
	}

	public void addCondition(Condition c) throws SQLException {

		String insertQuery = "INSERT INTO Conditions (ResidentID, Name, Type, Severity) "
				+ "VALUES (?, ?, ?, ?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);

		String name = c.getName();
		String residentID = c.getResidentid();
		String type = c.getType();
		String severity = c.getSeverity();
		
		int col = 1;
		insertStmt.setString(col++, residentID);
		insertStmt.setString(col++, name);
		insertStmt.setString(col++, type);
		insertStmt.setString(col++, severity);
		
		insertStmt.executeUpdate();
		disconnect();

	}
	
	public Condition getCondition(String residentID) throws SQLException {
		String sql = "SELECT * FROM Conditions WHERE ResidentID='" + residentID + "'";
		Statement selectSt = con.createStatement();

		ResultSet rs = selectSt.executeQuery(sql);
		Condition c = new Condition();
		while (rs.next()) {

			String name = rs.getString("Name");
			String type = rs.getString("Type");
			String severity = rs.getString("Severity");		
			Condition aux = new Condition(residentID, name, type, severity);
			c = aux;
		}
		return c;
	}

}
