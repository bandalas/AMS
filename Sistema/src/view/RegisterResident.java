package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ResidentController;

public class RegisterResident extends JFrame{
	                   
    //DATABASE
	private String name;
	private String lastName;
	private String lastName2;
	private String birth;
	private String room;
	private String bed;
     
    //JLABEL
    private  JLabel bedLbl;
    private  JLabel birthLbl;
    private  JLabel lastName2Lbl;
    private  JLabel lastNamelbl;
    private  JLabel nameLbl;
    private  JLabel roomLbl;
    
    //JPANEL
    private  JPanel jPanel1;
    
    //JTEXT FIELD
    private  JTextField lastName2Input;
    private  JTextField lastNameInput;    
    private  JTextField nameInput;
    
    //JFORMATTED TEXTFIELD
    private  JFormattedTextField roomInput;
    private  JFormattedTextField birthInput;
    private  JFormattedTextField bedInput;
    
    private ArrayList<JTextField> jtf;
	private ArrayList<JFormattedTextField> jftf;
    
    private  JButton nextBttn;
    private ResidentController rc;
    
    private JComboBox<String> statusComboBx;
    private JLabel statusLbl;
    
    private boolean isEnabled;
    private String id;
	
	public RegisterResident(boolean status) {
		super();
		this.isEnabled = status;
		startProgram();
	}
	
	public RegisterResident(boolean status, String id) {
		super();
		this.isEnabled = status;
		this.id=id;
		startProgram();
	}
	
	private void startProgram() {
		initComponents();
		buttonsEvents();
	}
	
	private boolean hasCompletedFields() {
		int txtfield = 0;
		int formattedtxtfield = 0;
		
		for(JTextField j : jtf) {
			if (!j.getText().equals("")) txtfield++ ;
		}
		
		for(JFormattedTextField jt : jftf) {
			if(!jt.getText().equals("")) formattedtxtfield++;
		}

		return(txtfield == jtf.size() && formattedtxtfield == jftf.size());
		
	}
	
	private void getInput() {
		
		this.name = nameInput.getText();
		this.lastName = lastNameInput.getText();
		this.lastName2 = lastName2Input.getText();
		this.birth = birthInput.getText();
		this.room = roomInput.getText();
		this.bed = bedInput.getText();
		
	}
	
	private void executeMessage() {
		JOptionPane.showMessageDialog(this, "Todos los campos tienen que estar llenos.",
				"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	private void buttonsEvents() {
		nextBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(hasCompletedFields()) {
					try {
						getInput();
						rc.addResident(name, lastName, lastName2, birth, room, bed);
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
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
        jPanel1 = new JPanel();
        nameLbl = new JLabel();
        nameInput = new JTextField();
        lastNamelbl = new JLabel();
        lastNameInput = new JTextField();
        roomLbl = new JLabel();
        roomInput = new JFormattedTextField();
        birthLbl = new JLabel();
        lastName2Lbl = new JLabel();
        lastName2Input = new JTextField();
        bedLbl = new JLabel();
        bedInput = new JFormattedTextField();
        nextBttn = new JButton();
        birthInput = new JFormattedTextField(new SimpleDateFormat ("dd/MM/yyyy"));
        birthInput.setValue(new java.util.Date());
        
        jtf = new ArrayList<>();
        jftf = new ArrayList<>();
        
        jtf.add(nameInput);
        jtf.add(lastNameInput);
        jtf.add(lastName2Input);
        
        jftf.add(roomInput);
        jftf.add(birthInput);
        jftf.add(bedInput);
        
        rc = new ResidentController();
        
        nameLbl.setText("Nombre(s)");

        lastNamelbl.setText("Apellido Paterno");

        roomLbl.setText("Habitación");

        birthLbl.setText("Fecha de nacimiento");

        lastName2Lbl.setText("Apellido Materno");

        bedLbl.setText("Número de Cama");

        nextBttn.setText("Siguiente");
        
        statusComboBx = new JComboBox<>();
        statusLbl = new JLabel();
        
        statusComboBx.setModel(new DefaultComboBoxModel<>(new String[] { "Vivo", "Fallecido" }));

        statusLbl.setText("Estatus");
        
        if(!isEnabled) {
        		statusLbl.setVisible(false);
        		statusComboBx.setVisible(false);
        }else {
        		
        		statusLbl.setVisible(true);
        		statusComboBx.setVisible(true);
        		ArrayList<String> residentData = rc.getResident(id);
        		String[] lastNames = residentData.get(1).split(" ");
        		nameInput.setText(residentData.get(0));
        		String txt = "";
        		
        		if(lastNames.length <= 2) {
        			lastNameInput.setText(lastNames[0]);
        			lastName2Input.setText(lastNames[1]);
        		}else {
        			lastNameInput.setText(lastNames[0]);
        			for(int i=1; i<lastNames.length; i++) {
        				txt+=lastNames[i];
        			}
        			lastNameInput.setText(txt);
        		}
        		birthInput.setText(rc.dateConverter(residentData.get(2)));
        		roomInput.setText(residentData.get(4));
        		bedInput.setText(residentData.get(5));
        		
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastName2Lbl)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastNamelbl)
                                .addComponent(nameLbl))
                            .addGap(44, 44, 44)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastName2Input, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(nextBttn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(roomLbl)
                            .addComponent(birthLbl)
                            .addComponent(statusLbl, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthInput, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(roomInput, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bedLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bedInput, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(statusComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNamelbl)
                    .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastName2Lbl)
                    .addComponent(lastName2Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthLbl))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomLbl)
                    .addComponent(roomInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bedLbl)
                    .addComponent(bedInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextBttn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }

  
}
