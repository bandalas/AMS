package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Database {
	
	public Connection con;
	
	public Connection getCon() {
		return con;
	}

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
