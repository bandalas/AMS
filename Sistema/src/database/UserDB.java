package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Database;
import model.User;

public class UserDB {
	
	private ArrayList<User> user;
	private Database db;
	private Connection con;

	public UserDB() {
		user = new ArrayList<User>();
		db = new Database();
		try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.con = db.getCon();
	}
	
	public void saveUserTable() throws SQLException {
		String checkQuery = checkIfExistsQuery("Users", "userID");
		PreparedStatement checkStmt = con.prepareStatement(checkQuery);
		
		String insertQuery = "INSERT INTO Users (userID, password) VALUES (?, ?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);
		
		for (User u : user) {
			String id = u.getRegistrationNumber();
			checkStmt.setString(1, id);
			
			ResultSet checkResult = checkStmt.executeQuery();
			checkResult.next();
			
			int count = checkResult.getInt(1);
			if(count == 0) {
				System.out.println("Inserting user with ID: " +id);
				
				int col = 1;
				insertStmt.setString(col++,id);
				insertStmt.setString(col++, u.getPassword());
				insertStmt.executeUpdate();
			} else {
				System.out.println("Updating user with ID: "+id);
			}
		}
		checkStmt.close();
	
	}
	
	public boolean canLogin(String username, String password) throws SQLException {
		
		String sql = "SELECT COUNT(*) as COUNT FROM Users WHERE userID='"+username+ "' AND password='"+password+"'";
		Statement select = con.createStatement();
		
		ResultSet rs = select.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
		
		if(count==1) return true;
		
		return false;
	}
	
	public void addUser(User u) {
		user.add(u);
	}
	
	public void deleteUser(String registrationNumber) throws SQLException {
		String sql = "DELETE FROM Users WHERE userID=?";
		PreparedStatement checkStmt = con.prepareStatement(sql);
		checkStmt.setString(1, registrationNumber);
		checkStmt.executeUpdate();
	}
	
	public ArrayList<User> getUser(){
		return user;
	}
	
	private String checkIfExistsQuery(String table, String primaryKey) {
		String s = "SELECT COUNT(*) as COUNT FROM " +table+" WHERE " +primaryKey + "=?";
		return s;
	}
}
