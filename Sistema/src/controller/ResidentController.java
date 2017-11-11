package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import database.ResidentDB;
import model.Database;
import model.Resident;
import model.User;

public class ResidentController {
	ResidentDB rdb = new ResidentDB();
	
	public ArrayList<Resident> getUserTable() throws SQLException {
		return rdb.getResidentTable();
	}
	
	public Date stringToDate(String date) {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
		Date myDate;
		try {
			myDate = format.parse(date);
			return myDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void connect() throws Exception {
		rdb.connect();
	}
	
	public void disconnect() {
		rdb.disconnect();
	}

	public void addResident(String firstName, String secondName, String secondName2,
			String date, String room, String bed) throws SQLException {		
		
		String lastName = secondName+" "+secondName2;
		Date d = stringToDate(date);
		String id = idConverter(firstName,secondName,secondName2,date);
		Resident resident = new Resident(id,firstName,lastName, d, "VIVO", room, bed);
	
		rdb.add(resident);
		rdb.addResident();
		disconnect();
	}
	
	private String idConverter(String firstName, String secondName, String secondName2,
			String date) {
		String id = firstName.charAt(0)+secondName.substring(0,2)+ secondName2.charAt(0);
		String[] d = date.split("/");
		for(int i = d.length-1 ; i>=0 ; i--) {
			id+=d[i];
		}
		return id.toUpperCase();
	}

	public String idConverter(ArrayList<String> names, String date) {
		String[] lastNames = names.get(1).split(" ");
		String id = names.get(0).charAt(0) + lastNames[0].substring(0,2) + lastNames[1].charAt(0);
		String[] d = date.split("-");
		for(int i = 0 ; i<d.length ; i++) {
			id+=d[i];
		}
		return id.toUpperCase();
	}

	public String dateConverter(String date) {
		String[] formattedDate = date.split("-");
		String correctDate = "";
		for(int i = formattedDate.length-1 ; i>=0 ; i--) {
			if(i>0) {
				correctDate+=formattedDate[i]+"/";
			}else {
				correctDate+=formattedDate[i];
			}
		}
		return correctDate;
	}
	
	public void deleteResident(String residentID) throws SQLException {
		rdb.deleteResident(residentID);
	}
	
	public void editResident(String residentID) throws SQLException {
		rdb.updateResident(residentID);
	}
	
	public ArrayList<String> getResident(String residentID){
		ArrayList<String> data = new ArrayList<String>();
		try {
			Resident r = fetchResidentData(residentID);
			data.add(r.getFirstName());
			data.add(r.getLastName());
			data.add(r.getBirthDate().toString());
			data.add(r.getStatus());
			data.add(r.getRoom());
			data.add(r.getBed());
			
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private Resident fetchResidentData(String residentID) throws SQLException {
		Resident r = rdb.getResident(residentID);
		return r;
	}
	
}
