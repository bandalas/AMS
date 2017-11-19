package view;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.UserTableModel;


/**
 * Displays the users table.
 */
public class UserTablePanel extends JPanel {
	private JTable table;
	private UserTableModel utm;
	
	public UserTablePanel() {
		utm = new UserTableModel();
		table = new JTable(utm);
		add(new JScrollPane(table), BorderLayout.CENTER);
		table.setModel(utm);
	}
	
	public void setData() throws SQLException {
		utm.setData();
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
