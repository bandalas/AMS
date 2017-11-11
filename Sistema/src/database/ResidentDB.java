package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Database;
import model.Resident;
import model.User;

public class ResidentDB extends Database{
	
	private ArrayList<Resident> resident;
	private Connection con;
	
	public ResidentDB() {
		resident = new ArrayList<Resident>();
		try {
			connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.con = getCon();
	}
	
	public void add(Resident r) {
		resident.add(r);
	}
	
	public void addResident() throws SQLException {
		
		String checkQuery = checkIfExistsQuery("Residents", "ResidentID");
		PreparedStatement checkStmt = con.prepareStatement(checkQuery);
		
		String insertQuery = "INSERT INTO Residents (ResidentID, FirstName, LastName, DateOfBirth, Status, Room, Bed) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);
		
		for(Resident r : resident) {
			
			checkStmt.setString(1, r.getId());
			
			ResultSet checkResult = checkStmt.executeQuery();
			checkResult.next();
			
			int count = checkResult.getInt(1);
			
			String idString = r.getId();
			String name = r.getFirstName();
			String lastName = r.getLastName();
			java.sql.Date sqlDate = new java.sql.Date( r.getBirthDate().getTime() );
			String status = r.getStatus();
			String room = r.getRoom();
			String bed = r.getBed();
			
			if(count == 0) {
				int col = 1;
				insertStmt.setString(col++, idString);
				insertStmt.setString(col++, name);
				insertStmt.setString(col++, lastName);
				insertStmt.setDate(col++, sqlDate);
				insertStmt.setString(col++, status);
				insertStmt.setString(col++, room);
				insertStmt.setString(col++, bed);
				insertStmt.executeUpdate();
			}

			checkStmt.close();
			disconnect();
			
		}
	}
	
	public ArrayList<Resident> getResidentTable() throws SQLException {
		
		String sql = "SELECT * FROM Residents";
		Statement selectSt = con.createStatement();
		
		ResultSet rs = selectSt.executeQuery(sql);
		while(rs.next()) {
			String id = rs.getString("ResidentID");
			String name = rs.getString("FirstName");
			String lastname = rs.getString("LastName");
			Date birth = rs.getDate("DateOfBirth");
			String status = rs.getString("Status");
			String room = rs.getString("Room");
			String bed = rs.getString("Bed");
			resident.add(new Resident(id,name, lastname, birth, status, room, bed));
		}
		return resident;
		
	}
	
	public void deleteResident(String residentID) throws SQLException {
		String sql = "DELETE FROM Residents WHERE ResidentID=?";
		PreparedStatement checkStmt = con.prepareStatement(sql);
		checkStmt.setString(1, residentID);
		checkStmt.executeUpdate();
	}
	
	public void updateResident(String residentID) throws SQLException {
		String updateSql = "UPDATE Residents SET ResidentID=?, FirstName=?, LastName=?, "
				+ "DateOfBirth=?, Status=?, Room=?, Bed=? where ResidentID=?";
		PreparedStatement updateStatement = con.prepareStatement(updateSql);
		
		for(Resident r : resident) {
					
			String idString = r.getId();
			String name = r.getFirstName();
			String lastName = r.getLastName();
			java.sql.Date sqlDate = new java.sql.Date( r.getBirthDate().getTime() );
			String status = r.getStatus();
			String room = r.getRoom();
			String bed = r.getBed();
			
			int col = 1;
			updateStatement.setString(col++, idString);
			updateStatement.setString(col++, name);
			updateStatement.setString(col++, lastName);
			updateStatement.setDate(col++, sqlDate);
			updateStatement.setString(col++, status);
			updateStatement.setString(col++, room);
			updateStatement.setString(col++, bed);
			updateStatement.executeUpdate();
			
		}
		updateStatement.close();
		disconnect();
	}
	
	private String checkIfExistsQuery(String table, String primaryKey) {
		String s = "SELECT COUNT(*) as COUNT FROM " +table+" WHERE " +primaryKey + "=?";
		return s;
	}

	public Resident getResident(String residentID) throws SQLException {
		String sql = "SELECT * FROM Residents WHERE ResidentID='"+residentID+"'";
		Statement selectSt = con.createStatement();
		
		ResultSet rs = selectSt.executeQuery(sql);
		Resident r = new Resident();
		while(rs.next()) {
			
			String id = rs.getString("ResidentID");
			String name = rs.getString("FirstName");
			String lastname = rs.getString("LastName");
			Date birth = rs.getDate("DateOfBirth");
			String status = rs.getString("Status");
			String room = rs.getString("Room");
			String bed = rs.getString("Bed");
			Resident aux = new Resident(id,name, lastname, birth, status, room, bed);
			r = aux;
		}
		return r;
	}

}
