package view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Employee;


public class EmployeeTablePanel extends JPanel {
	private JTable table;
	private EmployeeTableModel etm;
	
	public EmployeeTablePanel() {
		etm = new EmployeeTableModel();
		table = new JTable(etm);
		add(new JScrollPane(table), BorderLayout.CENTER);
		table.setModel(etm);
	}
	
	public void setData(List<Employee> db) throws SQLException {
		etm.setData(db);
	}
	
	public void refresh() {
		etm.fireTableDataChanged();
	}

	public JTable getTable() {
		return table;
	}

	public EmployeeTableModel getEtm() {
		return etm;
	}

	public void setEtm(EmployeeTableModel etm) {
		this.etm = etm;
	}
	
}
