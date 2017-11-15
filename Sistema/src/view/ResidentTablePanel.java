package view;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ResidentTableModel;

/**
 * Displays the residents table.
 */
public class ResidentTablePanel extends JPanel{
	
	private JTable table;
	private ResidentTableModel rtm;
	
	public ResidentTablePanel() {
		rtm = new ResidentTableModel();
		table = new JTable(rtm);
		add(new JScrollPane(table), BorderLayout.CENTER);
		table.setModel(rtm);
	}
	
	public void setData() throws SQLException {
		rtm.setData();
	}
	
	public void refresh() {
		rtm.fireTableDataChanged();
	}

	public JTable getTable() {
		return table;
	}

	public ResidentTableModel getRtm() {
		return rtm;
	}

	public void setRtm(ResidentTableModel rtm) {
		this.rtm = rtm;
	}
}
