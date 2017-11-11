package model;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import controller.ResidentController;

public class ResidentTableModel extends AbstractTableModel{
	
	private List <Resident> db;
	private ResidentController rc = new ResidentController();
	private String[] colNames = {"Nombre", "Apellidos", "Fecha de Nacimiento","Habitación", "Número de cama"};

	public ResidentTableModel() {
		fireTableDataChanged();
	}
	
	public void setData(List<Resident>db) throws SQLException {
		this.db = rc.getUserTable();
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
		return 5;
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Resident r = db.get(rowIndex);
		switch(columnIndex) {
			case 0 :
				return r.getFirstName();
			case 1 :
				return r.getLastName();
			case 2:
				return r.getBirthDate();
			case 3:
				return r.getRoom();
			case 4:
				return r.getBed();
		}
		return null;
	}
	
}
