package controller;

import java.sql.SQLException;

import database.RelativeDB;
import model.Relative;

public class RelativeController {
	private RelativeDB rdb = new RelativeDB();
	
	public void connect() throws Exception {
		rdb.connect();
	}
	
	public void disconnect() {
		rdb.disconnect();
	}
	
	public void addRelative(String firstName, String lastName, String telephone, 
			String address, String city) throws SQLException {
		String add = city+","+address;
		Relative relative = new Relative(firstName,lastName, telephone,add);
		rdb.addRelative(relative);
		disconnect();
	}
	
	
	
}
