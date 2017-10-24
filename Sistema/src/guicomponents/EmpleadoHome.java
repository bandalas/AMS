package guicomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.EmployeeController;
import model.Employee;

import java.util.List;

public class EmpleadoHome extends JFrame{
	 private JButton deleteBttn;
	 private JButton editBttn;
	 private JTable employeeTable;
	 private JLabel jLabel1;
	 private JButton registerBttn;
	 private JScrollPane scrollTable;
	 private JPanel tablePanel;
	 
	 private EmployeeTableModel et;
	 private EmployeeController ec;
	
	public EmpleadoHome() {
		
		super();
		initComponents();
		
	}
	
	private void buttonEvents() {
		registerBttn.addActionListener(new ActionListener() {
			private RegisterUser ru;

			@Override
			public void actionPerformed(ActionEvent e) {
				ru = new RegisterUser();
				
			}
		});
		editBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = employeeTable.getSelectedRow();
				System.out.println(employeeTable.getModel().getValueAt(row, column).toString());
				
			}
			
		});
	}
	
	public void setData(List<Employee> db) {
		et.setData(db);	
	}
	
	
	private void initComponents() {
		ec = new EmployeeController();
		
		
        tablePanel = new JPanel();
        scrollTable = new JScrollPane();
        employeeTable = new JTable();
        registerBttn = new JButton();
        deleteBttn = new JButton();
        editBttn = new JButton();
        jLabel1 = new JLabel();
        
        employeeTable.setModel(new EmployeeTableModel());
        
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        scrollTable.setViewportView(employeeTable);

        scrollTable.setViewportView(employeeTable);

        registerBttn.setText("Nuevo");

        deleteBttn.setText("Editar");

        editBttn.setText("Eliminar");

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(registerBttn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBttn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editBttn)
                .addGap(27, 27, 27))
            .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Heiti SC", 0, 48)); // NOI18N
        jLabel1.setText("Empleados Registrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
        buttonEvents();
    }
		
}
