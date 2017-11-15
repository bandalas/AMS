package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Connecting to the database.
 */
public class Database {
	
	private Connection con;
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public Connection getCon() {
		return con;
	}

	/**
	 * Connects to the database.
	 * @throws Exception error
	 */
	public void connect()  throws Exception{
		
		if(con!=null) return;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			new Exception("Driver not found");
		}
		
		String url = "jdbc:mysql://localhost:3306/hospitalito";
		con = DriverManager.getConnection(url, "root","toor");
	
	}
	
	/**
	 * Disconnects from the database.
	 */
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Cant close");
			}
		}
	}
	
}
