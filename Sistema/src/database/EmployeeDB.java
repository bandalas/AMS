package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Database;
import model.Employee;

public class EmployeeDB extends Database {
	
	private Database db;
	private ArrayList<Employee> employee;
	private Connection con;
	
	public EmployeeDB(){
		employee = new ArrayList<Employee>();
		db = new Database();
		try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.con = db.con;
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
				//System.out.println("Updating person with ID: "+id);
			}
		}
		checkStmt.close();
		
		db.disconnect();
	}
	
	public void addEmployee (Employee e) {
		employee.add(e);
	}
	
	public ArrayList<Employee> getEmployee() throws SQLException{
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
		return employee;
	}
	
	public void deleteEmployee(String registrationNumber) throws SQLException {
		String sql = "DELETE FROM Employees WHERE employeeID=?";
		PreparedStatement checkStmt = con.prepareStatement(sql);
		checkStmt.setString(1, registrationNumber);
		checkStmt.executeUpdate();
	}
	
	private String checkIfExistsQuery(String table, String primaryKey) {
		String s = "SELECT COUNT(*) as COUNT FROM " +table+" WHERE " +primaryKey + "=?";
		return s;
	}

	
	
}
