package view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.User;
import model.UserTableModel;


public class UserTablePanel extends JPanel {
	private JTable table;
	private UserTableModel utm;
	
	public UserTablePanel() {
		utm = new UserTableModel();
		table = new JTable(utm);
		add(new JScrollPane(table), BorderLayout.CENTER);
		table.setModel(utm);
	}
	
	public void setData(List<User> db) throws SQLException {
		utm.setData(db);
	}
	
	public void refresh() {
		utm.fireTableDataChanged();
	}

	public JTable getTable() {
		return table;
	}

	public UserTableModel getUtm() {
		return utm;
	}

	public void setEtm(UserTableModel utm) {
		this.utm = utm;
	}
	
}
