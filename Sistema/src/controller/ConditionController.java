package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import database.ConditionDB;
import model.Condition;
import model.Resident;

public class ConditionController {
	private ConditionDB cdb = new ConditionDB();

	

	
	public void connect() throws Exception {
		 cdb.connect();
	}
	
	public void disconnect() {
		cdb.disconnect();
	}
	
	public void addCondition(String residentID, String name, String type, 
			String severity) throws SQLException {
		Condition condition = new Condition(residentID, name, type,severity);
		cdb.addCondition(condition);
		disconnect();
	}
	
	public Condition fetchData(String residentID) throws SQLException {
		Condition r = cdb.getCondition(residentID);
		return r;
	}

}
