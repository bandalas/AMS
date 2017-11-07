package controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.EmployeeDB;
import model.Database;
import model.Employee;

public class EmployeeController {
	
	Database db = new Database();
	EmployeeDB edb = new EmployeeDB();
	
	public List<Employee> getEmployee() throws SQLException{
		return edb.getEmployee();
	}
	

	
	public void connect() throws Exception {
		edb.connect();
	}
	
	public void disconnet() {
		edb.disconnect();
	}
	
	public void deleteEmployee(String registrationNumber ) throws SQLException {
		edb.deleteEmployee(registrationNumber);
	}
	
	public void addEmployee(String registrationNumber, String name, String lastName, String secondLastName, String birthdate,
				String phoneNumber, String address) throws SQLException {
			
		Employee e = new Employee(registrationNumber, name,lastName,secondLastName,birthdate,
				phoneNumber,address);
		
		edb.addEmployee(e);
		edb.saveEmployeeTable();
		edb.disconnect();
	}
}
