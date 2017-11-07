package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

import controller.EmployeeController;
import controller.UserController;

public class RegisterUser extends JFrame implements Components{
	
	//	DATABASE
	private String name,lastName,secondLastName;
	private String birthdate;
	private String phoneNumber;
	private String registrationNumber;
	private String password;
	private String address;
	
	//	CONTROLLER
	private EmployeeController ec;
	private UserController uc;
	
	//	PANELS
	private JPanel employeePanel;
	private JPanel userPanel;
	private JPanel insideUserPanel;
	
	//	LABELS
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel lastNameLabel;
	private JLabel secondLastNameLabel;
	private JLabel birthLabel;
	private JLabel phoneLabel;
	private JLabel addressLabel;
	private JLabel nominaLabel;
	private JLabel passwordLabel;
	private JLabel instructionLabel;
	
	//	TEXT FIELDS
	private JTextField nameInput;
	private JTextField lastNameInput;
	private JTextField addressInput;
	private JTextField secondLastNameInput;
	private JTextField registeredNumberInput;
	
	private ArrayList<JTextField> jtf;
	private ArrayList<JFormattedTextField> jftf;
	
	//	PASSWORD FIELD
	private JPasswordField passwordInput;
	
	//	FORMATTED TEXT FIELDS
	private JFormattedTextField birthInput;
	private JFormattedTextField phoneInput;
	
	//	BUTTON
	private JButton registerBttn;
	
	//	SEPARATOR
	private JSeparator separator;
	private JSeparator jSeparator2;

	
	
	public RegisterUser() {
		super();
		initComponents();
	}
	
	public void respondToClick() {
		
		registerBttn.addActionListener(new ActionListener() {
			EmpleadoHome eh;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!checkEmptyFields()) {
					getInput();
					callDatabase();
					dispose();
					
					eh = new EmpleadoHome();
					
				}
				else {
					executeMessage();
				}
			}
			
		});
		
	}
	
	private void executeMessage() {
		JOptionPane.showMessageDialog(this, "Todos los campos tienen que estar llenos.",
				"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void getInput() {
		
		this.name = nameInput.getText();
		this.lastName = lastNameInput.getText();
		this.secondLastName = secondLastNameInput.getText();
		this.birthdate = birthInput.getText();
		this.phoneNumber = phoneInput.getText();
		this.registrationNumber = registeredNumberInput.getText();
		this.address = addressInput.getText();
		String pass = "";
		for(char a : passwordInput.getPassword()) {
			pass+=a;
		}
		this.password = pass;
		
	}
	
	private boolean checkEmptyFields() {
		for(JTextField i : jtf) {
			if(i.getText().equals("")) return true;
		}
		for(JFormattedTextField i : jftf) {
			if(i.getText().equals("")) return true;
		}
		if(passwordInput.getPassword().length == 0) return true;
		return false;
	}
	
	private void callDatabase() {
		connectDB();
		try {
			ec.addEmployee(registrationNumber, name, lastName, secondLastName, birthdate, phoneNumber,address);
			uc.addUser(registrationNumber, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private void connectDB() {
		try {
			ec.connect();
			uc.connect();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error conectando a la base de datos.",
					"Error de conección",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void initComponents() {
		setSize(500, 500);
		//	setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ec = new EmployeeController();
		uc = new UserController();
		
		employeePanel = new JPanel();
        separator = new JSeparator();
        titleLabel = new JLabel();
        nameLabel = new JLabel();
        lastNameLabel = new JLabel();
        nameInput = new JTextField();
        lastNameInput = new JTextField();
        birthLabel = new JLabel();
        birthInput = new JFormattedTextField(new SimpleDateFormat ("dd/MM/yyyy"));
        birthInput.setValue(new java.util.Date());
        phoneLabel = new JLabel();
        addressLabel = new JLabel();
        addressInput = new JTextField();
        secondLastNameLabel = new JLabel();
        secondLastNameInput = new JTextField();
        phoneInput = new JFormattedTextField();
        jSeparator2 = new JSeparator();
        userPanel = new JPanel();
        insideUserPanel = new JPanel();
        nominaLabel = new JLabel();
        passwordLabel = new JLabel();
        passwordInput = new JPasswordField();
        registerBttn = new JButton();
        instructionLabel = new JLabel();
        registeredNumberInput = new JTextField();
        
        jtf = new ArrayList<JTextField>();
        jtf.add(nameInput);
        jtf.add(lastNameInput);
        jtf.add(addressInput);
        jtf.add(secondLastNameInput);
        jtf.add(registeredNumberInput);
        
        jftf = new ArrayList<JFormattedTextField>();
        jftf.add(birthInput);
        jftf.add(phoneInput);
        
		
        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); 
        titleLabel.setText("REGISTRO EMPLEADO");
        nameLabel.setText("Nombre(s) *");
        lastNameLabel.setText("Apellido Paterno *");
        birthLabel.setText("Nacimiento *");
        phoneLabel.setText("Telefono *");
        addressLabel.setText("Dirección *");
        secondLastNameLabel.setText("Apellido Materno *");
        nominaLabel.setText("Nomina *");
        passwordLabel.setText("Contraseña *");
        registerBttn.setText("Registrar");
        instructionLabel.setText("Asignar la nomina y contraseña con la que el empleado tendrá acceso.");
		
        GroupLayout employeePanelLayout = new GroupLayout(employeePanel);
        
        Border innerBorder = BorderFactory.createTitledBorder("	Usuarios		");
		Border outterBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		userPanel.setBorder(BorderFactory.createCompoundBorder(outterBorder,innerBorder));
        
        employeePanel.setLayout(employeePanelLayout);
        employeePanelLayout.setHorizontalGroup(
            employeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separator)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(birthLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phoneLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(addressInput)
                                    .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, employeePanelLayout.createSequentialGroup()
                                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(secondLastNameLabel, GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lastNameInput, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(secondLastNameInput, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(birthInput, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        employeePanelLayout.setVerticalGroup(
            employeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(secondLastNameLabel)
                    .addComponent(secondLastNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(birthLabel)
                    .addComponent(birthInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        
        GroupLayout insideUserPanelLayout = new GroupLayout(insideUserPanel);
        insideUserPanel.setLayout(insideUserPanelLayout);
        insideUserPanelLayout.setHorizontalGroup(
            insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(insideUserPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(nominaLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(registeredNumberInput)
                    .addComponent(passwordInput, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addComponent(registerBttn, GroupLayout.Alignment.TRAILING)
        );
        insideUserPanelLayout.setVerticalGroup(
            insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(insideUserPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nominaLabel)
                    .addComponent(registeredNumberInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(20, 20, 20)
                .addComponent(registerBttn)
                .addGap(17, 17, 17))
        );

        GroupLayout userPanelLayout = new GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insideUserPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructionLabel)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructionLabel)
                .addGap(17, 17, 17)
                .addComponent(insideUserPanel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(employeePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(userPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(employeePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        respondToClick();
        setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}