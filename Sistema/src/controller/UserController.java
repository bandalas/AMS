package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import database.UserDB;
import model.Database;
import model.User;

public class UserController {
	Database db = new Database();
	UserDB udb = new UserDB();
	
	public ArrayList<User> getUserTable() throws SQLException {
		return udb.getUserTable();
	}
	
	public void removeUser(String username) throws SQLException {
		udb.deleteUser(username);
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
	public void addUser(String name, String username, String password, String phone) throws SQLException {		
		User u = new User(name, username, password, phone);
	
		udb.addUser(u);
		db.disconnect();
	}

}
