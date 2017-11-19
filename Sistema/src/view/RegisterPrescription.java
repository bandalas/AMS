package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.PrescriptionController;

public class RegisterPrescription extends JFrame {
	
	private javax.swing.JFormattedTextField dateInput;
	private javax.swing.JLabel dateLbl;
	private javax.swing.JTextArea descriptionArea;
	private javax.swing.JLabel descriptionLbl;
	private javax.swing.JTextField doctorInput;
	private javax.swing.JLabel doctorLbl;
	private javax.swing.JTextField dosisInput;
	private javax.swing.JTextField dosisInput2;
	private javax.swing.JTextField dosisInput3;
	private javax.swing.JLabel dosisLbl;
	private javax.swing.JLabel dosisLbl2;
	private javax.swing.JLabel dosisLbl3;
	private javax.swing.JTextField durationInput;
	private javax.swing.JTextField durationInput2;
	private javax.swing.JTextField durationInput3;
	private javax.swing.JLabel durationLbl;
	private javax.swing.JLabel durationLbl2;
	private javax.swing.JLabel durationLbl3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JTextField medicineInput;
	private javax.swing.JTextField medicineInput2;
	private javax.swing.JTextField medicineInput3;
	private javax.swing.JLabel medicineLbl;
	private javax.swing.JLabel medicineLbl2;
	private javax.swing.JLabel medicineLbl3;
	private javax.swing.JButton saveBttn;
	private javax.swing.JTextField symptomsInput;
	private javax.swing.JLabel symptomsLbl;
	private javax.swing.JLabel titleLbl;
	private javax.swing.JScrollPane jScrollPane2;
	
	
	//	DATABASE
	private String doctor;
	private String date;
	private String symptoms;
	private String description;
	private String medicine1;
	private int duration1;
	private Double dose1;
	private String medicine2;
	private int duration2;
	private Double dose2;
	private String medicine3;
	private int duration3;
	private Double dose3;
	private String residentID;
	private PrescriptionController pc;
	
	private ArrayList<JTextField> fields;
	
	public RegisterPrescription(String residentID) {
		super();
		this.residentID = residentID;
		initComponents();
	}
	
	public boolean hasCompletedFields() {
		for(JTextField f : fields) {
			if(f.getText().equals("")) return false;	
		}
		if(descriptionArea.getText().equals("")) return false;
		return true;
	}
	
	private void executeMessage() {
		JOptionPane.showMessageDialog(this, "Todos los campos tienen que estar llenos.",
				"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void bottonEvents() {
		saveBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(hasCompletedFields()) {
					try {
						getInputText();
						pc.addPrescription(residentID, doctor, date, symptoms, description);
						pc.addMedicine(medicine1, duration1, dose1);
						pc.addMedicine(medicine2, duration2, dose2);
						pc.addMedicine(medicine3, duration3, dose3);
						dispose();
						new ResidentHome();
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
	
	public void getInputText() {
		this.doctor = doctorInput.getText();
		this.date = dateInput.getText();
		this.symptoms = symptomsInput.getText();
		this.description = descriptionArea.getText();
		this.medicine1 = medicineInput.getText();
		this.duration1 = Integer.parseInt(durationInput.getText());
		this.dose1 = Double.parseDouble(dosisInput.getText());
		this.medicine2 = medicineInput2.getText();
		this.duration2 = Integer.parseInt(durationInput2.getText());
		this.dose2 = Double.parseDouble(dosisInput2.getText());
		this.medicine3= medicineInput3.getText();
		this.duration3 = Integer.parseInt(durationInput3.getText());
		this.dose3 = Double.parseDouble(dosisInput3.getText());
		
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pc = new PrescriptionController();
		jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        doctorLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        symptomsLbl = new javax.swing.JLabel();
        descriptionLbl = new javax.swing.JLabel();
        doctorInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        symptomsInput = new javax.swing.JTextField();
        saveBttn = new javax.swing.JButton();
        titleLbl = new javax.swing.JLabel();
        medicineLbl = new javax.swing.JLabel();
        medicineInput = new javax.swing.JTextField();
        durationLbl = new javax.swing.JLabel();
        durationInput = new javax.swing.JTextField();
        dosisLbl = new javax.swing.JLabel();
        dosisInput = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        medicineLbl2 = new javax.swing.JLabel();
        medicineInput2 = new javax.swing.JTextField();
        durationLbl2 = new javax.swing.JLabel();
        durationInput2 = new javax.swing.JTextField();
        dosisLbl2 = new javax.swing.JLabel();
        dosisInput2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        medicineLbl3 = new javax.swing.JLabel();
        medicineInput3 = new javax.swing.JTextField();
        durationLbl3 = new javax.swing.JLabel();
        durationInput3 = new javax.swing.JTextField();
        dosisLbl3 = new javax.swing.JLabel();
        dosisInput3 = new javax.swing.JTextField();
        dateInput = new javax.swing.JFormattedTextField();

        fields = new ArrayList<JTextField>();
		fields.add(doctorInput);
		fields.add(dateInput);
		fields.add(symptomsInput);
		
        
        doctorLbl.setText("Nombre del doctor:");

        dateLbl.setText("Fecha");

        symptomsLbl.setText("Sintoma(s):");

        descriptionLbl.setText("Descripción:");

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane1.setViewportView(descriptionArea);

        saveBttn.setText("Guardar");

        titleLbl.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        titleLbl.setText("PRESCRIPCIÓN DE PACIENTE");

        medicineLbl.setText("Medicamento");

        medicineInput.setText("N/A");
        medicineInput2.setText("N/A");
        medicineInput3.setText("N/A");
        dosisInput.setText("N/A");
        dosisInput2.setText("N/A");
        dosisInput3.setText("N/A");
        durationInput.setText("N/A");
        durationInput2.setText("N/A");
        durationInput3.setText("N/A");
        durationLbl.setText("Días de duracion");
        
        dosisLbl.setText("Dosis diaria");
        
        medicineLbl2.setText("Medicamento");
        durationLbl2.setText("Días de duracion");
        dosisLbl2.setText("Dosis diaria");
        
        medicineLbl3.setText("Medicamento");
        durationLbl3.setText("Días de duracion");
        dosisLbl3.setText("Dosis diaria");
        
        dateInput.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(medicineLbl3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(doctorLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateLbl)
                        .addGap(161, 161, 161))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(durationLbl3)
                                        .addComponent(durationInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(187, 187, 187)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dosisLbl3)
                                        .addComponent(dosisInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(saveBttn, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(doctorInput, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(symptomsInput)
                                .addComponent(jScrollPane1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(durationLbl)
                                        .addComponent(symptomsLbl)
                                        .addComponent(descriptionLbl)
                                        .addComponent(medicineLbl)
                                        .addComponent(durationInput, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(180, 180, 180)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dosisLbl)
                                        .addComponent(dosisInput, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(53, 53, 53))
                                .addComponent(medicineInput, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(medicineInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(134, 134, 134)
                                        .addComponent(titleLbl))
                                    .addComponent(medicineLbl2)
                                    .addComponent(medicineInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(durationLbl2)
                                            .addComponent(durationInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(180, 180, 180)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dosisLbl2)
                                            .addComponent(dosisInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(titleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctorLbl)
                    .addComponent(dateLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(symptomsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(symptomsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(medicineLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicineInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationLbl)
                    .addComponent(dosisLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dosisInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicineLbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicineInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationLbl2)
                    .addComponent(dosisLbl2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dosisInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicineLbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicineInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosisLbl3)
                    .addComponent(durationLbl3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosisInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(durationInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBttn))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );


      
        
        bottonEvents();
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
    }
	
}
