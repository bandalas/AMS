package controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Database;
import model.Employee;

public class EmployeeController {
	Database db = new Database();
	
	
	public List<Employee> getEmployee(){
		return db.getEmployee();
	}
	
	public void removeEmplee(int index) {
		//db.removePerson(index);
	}
	
	public void connect() throws Exception {
		db.connect();
	}
	
	public void disconnet() {
		db.disconnect();
	}
	
	public void load() {
		
	}
	
	public void addEmployee(String registrationNumber, String name, String lastName, String secondLastName, String birthdate,
				String phoneNumber, String address) throws SQLException {
			
		Employee e = new Employee(registrationNumber, name,lastName,secondLastName,birthdate,
				phoneNumber,address);
		
		db.addEmployee(e);
		db.saveEmployeeTable();
		db.disconnect();
	}
}
