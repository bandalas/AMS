package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;

public class Database {
	
	private ArrayList<Employee> employee;
	private ArrayList<User> user;
	private Connection con;
	
	public Database() {
		employee = new ArrayList<Employee>();
		user = new ArrayList<User>();
	}
	
	public void connect()  throws Exception{
		
		if(con!=null) return;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			new Exception("Driver not found");
		}
		
		String url = "jdbc:mysql://localhost:3306/hospitalito";
		con = DriverManager.getConnection(url, "root","toor");
	
	}
	
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Cant close");
			}
		}
	}
	
	public void saveEmployeeTable() throws SQLException {
		String checkQuery = checkIfExistsQuery("Employees", "employeeID");
		PreparedStatement checkStmt = con.prepareStatement(checkQuery);
		
		String insertQuery = "INSERT INTO Employees (employeeID, name, lastname, secondlastname, birth, phonenumber,address) VALUES (?, ?, ?, ?, ?, ?,?)";
		PreparedStatement insertStmt = con.prepareStatement(insertQuery);
		
		for (Employee e : employee) {
			int id = Integer.parseInt(e.getRegistrationNumber());
			checkStmt.setInt(1, id);
			
			ResultSet checkResult = checkStmt.executeQuery();
			checkResult.next();
			
			int count = checkResult.getInt(1);
			if(count == 0) {
				System.out.println("Inserting person with ID: " +id);
				
				int col = 1;
				insertStmt.setInt(col++,id);
				insertStmt.setString(col++, e.getName());
				insertStmt.setString(col++, e.getLastname());
				insertStmt.setString(col++, e.getSecondLastName());
				insertStmt.setString(col++, e.getBirthdate());
				insertStmt.setString(col++, e.getPhoneNumber());
				insertStmt.setString(col++, e.getAddress());
				
				insertStmt.executeUpdate();
			} else {
				System.out.println("Updating person with ID: "+id);
			}
		}
		checkStmt.close();
	
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
		// String sql = "SELECT COUNT (userID) AS COUNT FROM Users WHERE userID="+username+" AND password="+password;
		String sql = "SELECT COUNT(*) as COUNT FROM Users WHERE userID='"+username+ "' AND password='"+password+"'";
		Statement select = con.createStatement();
		
		ResultSet rs = select.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
		
		if(count==1) return true;
		
		return false;
	}
	
	public void addEmployee (Employee e) {
		employee.add(e);
	}
	
	public void addUser(User u) {
		user.add(u);
	}
	
	public void loadEmployee() throws SQLException {
		String sql = "SELECT * FROM Employees";
		Statement selectSt = con.createStatement();
		
		ResultSet rs = selectSt.executeQuery(sql);
		while(rs.next()) {
			String registrationNumber = rs.getString("employeeID");
			String name = rs.getString("name");
			String lastName = rs.getString("lastname");
			String secondLastName = rs.getString("secondlastname");
			String birthdate = rs.getString("birth");
			String phoneNumber = rs.getString("phonenumber");
			String address = rs.getString("address");
			
			employee.add(new Employee(registrationNumber,name,lastName,secondLastName,birthdate,phoneNumber,address));
		}
		
	}
	
	public ArrayList<Employee> getEmployee(){
		return employee;
	}
	
	public ArrayList<User> getUser(){
		return user;
	}
	
	private String checkIfExistsQuery(String table, String primaryKey) {
		String s = "SELECT COUNT(*) as COUNT FROM " +table+" WHERE " +primaryKey + "=?";
		return s;
	}

}
