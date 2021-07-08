package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Dimension;

import java.sql.*;
import javax.swing.JButton;

import menu.Signin;

public class LOGIN {

	private JFrame frame;
	private JPasswordField passwordField;
	public static java.sql.Connection connection = null;
	public static java.sql.Statement statement = null;
	public static  ResultSet rs = null;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN window = new LOGIN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LOGIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(new Color(52, 82, 181));
		frame.getContentPane().setLayout(null);
		frame.setSize(new Dimension(720, 600));
		frame.setResizable(false);
		
				
		

		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 345, 382);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUSTHBDATABASE = new JLabel("USTHB Data Base");
		lblUSTHBDATABASE.setForeground(new Color(52, 82, 181));
		lblUSTHBDATABASE.setFont(new Font("Arial Black", Font.ITALIC, 20));
		lblUSTHBDATABASE.setBounds(69, 273, 199, 39);
		panel.add(lblUSTHBDATABASE);
		
		JLabel lblLOGO = new JLabel("");
		lblLOGO.setIcon(new ImageIcon(LOGIN.class.getResource("/images/usthb.png")));
		lblLOGO.setBounds(64, 30, 225, 232);
		panel.add(lblLOGO);
		
		TextField userField = new TextField();
		userField.setBounds(418, 121, 222, 20);
		frame.getContentPane().add(userField);
		
		JSeparator separatorUSERNAME = new JSeparator();
		separatorUSERNAME.setBounds(418, 139, 222, 2);
		frame.getContentPane().add(separatorUSERNAME);
		
		JLabel lblUSERNAME = new JLabel("USERNAME");
		lblUSERNAME.setForeground(Color.WHITE);
		lblUSERNAME.setBounds(418, 95, 82, 20);
		frame.getContentPane().add(lblUSERNAME);
		
		JLabel lblPASSWORD = new JLabel("PASSWORD");
		lblPASSWORD.setForeground(Color.WHITE);
		lblPASSWORD.setBounds(418, 170, 82, 14);
		frame.getContentPane().add(lblPASSWORD);
		
		JSeparator separatorPASSWORD = new JSeparator();
		separatorPASSWORD.setBounds(418, 215, 222, 2);
		frame.getContentPane().add(separatorPASSWORD);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(418, 195, 222, 22);
		frame.getContentPane().add(passwordField);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 720, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Button buttonLOGIN = new Button("Log in");
		buttonLOGIN.setBackground(Color.WHITE);
		buttonLOGIN.setBounds(478, 272, 99, 35);
		frame.getContentPane().add(buttonLOGIN);
		buttonLOGIN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == buttonLOGIN) {
					String usr = userField.getText();
					String pwd = String.valueOf(passwordField.getText());
					
					if(Signin.loginInfo.containsKey(usr)) {				/*Signin.loginInfo.containsKey(usr)*/
						if(Signin.loginInfo.get(usr).equals(pwd)) {			/*Signin.loginInfo.get(usr).equals(pwd)*/
							try {		
								Class.forName("oracle.jdbc.driver.OracleDriver");
								
								connection = DriverManager.getConnection("jdbc:oracle:thin:BDDAdmin/TPAdmin@localhost");
								statement = connection.createStatement();
								System.out.println("DONE");
								frame.dispose();
								
								if(usr.compareTo("BDDAdmin") == 0) ADMIN.main(null);
								if(usr.compareTo("Etudiant") == 0) ETUDIANT.main(null);
								if(usr.compareTo("Enseignant") == 0) ENSEIGNANT.main(null);
								
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect informations");
						userField.setText("");
						passwordField.setText("");
					}
				}				
			}
		});
				

	}
	
	
}
