package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import database.UserDB;
import model.User;

/**
 * For the users table in the database.
 */
public class UserController {
	private UserDB udb = new UserDB();
	
	/**
	 * @return The users table as an array.
	 * @throws SQLException error
	 */
	public ArrayList<User> getUserTable() throws SQLException {
		return udb.getUserTable();
	}
	
	/**
	 * Deletes a user from the database.
	 * @param username The username.
	 * @throws SQLException
	 */
	public void removeUser(String username) throws SQLException {
		udb.deleteUser(username);
	}
	
	/**
	 * Connects to the database.
	 * @throws Exception error
	 */
	public void connect() throws Exception {
		udb.connect();
	}
	
	/**
	 * Disconnects from the database.
	 */
	public void disconnect() {
		udb.disconnect();
	}
	
	/**
	 * Checks if a user/password combination is correct.
	 * @param username Username.
	 * @param password Password.
	 * @return Whether the user/password combination is correct.
	 * @throws SQLException error
	 */
	public boolean canLog(String username, String password) throws SQLException {
		return udb.canLogin(username, password);
	}
	
	/**
	 * @param name Name.
	 * @param username Username.
	 * @param password Password.
	 * @param phone Phone number.
	 * @throws SQLException error
	 */
	public void addUser(String name, String username, String password, String phone) throws SQLException {		
		User u = new User(name, username, password, phone);
	
		udb.addUser(u);
		disconnect();
	}

}
