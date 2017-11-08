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

	private ArrayList<User> userList;
	private Database db;
	private Connection con;

	public UserDB() {
		userList = new ArrayList<User>();
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
		String checkQuery = checkIfExistsQuery("Users", "Username");
		PreparedStatement checkStmt = con.prepareStatement(checkQuery);

		String insertQuery = "INSERT INTO Users (Name, Username, Password, Phone) VALUES (?, ?, ?, ?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);

		for (User user : userList) {
			String username = user.getUsername();
			checkStmt.setString(1, username);

			ResultSet checkResult = checkStmt.executeQuery();
			checkResult.next();

			int count = checkResult.getInt(1);
			if (count == 0) {
				System.out.println("Inserting user: " + username);

				int col = 1;
				insertStmt.setString(col++, user.getName());
				insertStmt.setString(col++, username);
				insertStmt.setString(col++, user.getPassword());
				insertStmt.setString(col++, user.getPhone());
				insertStmt.executeUpdate();
			} else {
				System.out.println("User already exists: " + username);
			}
		}
		checkStmt.close();

	}

	public boolean canLogin(String username, String password) throws SQLException {

		String sql = "SELECT COUNT(*) as COUNT FROM Users WHERE Username='" + username + "' AND Password='" + password
				+ "'";
		Statement select = con.createStatement();

		ResultSet rs = select.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);

		if (count == 1)
			return true;

		return false;
	}

	public void addUser(User user) throws SQLException {
		String checkQuery = checkIfExistsQuery("Users", "Username");
		PreparedStatement checkStmt = con.prepareStatement(checkQuery);

		String insertQuery = "INSERT INTO Users (Name, Username, Password, Phone) VALUES (?, ?, ?, ?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);
		
		String username = user.getUsername();
		checkStmt.setString(1, username);

		ResultSet checkResult = checkStmt.executeQuery();
		checkResult.next();

		int count = checkResult.getInt(1);
		if (count == 0) {
			System.out.println("Inserting user: " + username);

			int col = 1;
			insertStmt.setString(col++, user.getName());
			insertStmt.setString(col++, username);
			insertStmt.setString(col++, user.getPassword());
			insertStmt.setString(col++, user.getPhone());
			insertStmt.executeUpdate();
		} else {
			System.out.println("User already exists: " + username);
		}
		checkStmt.close();
	}

	public void deleteUser(String username) throws SQLException {
		String sql = "DELETE FROM Users WHERE Username=?";
		PreparedStatement checkStmt = con.prepareStatement(sql);
		checkStmt.setString(1, username);
		checkStmt.executeUpdate();
	}

	public ArrayList<User> getUserTable() throws SQLException {
		String sql = "SELECT * FROM Users";
		Statement selectSt = con.createStatement();
		
		ResultSet rs = selectSt.executeQuery(sql);
		while(rs.next()) {
			String name = rs.getString("name");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String phone = rs.getString("phone");
			userList.add(new User(name,username,password,phone));
		}
		return userList;
	}

	private String checkIfExistsQuery(String table, String username) {
		String s = "SELECT COUNT(*) as COUNT FROM " + table + " WHERE " + username + "=?";
		return s;
	}
	
}
