package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.RelativeController;

public class RegisterRelative extends JFrame {
	
	//	TEXT FIELD
	private JTextField addressInput;
	private JTextField cityInput;
	private JTextField firstNameInput;
	private JTextField lastNamesInput;
	private JTextField phoneInput;
	private ArrayList<JTextField> fields;

	private JLabel cityLbl;
	private JLabel lastNameLbl;
	private JPanel mainPanel;
	private JLabel nameLbl;
	private JButton nextBttn;
	private JLabel phoneLbl;
	private JLabel streetLbl;

	private String residentID;

	//	DATA BASE
	private String name;
	private String lastName;
	private String telephone;
	private String address;
	private String city;

	private RelativeController rc;
	 
	public RegisterRelative(String id){
		super();
		initComponents();
		this.residentID = id;
	}
	
	private void getInput() {
		this.name = firstNameInput.getText();
		this.lastName = lastNamesInput.getText();
		this.telephone = phoneInput.getText();
		this.address = addressInput.getText();
		this.city = cityInput.getText();
	}
	
	private boolean hasAllInputs() {
		for(JTextField f : fields) {
			if(f.getText().equals("")) return false; 
		}
		return true;
	}

	private void executeMssg() {
		JOptionPane.showMessageDialog(this, "Todos los campos tienen que estar llenos.",
				"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void bttnEvents() {
		nextBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (hasAllInputs()) {
					getInput();
					try {
						rc.addRelative(name, lastName, telephone, address, city);
						dispose();
						new RegisterCondition(residentID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					executeMssg();
				}
			}
			
		});
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		mainPanel = new JPanel();
		nameLbl = new JLabel();
		firstNameInput = new JTextField();
		lastNameLbl = new JLabel();
		lastNamesInput = new JTextField();
		phoneLbl = new JLabel();
		phoneInput = new JTextField();
		streetLbl = new JLabel();
		nextBttn = new JButton();
		cityInput = new JTextField();
		cityLbl = new JLabel();
		addressInput = new JTextField();
		
		rc = new RelativeController();
		
		fields = new ArrayList<JTextField>();
		fields.add(firstNameInput);
		fields.add(lastNamesInput);
		fields.add(phoneInput);
		fields.add(cityInput);
		fields.add(addressInput);

        nameLbl.setText("Nombre");
        lastNameLbl.setText("Apellido(s)");
        streetLbl.setText("Calle de la dirección");
        nextBttn.setText("Siguiente");
        cityLbl.setText("Ciudad");
        phoneLbl.setText("Número de teléfono");

        Border innerBorder = BorderFactory.createTitledBorder("	Datos Familiar Responsable		");
		Border outterBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		mainPanel.setBorder(BorderFactory.createCompoundBorder(outterBorder,innerBorder));
		
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(streetLbl)
                            .addComponent(phoneLbl)
                            .addComponent(lastNameLbl)
                            .addComponent(nameLbl)
                            .addComponent(firstNameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                            .addComponent(phoneInput)
                            .addComponent(lastNamesInput))
                        .addContainerGap())
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cityLbl)
                            .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextBttn)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lastNameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNamesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phoneLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(streetLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cityLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextBttn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        bttnEvents();
	}
	
}
