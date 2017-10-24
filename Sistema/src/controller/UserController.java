package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Database;
import model.Employee;
import model.User;

public class UserController {
	Database db = new Database();
	
	public ArrayList<User> getUser(){
		return db.getUser();
	}
	
	public void removeUser(int index) {
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
	
	public boolean canLog(String username, String password) throws SQLException {
		return db.canLogin(username, password);
	}
	public void addUser(String registrationNumber, String password) throws SQLException {		
		User u = new User(registrationNumber, password);
		
		db.addUser(u);
		db.saveUserTable();
		db.disconnect();
	}

}
