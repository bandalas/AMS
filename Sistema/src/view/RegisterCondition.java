package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ConditionController;

public class RegisterCondition extends JFrame{
	private JTextField diseaseInput;
	private JTextField diseaseTypeInput;
	private JComboBox<String> severityComboBox;
	
	private JLabel diseaseTypeLbl;
	private JPanel jPanel1;
	private JButton moreBttn;
	private JLabel moreLbl;
	private JLabel nameLbl;
	private JButton nextBttn;
	private JLabel severityLbl;
	private JLabel titleLbl;
	
	private ArrayList<JTextField> fields;
	private String residentID;
	private String name;
	private String type;
	private String severity;
	private ConditionController cc;
	
	public RegisterCondition(String residentID) {
		super();
		this.residentID = residentID;
		initComponents();
	}

	private boolean hasCompletedFields() {
		for (JTextField f : fields) {
			if (f.getText().equals("")) return false;
		}return true;
	}
	
	private void getInput() {
		this.name = diseaseInput.getText();
		this.type = diseaseTypeInput.getText();
		this.severity = severityComboBox.getSelectedItem().toString();
	}
	
	private void executeMessage() {
		JOptionPane.showMessageDialog(this, "Todos los campos tienen que estar llenos.",
				"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	private void bttnEvents() {
		nextBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(hasCompletedFields()) {
					getInput();
					try {
						cc.addCondition(residentID, name, type, severity);
						dispose();
						new RegisterPrescription(residentID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					executeMessage();
				}	
			}
		});
		
		moreBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(hasCompletedFields()) {
					getInput();
					try {
						cc.addCondition(residentID, name, type, severity);
						dispose();
						new RegisterPrescription(residentID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					executeMessage();
				}
			}	
		});
	}
	
	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fields = new ArrayList<JTextField>();
        jPanel1 = new JPanel();
        nameLbl = new JLabel();
        diseaseInput = new JTextField();
        diseaseTypeLbl = new JLabel();
        diseaseTypeInput = new JTextField();
        severityLbl = new JLabel();
        nextBttn = new JButton();
        titleLbl = new JLabel();
        severityComboBox = new JComboBox<>();
        moreBttn = new JButton();
        moreLbl = new JLabel();
        cc = new ConditionController();
        
        fields.add(diseaseInput);
        fields.add(diseaseTypeInput);
        
        nameLbl.setText("Nombre de la enfermedad:");

        diseaseInput.setToolTipText("");

        diseaseTypeLbl.setText("Tipo de enfermedad:");

        severityLbl.setText("Severidad:");

        nextBttn.setText("Siguiente");
     

        titleLbl.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        titleLbl.setText("ENFERMEDADES");

        severityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Leve", "Moderado", "Grave" }));

        moreBttn.setIcon(new javax.swing.ImageIcon("img/more.png")); // NOI18N
        moreBttn.setToolTipText("");

        moreLbl.setText("Agregar otra enfermedad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(severityLbl)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(diseaseInput, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                .addComponent(nameLbl)
                                .addComponent(diseaseTypeLbl)
                                .addComponent(diseaseTypeInput))
                            .addComponent(severityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(moreBttn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(moreLbl))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(titleLbl)))
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nextBttn)
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(titleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diseaseInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(diseaseTypeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diseaseTypeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(severityLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(severityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(moreBttn)
                    .addComponent(moreLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(nextBttn))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        bttnEvents();
    }
	
}
