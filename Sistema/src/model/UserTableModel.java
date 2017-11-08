package model;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import controller.UserController;

public class UserTableModel extends AbstractTableModel{
	
	private List <User> db;
	private UserController uc = new UserController();
	private String[] colNames = {"Nombre", "Usuario", "Contrasena", "Telefono"};
	
	public UserTableModel() {
		fireTableDataChanged();
	}
	
	public void setData(List<User>db) throws SQLException {
		this.db = uc.getUserTable();
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		User u = db.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return u.getName();
			case 1:
				return u.getUsername();
			case 2:
				return u.getPassword();
			case 3:
				return u.getPhone();
		}
		return null;
	}

}
