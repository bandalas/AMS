package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import database.UserDB;
import model.Database;
import model.Employee;
import model.User;

public class UserController {
	Database db = new Database();
	UserDB udb = new UserDB();
	
	public ArrayList<User> getUser(){
		return udb.getUser();
	}
	
	public void removeUser(String registrationNumber) throws SQLException {
		udb.deleteUser(registrationNumber);
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
		return udb.canLogin(username, password);
	}
	public void addUser(String registrationNumber, String password) throws SQLException {		
		User u = new User(registrationNumber, password);
	
		udb.addUser(u);
		udb.saveUserTable();
		db.disconnect();
	}

}
