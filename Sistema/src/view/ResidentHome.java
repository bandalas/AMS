package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResidentHome extends JFrame {
	   private JButton addBttn;
	   private JLabel addLbl;
	   private JTable dataTable;
	   private JButton deleteBttn;
	   private JLabel deleteLbl;
	   private JButton editBttn;
	   private JLabel editLbl;
	   private JLabel instructionLabel;
	   private JPanel menuPanel;
	   private JButton refreshBttn;
	   private JLabel refreshLbl;
	   private JScrollPane scrollPane;
	   private JPanel tablePanel;

	    
	    public ResidentHome() {
	    		super();
	    		initComponents();
	    }
 
	    private void initComponents() {
	  
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	    			
	        menuPanel = new javax.swing.JPanel();
	        editBttn = new JButton();
	        addBttn = new JButton();
	        deleteBttn = new JButton();
	        refreshBttn = new JButton();
	        addLbl = new JLabel();
	        editLbl = new JLabel();
	        deleteLbl = new JLabel();
	        refreshLbl = new JLabel();
	        tablePanel = new JPanel();
	        scrollPane = new JScrollPane();
	        dataTable = new JTable();
	        instructionLabel = new JLabel();

	        editBttn.setIcon(new javax.swing.ImageIcon("img/edit.png"));

	        addBttn.setIcon(new javax.swing.ImageIcon("img/add.png")); 
	       
	        deleteBttn.setIcon(new javax.swing.ImageIcon("img/delete.png")); 

	        refreshBttn.setIcon(new javax.swing.ImageIcon("img/refresh.png")); 

	        addLbl.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
	        addLbl.setText("Agregar");

	        editLbl.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
	        editLbl.setText("Editar");
	        editLbl.setPreferredSize(new java.awt.Dimension(45, 16));

	        deleteLbl.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
	        deleteLbl.setText("Eliminar");
	        deleteLbl.setPreferredSize(new java.awt.Dimension(45, 16));

	        refreshLbl.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
	        refreshLbl.setText("Actualizar");
	        refreshLbl.setPreferredSize(new java.awt.Dimension(45, 16));

	        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
	        menuPanel.setLayout(menuPanelLayout);
	        menuPanelLayout.setHorizontalGroup(
	            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(menuPanelLayout.createSequentialGroup()
	                .addGap(8, 8, 8)
	                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(addBttn)
	                    .addGroup(menuPanelLayout.createSequentialGroup()
	                        .addGap(6, 6, 6)
	                        .addComponent(addLbl)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(menuPanelLayout.createSequentialGroup()
	                        .addComponent(editBttn)
	                        .addGap(15, 15, 15))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
	                        .addComponent(editLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)))
	                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(deleteBttn)
	                    .addGroup(menuPanelLayout.createSequentialGroup()
	                        .addGap(6, 6, 6)
	                        .addComponent(deleteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(refreshBttn)
	                    .addComponent(refreshLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())
	        );
	        menuPanelLayout.setVerticalGroup(
	            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(menuPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(menuPanelLayout.createSequentialGroup()
	                        .addGap(0, 0, Short.MAX_VALUE)
	                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(addBttn)
	                            .addComponent(deleteBttn)
	                            .addComponent(editBttn))
	                        .addGap(2, 2, 2)
	                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(addLbl)
	                            .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(deleteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(editLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                    .addGroup(menuPanelLayout.createSequentialGroup()
	                        .addComponent(refreshBttn)
	                        .addGap(1, 1, 1)
	                        .addComponent(refreshLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(0, 0, Short.MAX_VALUE))))
	        );

	        dataTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3", "Title 4"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	        scrollPane.setViewportView(dataTable);

	        instructionLabel.setText("Doble Click para más información");

	        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
	        tablePanel.setLayout(tablePanelLayout);
	        tablePanelLayout.setHorizontalGroup(
	            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
	                .addGap(0, 0, 0)
	                .addComponent(instructionLabel)
	                .addGap(543, 543, 543))
	            .addGroup(tablePanelLayout.createSequentialGroup()
	                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        tablePanelLayout.setVerticalGroup(
	            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(tablePanelLayout.createSequentialGroup()
	                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(instructionLabel)
	                .addContainerGap(31, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	        );

	        pack();
	    }
}
