package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Database;
import model.Relative;
import model.Resident;

public class RelativeDB extends Database{
	private ArrayList<Relative> relative;
	private Connection con;
	
	public RelativeDB() {
		relative = new ArrayList<Relative>();
		try {
			connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.con = getCon();
	}

	public void addRelative(Relative r) throws SQLException {

		String checkQuery = checkIfExistsQuery("Relatives", "RelativeID");
		PreparedStatement checkStmt = con.prepareStatement(checkQuery);

		String insertQuery = "INSERT INTO Relatives (FirstName, LastName, Phone, Address) "
				+ "VALUES (?, ?, ?, ?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);

		String name = r.getFirstName();
		String lastName = r.getLastName();
		String address = r.getAddress();
		String phone = r.getPhone();
		
		int col = 1;
		insertStmt.setString(col++, name);
		insertStmt.setString(col++, lastName);
		insertStmt.setString(col++, phone);
		insertStmt.setString(col++, address);
		insertStmt.executeUpdate();

		checkStmt.close();
		disconnect();

	}
	
	private String checkIfExistsQuery(String table, String primaryKey) {
		String s = "SELECT COUNT(*) as COUNT FROM " + table + " WHERE " + primaryKey + "=?";
		return s;
	}

}
