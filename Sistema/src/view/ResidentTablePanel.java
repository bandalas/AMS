package view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Resident;
import model.ResidentTableModel;

public class ResidentTablePanel extends JPanel{
	
	private JTable table;
	private ResidentTableModel rtm;
	
	public ResidentTablePanel() {
		rtm = new ResidentTableModel();
		table = new JTable(rtm);
		add(new JScrollPane(table), BorderLayout.CENTER);
		table.setModel(rtm);
	}
	
	public void setData(List<Resident> db) throws SQLException {
		rtm.setData(db);
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
