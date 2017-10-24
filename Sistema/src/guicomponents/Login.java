package guicomponents;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import controller.UserController;

import javax.swing.border.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class Login extends JFrame implements Components{
	
	//	DATABASE
	private String username;
	private String password;
	
	private UserController uc;
	// Labels
	private JLabel userLabel;
	private JLabel passwordLabel;
	
	// Text Fields
	private 	JTextField userInput;
	private JPasswordField passwordInput;
	
	// Buttons
	private JButton loginBttn;
	
	private JPanel loginPanel;
	
	
	public Login() {
		super();
		initComponents();
	}
	
	public void initComponents() {
		uc = new UserController();
		
		setSize(500, 300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new java.awt.Color(219,212,216));
		
		userLabel = new JLabel();
		passwordLabel = new JLabel();
		userInput = new JTextField(10);
		passwordInput = new JPasswordField(10);
		loginBttn = new JButton();
		loginPanel = new JPanel();
		
		userLabel.setText("Usuario");
		passwordLabel.setText("Contraseña");
		loginBttn.setText("OK");
		
		userLabel.setLocation(new java.awt.Point(-32605, -32648));
		passwordLabel.setLocation(new java.awt.Point(-32605, -32648));
		
		
		GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
		
		Border innerBorder = BorderFactory.createTitledBorder("Inicio Sesión");
		Border outterBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		loginPanel.setBorder(BorderFactory.createCompoundBorder(outterBorder,innerBorder));
		
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
            .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(loginPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(loginBttn)
                        .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel)
                            .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel)
                            .addComponent(userInput, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        loginPanelLayout.setVerticalGroup(
        		loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(userLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(userInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(passwordLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(loginBttn)
                    .addGap(17, 17, 17))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();	
        
        setLocationRelativeTo(null);
		setVisible(true);
		
		
	//	getRootPane().setDefaultButton(loginBttn);
	//	loginBttn.requestFocus();
		
		respondToClick();
	
	}
	
	public void respondToClick() {
		
		loginBttn.addActionListener(new ActionListener() {
			private EmpleadoHome eh;

			@Override
			public void actionPerformed(ActionEvent e) {
				
				getInput();
				if(isRoot()) {
					eh = new EmpleadoHome();
					dispose();
				}else {
					try {
						if(canAccess()) {
							uc.disconnet();
							System.out.println("YASS BITCH");
						}else {
							uc.disconnet();
							System.out.println("NAHH BITCH");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		
	}
	
	private boolean canAccess() throws SQLException {
		connectDB();
		return uc.canLog(username,password);
	}
	private boolean isRoot() {
		if(username.equals("root") && password.equals("toor")) return true;
		return false;
	}
	public void getInput() {
		this.username = userInput.getText();
		
		String append="";
		for(char a : passwordInput.getPassword()) {
			append+=a;
		}
		
		this.password = append;
		
//		JOptionPane.showMessageDialog(this, username+"\n"+password);
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	private void connectDB() {
		try {
			uc.connect();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error conectando a la base de datos.",
					"Error de conección",JOptionPane.ERROR_MESSAGE);
		}
	}

}
