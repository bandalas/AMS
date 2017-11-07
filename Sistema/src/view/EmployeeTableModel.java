package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import controller.EmployeeController;
import model.Employee;

public class EmployeeTableModel extends AbstractTableModel{
	
	private List <Employee> db;
	private EmployeeController ec = new EmployeeController();
	private String[] colNames = {"Nomina", "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha nacimiento", "Teléfono", "Dirección"};
	
	public EmployeeTableModel() {
		fireTableDataChanged();
	}
	
	public void setData(List<Employee>db) throws SQLException {
		this.db = ec.getEmployee();
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
		return 7;
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Employee e = db.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return e.getRegistrationNumber();
			case 1:
				return e.getName();
			case 2:
				return e.getLastname();
			case 3:
				return e.getSecondLastName();
			case 4:
				return e.getBirthdate();
			case 5:
				return e.getPhoneNumber();
			case 6:
				return e.getAddress();
		}
		return null;
	}

}
