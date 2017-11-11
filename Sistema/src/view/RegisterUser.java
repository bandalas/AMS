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

import controller.UserController;

public class RegisterUser extends JFrame implements Components{
	
	//	DATABASE
	private String name;
	private String username;
	private String password;
	private String phone;
	
	//	CONTROLLER
	private UserController uc;
	
	//	PANELS
	private JPanel employeePanel;
	private JPanel userPanel;
	private JPanel insideUserPanel;
	
	//	LABELS
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel instructionLabel;
	
	//	TEXT FIELDS
	private JTextField nameInput;
	private JTextField usernameInput;
	
	private ArrayList<JTextField> jtf;
	private ArrayList<JFormattedTextField> jftf;
	
	//	PASSWORD FIELD
	private JPasswordField passwordInput;
	
	//	FORMATTED TEXT FIELDS
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
			UserHome uh;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!checkEmptyFields()) {
					getInput();
					callDatabase();
					dispose();
					
					uh = new UserHome();
					
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
		this.phone = phoneInput.getText();
		this.username = usernameInput.getText();
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
			uc.addUser(name, username, password, phone);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private void connectDB() {
		try {
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
		
		uc = new UserController();
		
		employeePanel = new JPanel();
        separator = new JSeparator();
        titleLabel = new JLabel();
        nameLabel = new JLabel();
        nameInput = new JTextField();
        phoneLabel = new JLabel();
        phoneInput = new JFormattedTextField();
        jSeparator2 = new JSeparator();
        userPanel = new JPanel();
        insideUserPanel = new JPanel();
        passwordLabel = new JLabel();
        passwordInput = new JPasswordField();
        registerBttn = new JButton();
        instructionLabel = new JLabel();
        usernameInput = new JTextField();
        usernameLabel = new JLabel();
        
        jtf = new ArrayList<JTextField>();
        jtf.add(usernameInput);
        
        jftf = new ArrayList<JFormattedTextField>();
        jftf.add(phoneInput);
        
		
        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); 
        titleLabel.setText("REGISTRO USUARIO");
        nameLabel.setText("Nombre *");
        phoneLabel.setText("Telefono *");
        usernameLabel.setText("Usuario *");
        passwordLabel.setText("Contrasena *");
        registerBttn.setText("Registrar");
        instructionLabel.setText("Asignar el usuario y contrasena con la que el empleado tendra acceso.");
		
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
                                    .addComponent(phoneLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)))))
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
                .addGap(7, 7, 7)
                .addGroup(employeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        
        GroupLayout insideUserPanelLayout = new GroupLayout(insideUserPanel);
        insideUserPanel.setLayout(insideUserPanelLayout);
        insideUserPanelLayout.setHorizontalGroup(
            insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(insideUserPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameInput)
                    .addComponent(passwordInput, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addComponent(registerBttn, GroupLayout.Alignment.TRAILING)
        );
        insideUserPanelLayout.setVerticalGroup(
            insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(insideUserPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(insideUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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