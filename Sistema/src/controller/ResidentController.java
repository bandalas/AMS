package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import database.ResidentDB;
import model.Resident;

/**
 * For the residents table in the database.
 */
public class ResidentController {
	private ResidentDB rdb = new ResidentDB();
	
	/**
	 * @return The residents table as an array.
	 * @throws SQLException error
	 */
	public ArrayList<Resident> getUserTable() throws SQLException {
		return rdb.getResidentTable();
	}
	
	/**
	 * Converts a string to a date object.
	 * @param date Date as a string.
	 * @return The date as a Date object.
	 */
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
	
	/**
	 * Connects to the database.
	 * @throws Exception error
	 */
	public void connect() throws Exception {
		rdb.connect();
	}
	
	
	/**
	 * Disconnects from the database.
	 */
	public void disconnect() {
		rdb.disconnect();
	}
	
	
	/**
	 * Adds a resident to the database.
	 * @param firstName First name.
	 * @param secondName First last name.
	 * @param secondName2 Second last name.
	 * @param date Date of birth.
	 * @param room Room in which the resident stays.
	 * @param bed Bed in which the resident sleeps.
	 * @throws SQLException error.
	 */
	public void addResident(String firstName, String secondName, String secondName2,
			String date, String room, String bed) throws SQLException {		
		
		String lastName = secondName+" "+secondName2;
		Date d = stringToDate(date);
		String id = idConverter(firstName,secondName,secondName2,date);
		Resident resident = new Resident(id,firstName,lastName, d, "VIVO", room, bed);
	
		rdb.addResident(resident);
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
	
	
	/**
	 * Calculates a resident's id.
	 * @param names A list with the name of the resident.
	 * @param date Date of birth of the resident.
	 * @return The id.
	 */
	public String idConverter(ArrayList<String> names, String date) {
		String[] lastNames = names.get(1).split(" ");
		String id = names.get(0).charAt(0) + lastNames[0].substring(0,2) + lastNames[1].charAt(0);
		String[] d = date.split("-");
		for(int i = 0 ; i<d.length ; i++) {
			id+=d[i];
		}
		return id.toUpperCase();
	}
	
	/**
	 * Converts a date to the correct format.
	 * @param date Date.
	 * @return Formatted date.
	 */
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
	
	/**
	 * Deletes a resident from the database.
	 * @param residentID The id of the resident.
	 * @throws SQLException error.
	 */
	public void deleteResident(String residentID) throws SQLException {
		rdb.deleteResident(residentID);
	}
	
	/**
	 * Updates a resident in the database.
	 * @param r The resident.
	 * @throws SQLException error.
	 */
	public void editResident(Resident r) throws SQLException {
		rdb.updateResident(r);
	}
	
	/**
	 * Gets the data of a resident.
	 * @param residentID The id of the resident.
	 * @return The data of the resident as an array.
	 */
	public ArrayList<String> getResidentAsArray(String residentID){
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
